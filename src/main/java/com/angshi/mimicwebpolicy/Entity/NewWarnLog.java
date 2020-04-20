package com.angshi.mimicwebpolicy.Entity;

import java.util.ArrayList;
import java.util.List;

public class NewWarnLog {
    private NewLogs logs;
    private List<NewLog> Log;
    private String eventCount;

    public NewWarnLog(List<NewLog> list, String eventCount)
    {
        this.Log = list;
        this.eventCount = eventCount;
    }
    public static List<Item> create(String requestBody,String executeErrorNum,String responseCode,String bytesIn){
        List<Item>li;
        List<String> listvalue=new ArrayList<String>();
        listvalue.add(requestBody);
        listvalue.add(executeErrorNum);
        listvalue.add(responseCode);
        listvalue.add(bytesIn);
        List<String> listkey=new ArrayList<String>();
        listkey.add("requestBody");
        listkey.add("executeErrorNum");
        listkey.add("responseCode");
        listkey.add("bytesIn");
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

    public List<NewLog> getLog() {
        return Log;
    }

    public void setLog(List<NewLog> log) {
        Log = log;
    }

    public String getEventCount() {
        return eventCount;
    }

    public void setEventCount(String eventCount) {
        this.eventCount = eventCount;
    }

    @Override
    public String toString() {
        NewLogs logs =new NewLogs(eventCount,"jds","v1.0.0","192.168.1.166","AA.BB.CC.DD.EE.FF",Log);
        String s=ObjToXml.convertToXml(logs);
        return s;
    }
}
