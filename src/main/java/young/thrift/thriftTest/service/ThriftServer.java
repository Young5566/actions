package young.thrift.thriftTest.service;

import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import young.thrift.thriftTest.thrift.PersonService;

public class ThriftServer {
    public static void main(String[] args) throws Exception{
        TNonblockingServerSocket socket = new TNonblockingServerSocket(8899);
        THsHaServer.Args arg = new THsHaServer.Args(socket).minWorkerThreads(2).maxWorkerThreads(4);

        // 范型就是实现的接受类
        PersonService.Processor<PersonServiceImpl> processor = new PersonService.Processor<>(new PersonServiceImpl());

        // 表示协议层（压缩协议）
        arg.protocolFactory(new TCompactProtocol.Factory());

        // 表示传输协议层
        arg.transportFactory(new TFramedTransport.Factory());
        arg.processorFactory(new TProcessorFactory(processor));

        // 半同步半异步的server
        TServer server = new THsHaServer(arg);
        System.out.println("Thrift Server start!");
        server.serve();
    }
}
