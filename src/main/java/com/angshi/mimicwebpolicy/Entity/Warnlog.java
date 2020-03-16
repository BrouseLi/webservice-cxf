package com.angshi.mimicwebpolicy.Entity;

import java.util.ArrayList;
import java.util.List;

public class Warnlog {
    private List<Item> li;
    public Warnlog(String s) {
        super();
        List<String> listvalue=new ArrayList<String>();
        String[]str=s.split("\\|");
        for(String ss:str) {
            listvalue.add(ss);
        }
        List<String> listkey=new ArrayList<String>();
        listkey.add("requestBody");
        listkey.add("executeErrorNum");
        listkey.add("responseCode");
        listkey.add("bytesIn");
        li=Util.init(listkey, listvalue);
        li.add(new Item("projectGroupId","007"));
        li.add(new Item("projectGroup","珠海高凌"));
        li.add(new Item("sev","info"));
    }
    @Override
    public String toString() {
        Logs logs =new Logs("1","jds","v1.0.0","192.168.1.166","AA.BB.CC.DD.EE.FF",new Log("warnlog","1.00","","拟态web表决器告警日志",li));
        String s=ObjToXml.convertToXml(logs);
        return s;
    }
}
