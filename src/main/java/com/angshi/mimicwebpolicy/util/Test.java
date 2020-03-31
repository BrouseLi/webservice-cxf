package com.angshi.mimicwebpolicy.util;

import com.angshi.mimicwebpolicy.client.CxfClient;

public class Test {
    @org.junit.jupiter.api.Test
    public void testFillCommand()throws Exception{
        CxfClient cxfClient=new CxfClient();
        String str="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<Command>\n" +
                "    <ip>106.37.209.144</ip>\n" +
                "    <LevelId>6</LevelId>\n" +
                "    <version>1</version>\n" +
                "</Command>";
        System.out.println(str);
        cxfClient.createClient("http://47.105.105.105/mimicweb/policy?wsdl");
        Object[] objects = cxfClient.invoke(cxfClient.getClient(), "fillCommand",
                "Update_Command_1.00",str);
        String bytes = (String) objects[0];
        System.out.println(bytes);
        //writeFile("C:\\phpStudy\\nginx\\nginx.tar.gz",bytes);
    }
}
