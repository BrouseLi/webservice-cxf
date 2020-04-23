package com.angshi.mimicwebpolicy.service;

import com.angshi.mimicwebpolicy.Entity.*;
import com.angshi.mimicwebpolicy.client.CxfClient;
import com.angshi.mimicwebpolicy.util.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService(serviceName ="policyService",
        endpointInterface = "com.angshi.mimicwebpolicy.service.PolicyService"
,targetNamespace="http://service.mimicwebpolicy.angshi.com/")
@Slf4j
@Component
public class PolicyServiceimpl implements PolicyService {
    private final String path="/Users/liang/test/policy.xml";//策略文件存放位置
    private final String softWare="/User/liang/test/";
    @Override
    public String queryPolicy(String oprCode) {
        return FileUtil.getFileContent(path);
    }
    @Override
    public String onlineStart(String msg){
        return msg;
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

    @Override
    public String fillPolicy(String oprCode, String policyXml) {
        if ("Voter_policy_1.00".equals(oprCode)){
            if (!"".equals(policyXml)){
                /**
                 * 保存并覆盖策略模板文件
                 */
                FileUtil.writeFile(path,policyXml.getBytes());
                try{
                    Policy policy = Policyutil.parseXmlToObj(policyXml);
                    List<String> list = policy.getIp();
                    /**
                     * 执行策略切换操作
                     *
                     */
                    /*int count=0;
                    for (String ip:list){
                        String URL="http://"+ip+":8080/voterStrategy";
                        String result=SendHttpMessage.sendMessage(URL,policy.getName());
                        if (!"".equals(result)){
                            count++;
                        }
                    }*/
                    String strategy=policy.getName();
                    if (!"".equals(strategy)){
                        //System.out.println(strategy);
                        log.info(strategy);
                        return ObjToXml.convertToXml(new Result("200","成功","策略下发成功"));
                    }else{
                        return ObjToXml.convertToXml(new Result("400","失败","策略下发中断"));
                    }
                }catch (Exception e){
                    return ObjToXml.convertToXml(new Result("400","失败","策略格式错误，解析失败"));
                }
            }else{
                return ObjToXml.convertToXml(new Result("400","失败","策略内容为空"));
            }
        }else{
            return ObjToXml.convertToXml(new Result("400","失败","操作码不对"));
        }
    }

    @Override
    public String fillCommand(String oprCode, String commandXml) {
        if("Update_Command_1.00".equals(oprCode)){
            String fileName="nginx";
            System.out.println(commandXml);
            Soft soft = Softutil.parseXmlToObj(commandXml);
            System.out.println("开始解析模板");
            String softId=soft.getId();
            if(!"".equals(softId)){
                System.out.println(softId);
                return  XMLUtil.GenerrateSoftUpdateReslutXml("200",soft.getCode());
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
                    boolean result = FileUtil.writeFile(softWare+fileName+".tar.gz",bytes);
                    if (result){
                        /**
                         * 调用软件安装脚本
                         */
                        List<String>list=soft.getCode();
                        String res="";
                        for (String ip:list){
                            String str=SendHttpMessage.softUpdate(ip,fileName+".tar.gz"+"_"+soft.getVersion());
                            if("success".equals(str)){
                                res+="success";
                            }else{
                                res+="error";
                            }
                        }
                        switch (res){
                            case "successerror":
                                return XMLUtil.GenerrateSoftUpdateReslutXml("400,200",soft.getCode());
                            case "errorsuccess":
                                return XMLUtil.GenerrateSoftUpdateReslutXml("200,400",soft.getCode());
                            case "errorerror":
                                return XMLUtil.GenerrateSoftUpdateReslutXml("400,400",soft.getCode());
                            case "successsuccess":
                                return XMLUtil.GenerrateSoftUpdateReslutXml("200,200",soft.getCode());
                        }
                    }else{
                        return  XMLUtil.GenerrateSoftUpdateReslutXml("400",soft.getCode());
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
}
