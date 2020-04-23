package com.angshi.mimicwebpolicy.client;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;


@Slf4j
@Setter
@Getter
public class CxfClient {
    private Client client;
    /**
     *
     * @param serverWsdlPath 服务端wsdl地址
     * @return 客户端引用
     */
    public void createClient(String serverWsdlPath){
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        client = dcf.createClient(serverWsdlPath);
    }
    public  Object[] invoke (Client client,String methodName,String ... param)throws Exception{
        Object[] objects = new Object[0];
        return client.invoke(methodName,param);
    }
    /**
     *
     * @param accesslogXml
     * @param client
     */
    public  void reportAccessLog(String accesslogXml,Client client){
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
    public  void reportWarnLog(Client client,String warnLogXml){
        try{
            Object[] objects = new Object[0];
            System.out.println("开始上报"+warnLogXml);
            client.invoke("reportLog","233913347993472","VoterAlert_Log_1.00",warnLogXml);
        }catch (Exception e){
            log.warn(e.getLocalizedMessage());
        }
    }
    /**
     *
     * @param client
     * @param ErrorLogXml
     */
    public  void reportErrorLog(Client client,String ErrorLogXml){
        try{
            Object[] objects = new Object[0];
            client.invoke("reportLog","233913347993472","VoterAlert_Log_1.00",ErrorLogXml);
        }catch (Exception e){
            log.warn(e.getLocalizedMessage());
        }
    }
}
