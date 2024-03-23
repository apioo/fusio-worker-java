package org.fusioproject.worker;

import org.fusioproject.worker.generated.*;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.tools.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

@RestController
public class WorkerController {
    private final File actionsDir = new File("./actions");
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(WorkerApplication.class);

    @GetMapping("/")
    public About get() {
        About about = new About();
        about.setApiVersion("1.0.0");
        about.setLanguage("java");

        return about;
    }

    @PostMapping("/{action}")
    public Response execute(@PathVariable("action") String action, @RequestBody Execute execute) throws Exception {
        Connector connector = new Connector(execute.getConnections());
        Dispatcher dispatcher = new Dispatcher();
        Logger logger = new Logger();

        Class actionClass = this.loadClass(action);
        Class[] constructorSignature = {Connector.class, Dispatcher.class, Logger.class};
        Constructor constructor = actionClass.getDeclaredConstructor(constructorSignature);

        Object instance = constructor.newInstance(connector, dispatcher, logger);

        if (!(instance instanceof ActionInterface)) {
            throw new RuntimeException("Action must be an instance of ActionInterface");
        }

        ResponseHTTP httpResponse = ((ActionInterface) instance).handle(execute.getRequest(), execute.getContext());

        Response resp = new Response();
        resp.setEvents(dispatcher.getEvents());
        resp.setLogs(logger.getLogs());
        resp.setResponse(httpResponse);

        return resp;
    }

    @PutMapping("/{action}")
    public Message put(@PathVariable("action") String action, @RequestBody Update update) throws IOException {
        if (!this.actionsDir.exists()){
            if (!this.actionsDir.mkdirs()) {
                throw new RuntimeException("Could not create dir");
            }
        }

        String actionClass = this.getClassName(action);
        File actionFile = new File(this.actionsDir.getAbsolutePath() + "/" + actionClass + ".java");

        FileWriter file = new FileWriter(actionFile);
        file.write(update.getCode());
        file.close();

        // delete class file
        File classFile = new File(this.actionsDir.getAbsolutePath() + "/" + actionClass + ".class");
        if (classFile.exists()) {
            if (!classFile.delete()) {
                throw new RuntimeException("Could not delete file");
            }
        }

        // compile java file
        DiagnosticCollector<JavaFileObject> diagnosticListener = new DiagnosticCollector<>();
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(diagnosticListener, null, null);

        fileManager.setLocation(StandardLocation.CLASS_OUTPUT, Collections.singletonList(this.actionsDir));
        Iterable<? extends JavaFileObject> compilationUnits = fileManager.getJavaFileObjectsFromFiles(Collections.singletonList(actionFile));
        JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, diagnosticListener, null, null, compilationUnits);

        if (!task.call()) {
            List<String> errors = new ArrayList<>();
            for (Diagnostic diagnostic : diagnosticListener.getDiagnostics()) {
                errors.add(diagnostic.getMessage(Locale.getDefault()) + " on line " + diagnostic.getLineNumber() + " at column " + diagnostic.getColumnNumber());
            }

            throw new RuntimeException("Could not compile file: " + String.join(", ", errors));
        }

        fileManager.close();

        LOGGER.info("Updated action " + action);

        return newMessage(true, "Update action successful");
    }

    @DeleteMapping("/{action}")
    public Message delete(@PathVariable("action") String action) {
        if (!this.actionsDir.exists()){
            if (!this.actionsDir.mkdirs()) {
                throw new RuntimeException("Could not create dir");
            }
        }

        String actionClass = this.getClassName(action);

        // delete java file
        File actionFile = new File(this.actionsDir.getAbsolutePath() + "/" + actionClass + ".java");
        if (actionFile.exists()) {
            if (!actionFile.delete()) {
                throw new RuntimeException("Could not delete file");
            }
        }

        // delete class file
        File classFile = new File(this.actionsDir.getAbsolutePath() + "/" + actionClass + ".class");
        if (classFile.exists()) {
            if (!classFile.delete()) {
                throw new RuntimeException("Could not delete file");
            }
        }

        LOGGER.info("Delete action " + action);

        return newMessage(true, "Update action successful");
    }

    private Message newMessage(boolean success, String message) {
        Message ret = new Message();
        ret.setSuccess(success);
        ret.setMessage(message);

        return ret;
    }

    private String getClassName(String name) {
        return name.replace('-', '_');
    }

    private Class loadClass(String action) throws MalformedURLException, ClassNotFoundException {
        String className = this.getClassName(action);
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            URL[] urls = {this.actionsDir.toURI().toURL()};
            return (new URLClassLoader(urls)).loadClass(className);
        }
    }
}
