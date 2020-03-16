package com.angshi.mimicwebpolicy.Entity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Board {
    private String name;
    private String status;
    private String reason;
    private Interfaces interfaces;
    private String CpuUsage;
    private String MemUsage;
    private String SysDiskUsage;
    private String LogDiskUsage;

    @Override
    public String toString() {
        return "Board{" +
                "name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", reason='" + reason + '\'' +
                ", interfaces=" + interfaces +
                ", CpuUsage='" + CpuUsage + '\'' +
                ", MemUsage='" + MemUsage + '\'' +
                ", SysDiskUsage='" + SysDiskUsage + '\'' +
                ", LogDiskUsage='" + LogDiskUsage + '\'' +
                '}';
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

    public Interfaces getInterfaces() {
        return interfaces;
    }
@XmlElement
    public void setInterfaces(Interfaces interfaces) {
        this.interfaces = interfaces;
    }

    public String getCpuUsage() {
        return CpuUsage;
    }
    @XmlElement
    public void setCpuUsage(String cpuUsage) {
        CpuUsage = cpuUsage;
    }

    public String getMemUsage() {
        return MemUsage;
    }
    @XmlElement
    public void setMemUsage(String memUsage) {
        MemUsage = memUsage;
    }

    public String getSysDiskUsage() {
        return SysDiskUsage;
    }
    @XmlElement
    public void setSysDiskUsage(String sysDiskUsage) {
        SysDiskUsage = sysDiskUsage;
    }

    public String getLogDiskUsage() {
        return LogDiskUsage;
    }
    @XmlElement
    public void setLogDiskUsage(String logDiskUsage) {
        LogDiskUsage = logDiskUsage;
    }

    public Board(String name, String status, String reason, Interfaces interfaces, String cpuUsage, String memUsage, String sysDiskUsage, String logDiskUsage) {
        this.name = name;
        this.status = status;
        this.reason = reason;
        this.interfaces = interfaces;
        CpuUsage = cpuUsage;
        MemUsage = memUsage;
        SysDiskUsage = sysDiskUsage;
        LogDiskUsage = logDiskUsage;
    }
}
