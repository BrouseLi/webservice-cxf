package com.angshi.mimicwebpolicy.Entity;
import java.util.ArrayList;
import java.util.List;

public class NewErrorLog {
    private NewLogs logs;
    private List<NewLog> Log;
    private String eventCount;
    public NewErrorLog(List<NewLog> list, String eventCount){
        this.Log = list;
        this.eventCount = eventCount;
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
    public static List<Item> create(String time,String type,String note,String suggestion,String level){
        List<Item>li;
        List<String> listvalue=new ArrayList<String>();
        listvalue.add(time);
        listvalue.add(type);
        listvalue.add(note);
        listvalue.add(suggestion);
        listvalue.add(level);
        List<String> listkey=new ArrayList<String>();
        listkey.add("error time");
        listkey.add("type");
        listkey.add("note");
        listkey.add("suggestion");
        listkey.add("level");
        li=Util.init(listkey, listvalue);
        li.add(new Item("projectGroupId","007"));
        li.add(new Item("projectGroup","珠海高凌"));
        li.add(new Item("sev","info"));
        return li;
    }
}
