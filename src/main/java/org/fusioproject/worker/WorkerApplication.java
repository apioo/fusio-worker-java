package org.fusioproject.worker;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.fusioproject.worker.incoming.*;
import org.fusioproject.worker.connector.Connections;
import org.fusioproject.worker.outgoing.Message;
import org.fusioproject.worker.outgoing.Response;
import org.fusioproject.worker.outgoing.Result;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.StandardLocation;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
@RestController
public class WorkerApplication {
	private Connections connections;
	private final File connectionsFile = new File("./connections.json");
	private final File actionDir = new File("./actions");

	@PostMapping("/connection")
	public Message connection(@RequestBody Connection connection) {
		try {
			this.connections = this.readConnections();
		} catch (IOException e) {
			return new Message(false, "Could not read connections file");
		}

		this.connections.put(connection.getName(), new org.fusioproject.worker.connector.Connection(connection.getType(), connection.getConfig()));

		try {
			String json = new ObjectMapper().writeValueAsString(this.connections);

			FileWriter file = new FileWriter(this.connectionsFile);
			file.write(json);
			file.close();
		} catch (IOException e) {
			return new Message(false, "Could not write connections file");
		}

		return new Message(true, "Update connections successful");
	}

	@PostMapping("/action")
	public Message action(@RequestBody Action action) {
		if (!this.actionDir.exists()){
			if (!this.actionDir.mkdirs()) {
				return new Message(false, "Could not create dir");
			}
		}

		File actionFile = new File(this.actionDir.getPath() + "/" + action.getName() + ".java");
		if (!actionFile.exists()) {
			return new Message(false, "Action " + action.getName() + " does not exist");
		}

		try {
			FileWriter file = new FileWriter(actionFile);
			file.write(action.getCode());
			file.close();

			// compile java file
			JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
			StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);

			fileManager.setLocation(StandardLocation.CLASS_OUTPUT, Collections.singletonList(this.actionDir));
			boolean success = compiler.getTask(null, fileManager, null, null, null, fileManager.getJavaFileObjectsFromFiles(Collections.singletonList(actionFile))).call();
			fileManager.close();

			if (!success) {
				return new Message(false, "Could not compile file");
			}
		} catch (IOException e) {
			return new Message(false, "Could not write action file");
		}

		return new Message(true, "Update action successful");
	}

	@PostMapping("/execute")
	public Object execute(@RequestBody Execute execute) {
		try {
			Connections connections = readConnections();
		} catch (IOException e) {
			return new Message(false, "Could not read connections file");
		}

		Connector connector = new Connector(connections);
		Dispatcher dispatcher = new Dispatcher();
		Logger logger = new Logger();

		Object[] arguments = {execute.getRequest(), execute.getContext()};
		Class[] signature = {Request.class, Context.class};

		try {
			Class actionClass = Class.forName(execute.getAction());
			Constructor constructor = actionClass.getDeclaredConstructor();

			Object action = constructor.newInstance(connector, dispatcher, logger);

			if (!(action instanceof ActionInterface)) {
				return new Message(false, "Provided an invalid action instance");
			}

			Method requestMethod = actionClass.getDeclaredMethod("request", signature);

			Response response = (Response) requestMethod.invoke(action, arguments);

			return new Result(response, dispatcher.getEvents(), logger.getLogs());
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException e) {
			return new Message(false, "Provided an invalid action instance");
		}
	}

	private Connections readConnections() throws IOException {
		List<String> lines = Files.readAllLines(this.connectionsFile.toPath());

		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < lines.size(); i++) {
			builder.append(lines.get(i));
			builder.append("\n");
		}

		return (new ObjectMapper()).readValue(builder.toString(), Connections.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(WorkerApplication.class, args);
	}
}
