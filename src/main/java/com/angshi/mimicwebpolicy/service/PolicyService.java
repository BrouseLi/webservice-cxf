package com.angshi.mimicwebpolicy.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface PolicyService {
    @WebMethod
    String queryPolicy(@WebParam String oprCode);
    @WebMethod
    String queryPolicyParam(@WebParam String key ,@WebParam int pageIndex,@WebParam int pageSize);
    @WebMethod
    String fillPolicy(@WebParam String oprCode,@WebParam String policyXml);
    @WebMethod
    public String fillCommand(@WebParam String oprCode, @WebParam String commandXml);
    @WebMethod
    public String  fillConfig(@WebParam String oprCode, @WebParam String configXml);
    @WebMethod
    public String queryView(@WebParam String oprCode);
}
