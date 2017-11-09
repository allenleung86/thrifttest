package test.thrift_test;  
  
import org.apache.thrift.TException;  
  
import test.thrift_test.TestService.Iface;  
  
//我们定义的test.thrift的接口的具体实现  
class TestServiceHandler implements Iface{  
  
    public String getStruct(int num, String name) throws TException {  
        return name + num;  
    }  
      
}