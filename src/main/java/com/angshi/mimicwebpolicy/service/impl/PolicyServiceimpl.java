package com.angshi.mimicwebpolicy.service.impl;

import com.angshi.mimicwebpolicy.Entity.ObjToXml;
import com.angshi.mimicwebpolicy.Entity.Policy;
import com.angshi.mimicwebpolicy.Entity.Result;
import com.angshi.mimicwebpolicy.util.Policyutil;
import com.angshi.mimicwebpolicy.service.PolicyService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;

import javax.jws.WebService;
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
}
