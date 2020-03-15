package com.angshi.mimicwebpolicy.webservice.impl;

import com.angshi.mimicwebpolicy.webservice.PolicyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.jws.WebService;

@WebService(serviceName ="PolicyService",//对外发布服务名
        targetNamespace="http://webservice.mimicwebpolicy.angshi.com",//指定名称空间
        endpointInterface = "com.angshi.mimicwebpolicy.webservice.PolicyService")//地址空间
@Slf4j
@Component
public class PolicyServiceimpl  implements PolicyService {
    @Override
    public String queryPolicy(String oprCode) {
        return "";
    }

    @Override
    public String queryPolicyParam(String key, int pageIndex, int pageSize) {
        return "";
    }

    @Override
    public String fillPolicy(String oprCode, String policyXml) {
        return null;
    }
}
