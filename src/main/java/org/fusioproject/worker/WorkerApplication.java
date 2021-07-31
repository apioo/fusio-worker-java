package org.fusioproject.worker;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.fusioproject.worker.generated.Worker;

public class WorkerApplication {
	public static void main(String[] args) {
		try {
			WorkerHandler handler = new WorkerHandler();
			Worker.Processor<WorkerHandler> processor = new Worker.Processor<>(handler);

			TServerTransport serverTransport = new TServerSocket(8082);
			TServer server = new TSimpleServer(new TServer.Args(serverTransport).processor(processor));

			System.out.println("Fusio Worker started");
			server.serve();
		} catch (Exception x) {
			x.printStackTrace();
		}
	}
}
