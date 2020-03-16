package com.angshi.mimicwebpolicy.Entity;

import java.util.ArrayList;
import java.util.List;

public class Errorlog {
    private List<Item> li;
    public Errorlog(String s) {
        super();
        List<String> listvalue=new ArrayList<String>();
        String[]str=s.split("\\|");
        for(String ss:str) {
            listvalue.add(ss);
        }
        List<String> listkey=new ArrayList<String>();
        listkey.add("durationTime");
        listkey.add("errorType");
        listkey.add("srcUserName");
        listkey.add("name");
        listkey.add("errorTag");
        listkey.add("suggestion");
        li=Util.init(listkey, listvalue);
        li.add(new Item("projectGroupId","007"));
        li.add(new Item("projectGroup","珠海高凌"));
        li.add(new Item("sev","info"));
    }
    @Override
    public String toString() {
        Logs logs =new Logs("1","jds","v1.0.0","192.168.1.166","AA.BB.CC.DD.EE.FF",new Log("errorlog","1.00","","拟态故障日志",li));
        String s=ObjToXml.convertToXml(logs);
        return s;
    }
}
