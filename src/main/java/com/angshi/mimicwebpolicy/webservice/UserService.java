package com.angshi.mimicwebpolicy.webservice;

import com.angshi.mimicwebpolicy.Entity.User;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * @Author Brouseli
 * @Date 2020年 3月15日 14：52
 * @ClassName UserService
 * @Decription 测试用户服务接口
 */
@WebService
public interface UserService  {
    @WebMethod//标注该方法为webservice暴露的方法,用于向外公布，它修饰的方法是webservice方法，去掉也没影响的，类似一个注释信息。
    public User getUser(@WebParam(name = "userId") String userId);

    @WebMethod
    @WebResult(name="String",targetNamespace="")
    public String getUserName(@WebParam(name = "userId") String userId);

}
