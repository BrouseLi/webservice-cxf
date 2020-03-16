package com.angshi.mimicwebpolicy.Entity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Interface {
    private String name;
    private String status;
    private String ip;
    private String mask;
    private String gateway;
    private String mac;
    private String speed;
    private String bandwidth;
    private String admin;


    public Interface(String name, String status, String ip, String mask, String gateway, String mac, String speed, String bandwidth, String admin) {
        this.name = name;
        this.status = status;
        this.ip = ip;
        this.mask = mask;
        this.gateway = gateway;
        this.mac = mac;
        this.speed = speed;
        this.bandwidth = bandwidth;
        this.admin = admin;
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

    public String getIp() {
        return ip;
    }
    @XmlAttribute
    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMask() {
        return mask;
    }
    @XmlAttribute
    public void setMask(String mask) {
        this.mask = mask;
    }

    public String getGateway() {
        return gateway;
    }
    @XmlAttribute
    public void setGateway(String gateway) {
        this.gateway = gateway;
    }

    public String getMac() {
        return mac;
    }
    @XmlAttribute
    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getSpeed() {
        return speed;
    }
    @XmlAttribute
    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getBandwidth() {
        return bandwidth;
    }
    @XmlAttribute
    public void setBandwidth(String bandwidth) {
        this.bandwidth = bandwidth;
    }

    public String getAdmin() {
        return admin;
    }
    @XmlAttribute
    public void setAdmin(String admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "Interface{" +
                "name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", ip='" + ip + '\'' +
                ", mask='" + mask + '\'' +
                ", gateway='" + gateway + '\'' +
                ", mac='" + mac + '\'' +
                ", speed='" + speed + '\'' +
                ", bandwidth='" + bandwidth + '\'' +
                ", admin='" + admin + '\'' +
                '}';
    }
}
