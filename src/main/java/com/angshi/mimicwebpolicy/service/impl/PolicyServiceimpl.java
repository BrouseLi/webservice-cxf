package com.angshi.mimicwebpolicy.service.impl;

import com.angshi.mimicwebpolicy.Entity.*;
import com.angshi.mimicwebpolicy.client.CxfClient;
import com.angshi.mimicwebpolicy.util.Policyutil;
import com.angshi.mimicwebpolicy.service.PolicyService;
import com.angshi.mimicwebpolicy.util.RecieveOSViewXml;
import com.angshi.mimicwebpolicy.util.Softutil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;

import javax.jws.WebService;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

@WebService(serviceName ="PolicyService",//对外发布服务名
        targetNamespace="http://service.mimicwebpolicy.angshi.com",//指定名称空间
        endpointInterface = "com.angshi.mimicwebpolicy.service.PolicyService")//地址空间
@Slf4j
@Component
public class PolicyServiceimpl  implements PolicyService {
    @Override
    public String queryPolicy(String oprCode) {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<Policy>\n" +
                "<Item key=\"Policy.name\" value=\"\"/>" +
                "<Item key=\"ip\" value=\"\"/>" +
                "</Policy>";
    }

    @Override
    public String queryPolicyParam(String key, int pageIndex, int pageSize) {
        return "";
    }

    @Override
    public String fillPolicy(String oprCode, String policyXml) {
        Policy policy = Policyutil.parseXmlToObj(policyXml);
        List<String> list = policy.getIp();

        Result result = new Result("200","成功","");
        return ObjToXml.convertToXml(result);
    }
    @Test
    public void test(){
        Result result = new Result("200","成功","");
        System.out.println(ObjToXml.convertToXml(result));
    }
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
                        /**
                         * 调用软件安装脚本
                         */
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
    @Override
    public String fillConfig(String oprCode, String configXml) {

        return null;
    }

    @Override
    public String queryView(String oprCode) {
        String str="";
        try{
            str=RecieveOSViewXml.osViewMessage();
        }catch (Exception e){
            log.warn(e.getLocalizedMessage());
        }
        return str;
    }
}
