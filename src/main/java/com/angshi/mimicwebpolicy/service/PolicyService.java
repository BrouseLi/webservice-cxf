package com.angshi.mimicwebpolicy.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface PolicyService {
    @WebMethod
    String queryPolicy(@WebParam String oprCode);
    @WebMethod
    String fillPolicy(@WebParam String oprCode,@WebParam String policyXml);
    @WebMethod
    String fillCommand(@WebParam String oprCode, @WebParam String commandXml);
    @WebMethod
    String  fillConfig(@WebParam String oprCode, @WebParam String configXml);
    @WebMethod
    String queryView(@WebParam String oprCode);
    String onlineStart(String msg);
}
