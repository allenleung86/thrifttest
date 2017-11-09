package test.thrift_test;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

public class Client {
	public static void main(String[] args) {
//		TTransport transport = new TSocket("localhost", 9090);
		TTransport transport = new TSocket("192.168.2.191", 9090);
		try {
			transport.open();
			TProtocol protocol = new TBinaryProtocol(transport);
			TestService.Client client = new TestService.Client(protocol);

			String result = client.getStruct(123, "test");
			System.out.println(result);
			transport.close();
		} catch (TTransportException e) {
			e.printStackTrace();
		} catch (TException e) {
			e.printStackTrace();
		}
	}
}