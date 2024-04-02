package org.fusioproject.worker;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import org.fusioproject.worker.generated.*;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@RestController
public class WorkerController {
    private final File actionsDir = new File("./actions");

    @GetMapping(value="/", produces="application/json")
    public About get() {
        About about = new About();
        about.setApiVersion("1.0.0");
        about.setLanguage("java");

        return about;
    }

    @PostMapping(value="/{action}", consumes="application/json", produces="application/json")
    public Response execute(@PathVariable("action") String action, @RequestBody Execute execute) throws Exception {
        Connector connector = new Connector(execute.getConnections());
        Dispatcher dispatcher = new Dispatcher();
        Logger logger = new Logger();
        ResponseBuilder responseBuilder = new ResponseBuilder();

        File actionFile = this.getActionFile(action);
        Binding binding = new Binding();
        binding.setProperty("request", execute.getRequest());
        binding.setProperty("context", execute.getContext());
        binding.setProperty("connector", connector);
        binding.setProperty("response", responseBuilder);
        binding.setProperty("dispatcher", dispatcher);
        binding.setProperty("logger", logger);

        GroovyShell shell = new GroovyShell(binding);
        shell.evaluate(actionFile);

        ResponseHTTP response = responseBuilder.getResponse();
        if (response == null) {
            response = new ResponseHTTP();
            response.setStatusCode(204);
        }

        Response result = new Response();
        result.setEvents(dispatcher.getEvents());
        result.setLogs(logger.getLogs());
        result.setResponse(response);

        return result;
    }

    @PutMapping(value="/{action}", consumes="application/json", produces="application/json")
    public Message put(@PathVariable("action") String action, @RequestBody Update update) throws IOException {
        if (!this.actionsDir.exists()){
            if (!this.actionsDir.mkdirs()) {
                throw new RuntimeException("Could not create dir");
            }
        }

        File actionFile = this.getActionFile(action);
        String code = update.getCode();

        FileWriter file = new FileWriter(actionFile);
        file.write(code);
        file.close();

        return newMessage(true, "Update action successful");
    }

    @DeleteMapping(value="/{action}", produces="application/json")
    public Message delete(@PathVariable("action") String action) {
        if (!this.actionsDir.exists()){
            if (!this.actionsDir.mkdirs()) {
                throw new RuntimeException("Could not create dir");
            }
        }

        File actionFile = this.getActionFile(action);
        if (actionFile.exists()) {
            if (!actionFile.delete()) {
                throw new RuntimeException("Could not delete action file");
            }
        }

        return newMessage(true, "Action successfully deleted");
    }

    private File getActionFile(String action) {
        if (!action.matches("/^[A-Za-z0-9_-]{3,30}$/")) {
            throw new RuntimeException("Provided no valid action name");
        }

        return new File(this.actionsDir.getAbsolutePath() + "/" + action + ".groovy");
    }

    private Message newMessage(boolean success, String message) {
        Message ret = new Message();
        ret.setSuccess(success);
        ret.setMessage(message);

        return ret;
    }
}
