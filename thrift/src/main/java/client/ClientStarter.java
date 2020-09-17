package client;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import thrift.ThriftDemoUserService;

public class ClientStarter {

    private static final String SERVER_IP = "127.0.0.1";

    private static final int SERVER_PORT = 8088;

    private static final int TIME_OUT = 3000;

    public void start() {
        TTransport tTransport = new TSocket(SERVER_IP, SERVER_PORT, TIME_OUT);
        TProtocol tProtocol = new TBinaryProtocol(tTransport);
        ThriftDemoUserService.Client client = new ThriftDemoUserService.Client(tProtocol);
        try {
            tTransport.open();
            System.out.println(client.getName(1));
            System.out.println(client.getName(2));
            System.out.println(client.getName(3));
            System.out.println(client.isExist("小明1"));
            System.out.println(client.isExist("小明2"));
            System.out.println(client.isExist("小明3"));
        } catch (TException e) {
            e.printStackTrace();
        } finally {
            tTransport.close();
        }
    }

    public static void main(String[] args) {
        ClientStarter clientStarter = new ClientStarter();
        clientStarter.start();
    }
}
