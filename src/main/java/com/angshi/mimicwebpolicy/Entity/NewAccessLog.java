package com.angshi.mimicwebpolicy.Entity;

import java.util.ArrayList;
import java.util.List;

public class NewAccessLog {
    private NewLogs logs;
    private List<NewLog> list;
    private String eventCount;

    public NewAccessLog(List<NewLog> list, String eventCount)
    {
        this.list = list;
        this.eventCount = eventCount;
    }
    public static List<Item> create(String ip,String timestamp,String verb,String request,String status,String size,String website,String remote){
        List<Item>li;
        List<String> listvalue=new ArrayList<String>();
        listvalue.add(ip);
        listvalue.add(timestamp.substring(0,20));
        listvalue.add("");
        listvalue.add(timestamp.substring(21));
        listvalue.add(verb+request);
        listvalue.add(status);
        listvalue.add(size);
        listvalue.add(website);
        listvalue.add(remote);
        List<String> listkey=new ArrayList<String>();
        listkey.add("srcAddress");
        listkey.add("starTime");
        listkey.add("srcUserName");
        listkey.add("deviceReceiptTime");
        listkey.add("requestBody");
        listkey.add("responseCode");
        listkey.add("bytesIn");
        listkey.add("httpReffer");
        listkey.add("accessAgent");
        li=Util.init(listkey, listvalue);
        li.add(new Item("projectGroupId","007"));
        li.add(new Item("projectGroup","珠海高凌"));
        li.add(new Item("sev","info"));
        return li;
    }

    public NewLogs getLogs() {
        return logs;
    }

    public void setLogs(NewLogs logs) {
        this.logs = logs;
    }

    public List<NewLog> getList() {
        return list;
    }

    public void setList(List<NewLog> list) {
        this.list = list;
    }

    public String getEventCount() {
        return eventCount;
    }

    public void setEventCount(String eventCount) {
        this.eventCount = eventCount;
    }

    @Override
    public String toString() {
        NewLogs logs =new NewLogs(eventCount,"jds","v1.0.0","192.168.1.166","AA.BB.CC.DD.EE.FF",list);
        String s=ObjToXml.convertToXml(logs);
        return s;
    }
}
