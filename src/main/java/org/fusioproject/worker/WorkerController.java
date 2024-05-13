package org.fusioproject.worker;

import org.fusioproject.worker.runtime.Runtime;
import org.fusioproject.worker.runtime.generated.*;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@RestController
public class WorkerController {
    private final File actionsDir = new File("./actions");

    private Runtime runtime;

    public WorkerController() {
        this.runtime = new Runtime();
    }

    @GetMapping(value="/", produces="application/json")
    public About get() {
        return this.runtime.get();
    }

    @PostMapping(value="/{action}", consumes="application/json", produces="application/json")
    public Response execute(@PathVariable("action") String action, @RequestBody Execute execute) throws Exception {
        return this.runtime.run(this.getActionFile(action), execute);
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
        if (code == null) {
            throw new RuntimeException("Provided no code");
        }

        FileWriter file = new FileWriter(actionFile);
        file.write(code);
        file.close();

        return this.newMessage(true, "Update action successful");
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

        return this.newMessage(true, "Action successfully deleted");
    }

    private File getActionFile(String action) {
        if (!action.matches("^[A-Za-z0-9_-]{3,30}$")) {
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
