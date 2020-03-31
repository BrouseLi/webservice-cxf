package com.angshi.mimicwebpolicy.service;

import com.angshi.mimicwebpolicy.Entity.*;
import com.angshi.mimicwebpolicy.client.CxfClient;
import com.angshi.mimicwebpolicy.util.ParseOperationCommand;
import com.angshi.mimicwebpolicy.util.Policyutil;
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
import java.util.HashMap;
import java.util.List;

@WebService(serviceName ="policyService",
        endpointInterface = "com.angshi.mimicwebpolicy.service.PolicyService"
,targetNamespace="http://service.mimicwebpolicy.angshi.com/")
@Slf4j
@Component
public class PolicyServiceimpl implements PolicyService {
    private HashMap<String,String> hashMap=new HashMap<String, String>();
    public PolicyServiceimpl(){
        hashMap.put("majorityVoting","C:\\phpStudy\\nginx\\conf\\nginx.conf");
        hashMap.put("consensusVoting","C:\\phpStudy\\nginx\\conf\\nginx_test.conf");
    }
    @Override
    public String queryPolicy(String oprCode) {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<Policy>\n" +
                "<Item key=\"Policy.name\" value=\"\"/>" +
                "<Item key=\"ip\" value=\"192.168.1.1，192.168.1.2\"/>" +
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
        /**
         * 执行策略切换操作
         */

        /**
         * 保存并覆盖策略模板文件
         */

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
        if("Update_Command_1.00".equals(oprCode)){
            System.out.println(commandXml);
            Soft soft = Softutil.parseXmlToObj(commandXml);
            System.out.println("开始解析模板");
            String softId=soft.getId();
            if(!"".equals(softId)){
                System.out.println(softId);
                return  GenerrateSoftUpdateReslutXml("200",soft.getCode());
            }
            /**
             * 生成客户端获取源码包，并执行升级操作
             */
            try {
                //填写对方wsdl地址
                CxfClient cxfClient=new CxfClient();
                cxfClient.createClient("");
                Object[] objects = cxfClient.invoke(cxfClient.getClient(), "downloadPackages", softId);
                byte[] bytes = (byte[]) objects[0];
                //对返回值判断若不为空，则写入软件包，并将流传入另一接口
                if (objects[0]!=null){
                    //写入文件
                    boolean result = writeFile("C:\\phpStudy\\nginx\\nginx.tar.gz",bytes);
                    if (result){
                        /**
                         * 调用软件安装脚本
                         */
                        //String flag= SystemUtil.excuteShell("");//键入脚本执行命令
                        String flag="success";
                        if ("success".equals(flag)){
                            return  GenerrateSoftUpdateReslutXml("200",soft.getCode());
                        }else{
                            return  GenerrateSoftUpdateReslutXml("400",soft.getCode());
                        }
                    }else{
                        return  GenerrateSoftUpdateReslutXml("400",soft.getCode());
                    }
                }else{
                    log.warn("");
                }
            }catch (Exception e){
                log.warn(e.getLocalizedMessage());
            }
        }else if ("Update_Command_1.00".equals(oprCode)){
            /***
             * 执行维护性操作
             */
            //Command command =ParseOperationCommand.parseOPerationCommand(commandXml);
            //command.getOperation().getDelay();

        }else{
            List list = new ArrayList<SoftUpdateResult>();
            list.add(new SoftUpdateResult("400","error","操作码不正确，请重新确认操作码"));
            return ObjToXml.convertToXml(new Message(list));
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
    @Test
    public void gneratePolicy(){
        PolicyModule policy=new PolicyModule();
        //policy.setName("");
    }
    @Test
    public  void testSoftSownload()throws Exception{
        CxfClient cxfClient=new CxfClient();
        cxfClient.createClient("http://192.168.1.36:8084/zzjg/app/services/MTOMServerByte?wsdl");
        Object[] objects = cxfClient.invoke(cxfClient.getClient(), "downloadPackages", "5");
        byte[] bytes = (byte[]) objects[0];
        System.out.println(bytes.length);
        writeFile("C:\\phpStudy\\nginx\\nginx.tar.gz",bytes);
    }

}
