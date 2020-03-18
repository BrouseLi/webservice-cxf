package com.angshi.mimicwebpolicy.webservice.impl;

import com.angshi.mimicwebpolicy.Entity.Message;
import com.angshi.mimicwebpolicy.Entity.ObjToXml;
import com.angshi.mimicwebpolicy.Entity.Soft;
import com.angshi.mimicwebpolicy.Entity.SoftUpdateResult;
import com.angshi.mimicwebpolicy.client.CxfClient;
import com.angshi.mimicwebpolicy.service.util.Softutil;
import com.angshi.mimicwebpolicy.webservice.UpdateSoftService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class UpdateSoftServiceimpl implements UpdateSoftService {
    @Override
    public String fillCommand(String oprCode, String commandXml) {
        if("".equals(oprCode)){
            Soft soft = Softutil.parseXmlToObj(commandXml);
            String softId=soft.getId();
            /**
             * 生成客户端获取源码包，并执行升级操作
             */
            try {
                //填写对方wsdl地址
               Object[] objects = CxfClient.invoke(CxfClient.createClient(""), "downloadPackages", softId);
                byte[] bytes = (byte[]) objects[0];
                //对返回值判断若不为空，则写入软件包，并将流传入另一接口
                if (objects[0]!=null){
                        //写入文件
                    boolean result = writeFile(soft.getVersion(),bytes);
                    if (result){
                        return  GenerrateSoftUpdateReslutXml("200",soft.getCode());
                    }else{
                        return  GenerrateSoftUpdateReslutXml("400",soft.getCode());
                    }
                }else{
                    log.warn("");
                }
            }catch (Exception e){
                log.warn(e.getLocalizedMessage());
            }
        }
        return "";
    }
    @Test
    public void parseXml(){
        System.out.println(Softutil.parseXmlToObj("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<Command>\n" +
                "    <code>192.168.1.36,192.168.1.37</code>\n" +
                "<id>1</id>\n" +
                "<version>1</version>\n" +
                "</Command>\n"));
    }
    public String GenerrateSoftUpdateReslutXml(String resultCode ,List<String>list ){
        List<SoftUpdateResult> list1=new ArrayList<SoftUpdateResult>();
        for (String s:list){
            if("200".equals(resultCode)){
                SoftUpdateResult softUpdateResult =new SoftUpdateResult(resultCode,"success",s);
                list1.add(softUpdateResult);
            }else{
                SoftUpdateResult softUpdateResult =new SoftUpdateResult(resultCode,"error",s);
                list1.add(softUpdateResult);
            }
        }
            return ObjToXml.convertToXml(new Message(list1));
    }
    @Test
    public void testGenerrateSoftUpdateReslutXml(){
        SoftUpdateResult softUpdateResult =new SoftUpdateResult("200","success","192.168.1.1");
        SoftUpdateResult softUpdateResult1=new SoftUpdateResult("200","success","192.168.1.2");
        List<SoftUpdateResult> list=new ArrayList<SoftUpdateResult>();
        list.add(softUpdateResult);
        list.add(softUpdateResult1);
        System.out.println(ObjToXml.convertToXml(new Message(list)));
    }
    public static boolean writeFile(String name,byte[] bytes){
        File file =new File(name);
        OutputStream outputStream=null;
        try{
             outputStream=new FileOutputStream(file);
            outputStream.write(bytes);
        }catch (Exception e){
            log.warn(e.getLocalizedMessage());
            return false;
        }finally {
            try {
                outputStream.flush();
                outputStream.close();
                return true;
            }catch(IOException e){
                log.warn(e.getLocalizedMessage());
                return false;
            }
        }

    }
}
