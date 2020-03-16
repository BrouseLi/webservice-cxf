package com.angshi.mimicwebpolicy.Entity;

import java.util.ArrayList;
import java.util.List;

public class Registerlog {
    private List<Item> li;
    public Registerlog(String s) {
        super();
        List<String> listvalue=new ArrayList<String>();
        String[]str=s.split("\\|");
        for(String ss:str) {
            listvalue.add(ss);
        }
        List<String> listkey=new ArrayList<String>();
        listkey.add("registerTime");
        listkey.add("srcAddress");
        listkey.add("registerVoteStrage");
        li=Util.init(listkey, listvalue);
        li.add(new Item("projectGroupId","007"));
        li.add(new Item("projectGroup","珠海高凌"));
        li.add(new Item("security","info"));
    }
    @Override
    public String toString() {
        Logs logs =new Logs("1","jds","v1.0.0","192.168.1.166","AA.BB.CC.DD.EE.FF",new Log("accesslog","1.00","","拟态web表决器注册日志",li));
        String s=ObjToXml.convertToXml(logs);
        return s;
    }
}
