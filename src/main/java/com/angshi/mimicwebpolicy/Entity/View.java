package com.angshi.mimicwebpolicy.Entity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class View {
    private String code;
    private String version;
    private String id;
    private String description;
    private Hardware hardware;
    private Software software;

    @Override
    public String toString() {
        return "View{" +
                "code='" + code + '\'' +
                ", version='" + version + '\'' +
                ", id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", hardware=" + hardware +
                ", software=" + software +
                '}';
    }

    public Hardware getHardware() {
        return hardware;
    }
@XmlElement
    public void setHardware(Hardware hardware) {
        this.hardware = hardware;
    }

    public Software getSoftware() {
        return software;
    }
@XmlElement
    public void setSoftware(Software software) {
        this.software = software;
    }

    public View(String code, String version, String id, String description, Hardware hardware, Software software) {
        this.code = code;
        this.version = version;
        this.id = id;
        this.description = description;
        this.hardware = hardware;
        this.software = software;
    }

    public String getCode() {
        return code;
    }
    @XmlAttribute
    public void setCode(String code) {
        this.code = code;
    }

    public String getVersion() {
        return version;
    }
    @XmlAttribute
    public void setVersion(String version) {
        this.version = version;
    }

    public String getId() {
        return id;
    }
    @XmlAttribute
    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }
    @XmlAttribute
    public void setDescription(String description) {
        this.description = description;
    }
}