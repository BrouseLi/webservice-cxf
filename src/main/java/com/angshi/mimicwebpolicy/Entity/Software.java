package com.angshi.mimicwebpolicy.Entity;

import org.omg.CORBA.VersionSpecHelper;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Software {

    private String isMater;
    private String masterIp;
    private Versions versions;
    private String CurrentUserName;
    private String CpuUsage;
    private String MemUsage;
    private String DiskUsage;
    private Modules modules;

    public Software(String isMater, String masterIp, Versions versions, String currentUserName, String cpuUsage, String memUsage, String diskUsage, Modules modules) {
        this.isMater = isMater;
        this.masterIp = masterIp;
        this.versions = versions;
        CurrentUserName = currentUserName;
        CpuUsage = cpuUsage;
        MemUsage = memUsage;
        DiskUsage = diskUsage;
        this.modules = modules;
    }

    public String getIsMater() {
        return isMater;
    }
@XmlAttribute
    public void setIsMater(String isMater) {
        this.isMater = isMater;
    }

    public String getMasterIp() {
        return masterIp;
    }
@XmlAttribute
    public void setMasterIp(String masterIp) {
        this.masterIp = masterIp;
    }

    public Versions getVersions() {
        return versions;
    }
@XmlElement
    public void setVersions(Versions versions) {
        this.versions = versions;
    }

    public String getCurrentUserName() {
        return CurrentUserName;
    }
@XmlElement
    public void setCurrentUserName(String currentUserName) {
        CurrentUserName = currentUserName;
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

    public String getDiskUsage() {
        return DiskUsage;
    }
@XmlElement
    public void setDiskUsage(String diskUsage) {
        DiskUsage = diskUsage;
    }

    public Modules getModules() {
        return modules;
    }
@XmlElement
    public void setModules(Modules modules) {
        this.modules = modules;
    }

    @Override
    public String toString() {
        return "Software{" +
                "isMater='" + isMater + '\'' +
                ", masterIp='" + masterIp + '\'' +
                ", versions=" + versions +
                ", CurrentUserName='" + CurrentUserName + '\'' +
                ", CpuUsage='" + CpuUsage + '\'' +
                ", MemUsage='" + MemUsage + '\'' +
                ", DiskUsage='" + DiskUsage + '\'' +
                ", modules=" + modules +
                '}';
    }
}
