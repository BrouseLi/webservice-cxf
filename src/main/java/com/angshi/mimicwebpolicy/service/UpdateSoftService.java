package com.angshi.mimicwebpolicy.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface UpdateSoftService {
    @WebMethod
    public String fillCommand(@WebParam String oprCode, @WebParam String commandXml);
}
