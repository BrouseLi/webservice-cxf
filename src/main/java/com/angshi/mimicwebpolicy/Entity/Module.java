package com.angshi.mimicwebpolicy.Entity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Module")
public class Module {
    private String name;
    private String status;
    private String reason;

    public Module(String name, String status, String reason) {
        this.name = name;
        this.status = status;
        this.reason = reason;
    }

    public String getName() {
        return name;
    }
@XmlAttribute
    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }
@XmlAttribute
    public void setStatus(String status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }
@XmlAttribute
    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "Module{" +
                "name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }
}
