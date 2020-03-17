package com.angshi.mimicwebpolicy.Entity;


/*import com.WSSmCommUpperServiceImplServiceLocator;
import com.WSSmCommUpperServiceImplServiceSoapBindingStub;*/

public class HelloWorldClient {
  public static void main(String[] argv) {
      //try {
          //WSSmCommUpperServiceImplServiceLocator locator = new WSSmCommUpperServiceImplServiceLocator();
          //WSSmCommUpperServiceImplServiceSoapBindingStub service = (WSSmCommUpperServiceImplServiceSoapBindingStub) locator.getWSSmCommUpperServiceImplPort();
      //    try{
        	  String access=new Accesslog("172.69.22.88|2018.Aug.03|null|20:49:35-0400|GET /|200|29198|www.zhonghangshebei.com|Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)\" \"128.177.10.216").toString();
        	  String warn=new Warnlog("/internet/2014/0222/138.html|1|504,200|0,9998").toString();
              String error=new Errorlog("0|2|admin|后端服务器异常|软件|重新启动该服务").toString();
              //String register=new Registerlog("2020/01/09 11:18:20|192.168.1.1|majorityVoting").toString();
          //System.out.println(register);
        	  //service.reportLog("233913347993472","VoterVist_Log_1.00",access);
              //service.reportLog("233913347993472","VoterAlert_Log_1.00",warn);
              //service.reportLog("233913347993472","VoterErrot_Log_1.00",error);
              //service.reportLog("233913347993472","VoterRegisty_Log_1.00",register);
          //}catch (java.rmi.RemoteException e){
            // e.printStackTrace();
          //}
          // If authorization is required
          //((WSSmCommUpperImplServiceSoapBindingStub)service).setUsername("user3");
          //((WSSmCommUpperImplServiceSoapBindingStub)service).setPassword("pass3");
          // invoke business method

     /* } catch (javax.xml.rpc.ServiceException ex) {
          ex.printStackTrace();
      }*/
  }
}
