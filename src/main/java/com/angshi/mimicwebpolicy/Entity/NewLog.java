package com.angshi.mimicwebpolicy.Entity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "Log")
public class NewLog {
    public NewLog() {
        super();
        // TODO Auto-generated constructor stub
    }
    private String catObject;
    private String protocolVersion;
    private String eventId;
    private String name;

    private List<Item>list;
    public List<Item> getList() {
        return list;
    }
    @XmlElement(name = "Item")
    public void setList(List<Item> list) {
        this.list = list;
    }
    public NewLog(String catObject, String protocolVersion, String eventId, String name, List<Item>list) {
        super();
        this.catObject = catObject;
        this.protocolVersion = protocolVersion;
        this.eventId = eventId;
        this.name = name;
        this.list=list;
    }
    public String getCatObject() {
        return catObject;
    }
    @XmlAttribute
    public void setCatObject(String catObject) {
        this.catObject = catObject;
    }
    public String getProtocolVersion() {
        return protocolVersion;
    }
    @XmlAttribute
    public void setProtocolVersion(String protocolVersion) {
        this.protocolVersion = protocolVersion;
    }
    public String getEventId() {
        return eventId;
    }
    @XmlAttribute
    public void setEventId(String eventId) {
        this.eventId = eventId;
    }
    public String getName() {
        return name;
    }
    @XmlAttribute
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Log [catObject=" + catObject + ", protocolVersion=" + protocolVersion + ", eventId=" + eventId
                + ", name=" + name + "]";
    }

}
