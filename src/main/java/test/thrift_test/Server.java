package test.thrift_test;  
  
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TServer.Args;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;
  
public class Server   
{  
    public static void main( String[] args ){  
        try {  
            TestService.Processor processor = new TestService.Processor(new TestServiceHandler());  
              
        TServerTransport serverTransport = new TServerSocket(9090);  
        TServer server = new TSimpleServer(new Args(serverTransport).processor(processor));  
        server.serve();  
              
    } catch (TTransportException e) {  
        e.printStackTrace();  
    }  
    }  
}  