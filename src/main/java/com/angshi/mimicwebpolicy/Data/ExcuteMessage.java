package com.angshi.mimicwebpolicy.Data;

import java.util.*;

public class ExcuteMessage {
    private ExcuteMessage(){
        List<String>tomcat=initIp("");
        map.put("tomcat",tomcat);
        List<String>jetty=initIp("");
        map.put("jetty",jetty);
        List<String>resin=initIp("");
        map.put("resin",resin);
    }
    private Map<String, List<String>> map =new HashMap<String, List<String>>();
    public ExcuteMessage  instance(){
        return new ExcuteMessage();
    }
    private static List<String> initIp(String ipList){
       List<String>list= Arrays.asList(ipList.split(","));
        return list;
    }
}
