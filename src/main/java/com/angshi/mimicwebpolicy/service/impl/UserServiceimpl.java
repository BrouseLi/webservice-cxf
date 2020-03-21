package com.angshi.mimicwebpolicy.service.impl;

import com.angshi.mimicwebpolicy.Entity.User;
import com.angshi.mimicwebpolicy.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.jws.WebService;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Author Brouseli
 * @Date 2020年3月15日 15：14
 * @ClassName UserServiceimpl
 * @Decription 实现接口
 */
@WebService(serviceName ="UserService",//对外发布服务名
        targetNamespace="http://service.mimicwebpolicy.angshi.com",//指定名称空间
        endpointInterface = "com.angshi.mimicwebpolicy.service.UserService")//地址空间
@Slf4j
@Component
public class UserServiceimpl implements UserService {
    private Map<String, User> userMap = new HashMap<String, User>();
    public UserServiceimpl() {
        System.out.println("向实体类插入数据");
        User user = new User();
        user.setUserId(UUID.randomUUID().toString().replace("-", ""));
        user.setUserName("test1");
        user.setEmail("maplefix@163.xom");
        userMap.put(user.getUserId(), user);

        user = new User();
        user.setUserId(UUID.randomUUID().toString().replace("-", ""));
        user.setUserName("test2");
        user.setEmail("maplefix@163.xom");
        userMap.put(user.getUserId(), user);

        user = new User();
        user.setUserId(UUID.randomUUID().toString().replace("-", ""));
        user.setUserName("test3");
        user.setEmail("maplefix@163.xom");
        userMap.put(user.getUserId(), user);
    }
    @Override
    public String getUserName(String userId) {
        return "userId为：" + userId;
    }
    @Override
    public User getUser(String userId) {
        log.info("userMap是:"+userMap);
        return userMap.get(userId);
    }
}
