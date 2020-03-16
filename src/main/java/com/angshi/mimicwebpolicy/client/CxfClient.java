package com.angshi.mimicwebpolicy.client;
import lombok.extern.slf4j.Slf4j;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.springframework.boot.test.context.TestComponent;

@Slf4j
public class CxfClient {
    public static void main() {
        // client.getOutInterceptors().add(new ClientLoginInterceptor(USER_NAME, PASS_WORD));
        Client client=createClient("http://127.0.0.1:8080/mimicweb/policy?wsdl");
        Object[] objects = new Object[0];
        try {
            objects = client.invoke("getUserName", "maple");
            System.out.println("返回数据:" + objects[0]);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param serverWsdlPath 服务端wsdl地址
     * @return 客户端引用
     */
    public static Client createClient(String serverWsdlPath){
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient(serverWsdlPath);
        return client;
    }

    /**
     *
     * @param accesslogXml
     * @param client
     */
    public static void reportAccessLog(String accesslogXml,Client client){
        try{
            Object[] objects = new Object[0];
            client.invoke("reportLog", "233913347993472","VoterVist_Log_1.00",accesslogXml);
        }catch (Exception e){
            log.warn(e.getLocalizedMessage());
        }
    }

    /**
     *
     * @param client
     * @param warnLogXml
     */
    public static void reportWarnLog(Client client,String warnLogXml){
        try{
            Object[] objects = new Object[0];
            client.invoke("reportLog","233913347993472","VoterAlert_Log_1.00",warnLogXml);
        }catch (Exception e){
            log.warn(e.getLocalizedMessage());
        }
    }

}
