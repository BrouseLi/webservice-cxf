package com.angshi.mimicwebpolicy.test;

import com.angshi.mimicwebpolicy.Entity.*;
import com.angshi.mimicwebpolicy.client.CxfClient;
import com.angshi.mimicwebpolicy.util.FileUtil;
import com.angshi.mimicwebpolicy.util.SendHttpMessage;
import com.angshi.mimicwebpolicy.util.Softutil;
import com.angshi.mimicwebpolicy.util.XMLUtil;
import org.dom4j.DocumentException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test {
    /*@org.junit.jupiter.api.Test
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
    @org.junit.jupiter.api.Test
    public void testGenerrateSoftUpdateReslutXml(){
        SoftUpdateResult softUpdateResult =new SoftUpdateResult("200","success","192.168.1.1");
        SoftUpdateResult softUpdateResult1=new SoftUpdateResult("200","success","192.168.1.2");
        List<SoftUpdateResult> list=new ArrayList<SoftUpdateResult>();
        list.add(softUpdateResult);
        list.add(softUpdateResult1);
        System.out.println(ObjToXml.convertToXml(new Message(list)));
    }


    @org.junit.jupiter.api.Test
    public void gneratePolicy(){
        PolicyModule policy=new PolicyModule();
        //policy.setName("");
    }
    @org.junit.jupiter.api.Test
    public  void testSoftSownload()throws Exception{
        CxfClient cxfClient=new CxfClient();
        cxfClient.createClient("http://299kr87613.zicp.vip:34889/zzjg/app/services/MTOMServerByte?wsdl");
        Object[] objects = cxfClient.invoke(cxfClient.getClient(), "downloadPackages", "11");
        byte[] bytes = (byte[]) objects[0];
        System.out.println(bytes.length);
        FileUtil.writeFile("C:\\phpStudy\\nginx\\11.txt",bytes);
    }

    @org.junit.jupiter.api.Test
    public void parseXml(){
        System.out.println(Softutil.parseXmlToObj("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<Command>\n" +
                "    <code>192.168.1.36,192.168.1.37</code>\n" +
                "<id>1</id>\n" +
                "<version>1</version>\n" +
                "</Command>\n"));
    }
    @org.junit.jupiter.api.Test
    public void testHttpclient() throws IOException {
        String url = "http://127.0.0.1:81/voterStrategy";
        System.out.println(SendHttpMessage.sendMessage(url,"ll"));
    }
    @org.junit.jupiter.api.Test
    public void test() throws IOException, DocumentException {
        //Result result = new Result("200","成功","");
        //System.out.println(ObjToXml.convertToXml(result));
    }
    @org.junit.jupiter.api.Test
    public static void testReportLog() {
        System.out.println(FileUtil.getFileContent("/Users/liang/Documents/warn.xml"));
    }*/
    @org.junit.jupiter.api.Test
    public  void testSoftSownload()throws Exception{
        CxfClient cxfClient=new CxfClient();
        cxfClient.createClient("http://299kr87613.zicp.vip:34889/zzjg/app/services/MTOMServerByte?wsdl");
        Object[] objects = cxfClient.invoke(cxfClient.getClient(), "getUpList", "1.15.20");
        String str = (String) objects[0];
        System.out.println(str);
        //FileUtil.writeFile("C:\\phpStudy\\nginx\\11.txt",bytes);
    }
}
