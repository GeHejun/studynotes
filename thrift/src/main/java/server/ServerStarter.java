package server;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;
import org.apache.thrift.transport.TTransportFactory;
import thrift.ThriftDemoUserService;

public class ServerStarter {

    public void start() {
        try {
            ThriftDemoUserService.Processor<ThriftDemoUserService.Iface> processor = new ThriftDemoUserService.Processor<>(new ServerThriftDemoUserServiceImpl());
            TServerTransport transport = new TServerSocket(8088);
            TThreadPoolServer.Args args = new TThreadPoolServer.Args(transport);
            args.processor(processor);
            args.protocolFactory(new TBinaryProtocol.Factory());
            args.transportFactory(new TTransportFactory());
            args.minWorkerThreads(5);
            args.maxWorkerThreads(Runtime.getRuntime().availableProcessors() * 2);
            TServer tServer = new TThreadPoolServer(args);
            tServer.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ServerStarter serverStarter = new ServerStarter();
        serverStarter.start();
    }
}
