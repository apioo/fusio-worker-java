package org.fusioproject.worker;

import org.fusioproject.worker.generated.*;
import org.springframework.web.bind.annotation.*;

import javax.tools.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

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

        Class<?> actionClass = this.loadClass(action);
        Class<?>[] constructorSignature = {Connector.class, Dispatcher.class, Logger.class};
        Constructor<?> constructor = actionClass.getDeclaredConstructor(constructorSignature);

        Object instance = constructor.newInstance(connector, dispatcher, logger);

        if (!(instance instanceof ActionInterface)) {
            throw new RuntimeException("Action must be an instance of ActionInterface");
        }

        ResponseHTTP response = ((ActionInterface) instance).handle(execute.getRequest(), execute.getContext());

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

        File actionClass = this.getActionClass(action);
        File actionFile = this.getActionFile(action);
        String code = update.getCode();

        FileWriter file = new FileWriter(actionFile);
        file.write(code);
        file.close();

        compileClass(actionClass, actionFile);

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

        File actionClass = this.getActionClass(action);
        if (actionClass.exists()) {
            if (!actionClass.delete()) {
                throw new RuntimeException("Could not delete action class");
            }
        }

        return newMessage(true, "Action successfully deleted");
    }

    private File getActionClass(String action) {
        return new File(this.actionsDir.getAbsolutePath() + "/" + this.getActionClassName(action) + ".class");
    }

    private String getActionClassName(String action) {
        if (!action.matches("/^[A-Za-z0-9_-]{3,30}$/")) {
            throw new RuntimeException("Provided no valid action name");
        }

        action = action.replace('-', '_');

        return action;
    }

    private File getActionFile(String action) {
        if (!action.matches("/^[A-Za-z0-9_-]{3,30}$/")) {
            throw new RuntimeException("Provided no valid action name");
        }

        return new File(this.actionsDir.getAbsolutePath() + "/" + action + ".java");
    }

    private Message newMessage(boolean success, String message) {
        Message ret = new Message();
        ret.setSuccess(success);
        ret.setMessage(message);

        return ret;
    }

    private void compileClass(File actionClass, File actionFile) throws IOException {
        if (actionClass.exists()) {
            if (!actionClass.delete()) {
                throw new RuntimeException("Could not delete action class");
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
    }

    private Class<?> loadClass(String action) throws IOException, ClassNotFoundException {
        String className = this.getActionClassName(action);
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            URL[] urls = {
                this.actionsDir.toURI().toURL()
            };

            URLClassLoader loader = URLClassLoader.newInstance(urls);
            Class<?> result = loader.loadClass(className);
            loader.close();

            return result;
        }
    }
}
