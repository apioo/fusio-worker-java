package org.fusioproject.worker;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.fusioproject.worker.connector.Connections;
import org.fusioproject.worker.generated.*;
import org.slf4j.LoggerFactory;

import javax.tools.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.util.*;

public class WorkerHandler implements Worker.Iface {
    private Connections connections;
    private final File connectionsFile = new File("./connections.json");
    private final File actionDir = new File("./actions");
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(WorkerApplication.class);

    @Override
    public Message setConnection(Connection connection) {
        try {
            this.connections = this.readConnections();

            if (connection.getName() == null || connection.getName().isEmpty()) {
                throw new RuntimeException("Connection name not provided");
            }

            this.connections.put(connection.getName(), new org.fusioproject.worker.connector.Connection(connection.getType(), connection.getConfig()));

            String json = new ObjectMapper().writeValueAsString(this.connections);

            FileWriter file = new FileWriter(this.connectionsFile);
            file.write(json);
            file.close();

            LOGGER.info("Updated connections");

            return new Message(true, "Update connections successful");
        } catch (Exception e) {
            return new Message(false, "An error occurred: " + e.getMessage());
        }
    }

    @Override
    public Message setAction(Action action) {
        try {
            if (!this.actionDir.exists()){
                if (!this.actionDir.mkdirs()) {
                    throw new RuntimeException("Could not create dir");
                }
            }

            String actionClass = this.getClassName(action.getName());
            File actionFile = new File(this.actionDir.getAbsolutePath() + "/" + actionClass + ".java");

            FileWriter file = new FileWriter(actionFile);
            file.write(action.getCode());
            file.close();

            // delete class file
            File classFile = new File(this.actionDir.getAbsolutePath() + "/" + actionClass + ".class");
            if (classFile.exists()) {
                classFile.delete();
            }

            // compile java file
            DiagnosticCollector<JavaFileObject> diagnosticListener = new DiagnosticCollector<JavaFileObject>();
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager fileManager = compiler.getStandardFileManager(diagnosticListener, null, null);

            fileManager.setLocation(StandardLocation.CLASS_OUTPUT, Collections.singletonList(this.actionDir));
            Iterable<? extends JavaFileObject> compilationUnits = fileManager.getJavaFileObjectsFromFiles(Collections.singletonList(actionFile));
            JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, diagnosticListener, null, null, compilationUnits);

            if (!task.call()) {
                List<String> errors = new ArrayList<String>();
                for (Diagnostic diagnostic : diagnosticListener.getDiagnostics()) {
                    errors.add(diagnostic.getMessage(Locale.getDefault()) + " on line " + diagnostic.getLineNumber() + " at column " + diagnostic.getColumnNumber());
                }

                throw new RuntimeException("Could not compile file: " + String.join(", ", errors));
            }

            fileManager.close();

            LOGGER.info("Updated action " + action.getName());

            return new Message(true, "Update action successful");
        } catch (Exception e) {
            return new Message(false, "An error occurred: " + e.getMessage());
        }
    }

    @Override
    public Result executeAction(Execute execute) {
        try {
            this.connections = readConnections();

            Connector connector = new Connector(this.connections);
            Dispatcher dispatcher = new Dispatcher();
            Logger logger = new Logger();

            Class actionClass = this.loadClass(execute.getAction());
            Class[] constructorSignature = {Connector.class, Dispatcher.class, Logger.class};
            Constructor constructor = actionClass.getDeclaredConstructor(constructorSignature);

            Object action = constructor.newInstance(connector, dispatcher, logger);

            if (action instanceof ActionInterface) {
                Response response = ((ActionInterface) action).handle(execute.getRequest(), execute.getContext());

                return new Result(response, dispatcher.getEvents(), logger.getLogs());
            } else {
                throw new RuntimeException("Action must be an instance of ActionInterface");
            }
        } catch (Exception e) {
            HashMap<String, Object> body = new HashMap<String, Object>();
            body.put("success", false);
            body.put("message", "An error occurred: " + e.getMessage());

            Response response;
            try {
                response = new Response(500, new HashMap<String, String>(), (new JsonMapper()).writeValueAsString(body));
            } catch (JsonProcessingException ex) {
                response = new Response(500, new HashMap<String, String>(), "{\"success\": false, \"message\": \"Could not serialize error JSON response\"}");
            }

            return new Result(response, new ArrayList<Event>(), new ArrayList<Log>());
        }
    }

    private Connections readConnections() throws IOException {
        if (!this.connectionsFile.exists()) {
            return new Connections();
        }

        List<String> lines = Files.readAllLines(this.connectionsFile.toPath());

        StringBuilder builder = new StringBuilder();
        for (String line : lines) {
            builder.append(line);
            builder.append("\n");
        }

        return (new ObjectMapper()).readValue(builder.toString(), Connections.class);
    }

    private String getClassName(String name) {
        return name.replace('-', '_');
    }

    private Class loadClass(String action) throws MalformedURLException, ClassNotFoundException {
        String className = this.getClassName(action);
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            URL[] urls = {this.actionDir.toURI().toURL()};
            return (new URLClassLoader(urls)).loadClass(className);
        }
    }
}
