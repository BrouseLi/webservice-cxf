package com.angshi.mimicwebpolicy.Entity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "Logs")
public class NewLogs {
    private String eventCount;
    private String deviceSendProductName;
    private String deviceSendProductVersion;
    private String deviceAddress;
    private String deviceMacAddress;
    @XmlElement(name = "Log")
    private List<NewLog> Log;
   public NewLogs(String eventCount, String deviceSendProductName, String deviceSendProductVersion, String deviceAddress,
                String deviceMacAddress, List<NewLog> list) {
        super();
        this.eventCount = eventCount;
        this.deviceSendProductName = deviceSendProductName;
        this.deviceSendProductVersion = deviceSendProductVersion;
        this.deviceAddress = deviceAddress;
        this.deviceMacAddress = deviceMacAddress;
        this.Log = list;
    }

    public List<NewLog> getLog() {
        return Log;
    }

    public void setLog(List<NewLog> log) {
        Log = log;
    }

    /* public Log getLog() {
            return log;
        }
        @XmlElement(name="Log")
        public void setLog(Log log) {
            this.log = log;
        }*/
    public NewLogs() {
        super();
        // TODO Auto-generated constructor stub
    }
    public String getEventCount() {
        return eventCount;
    }
    @XmlAttribute
    public void setEventCount(String eventCount) {
        this.eventCount = eventCount;
    }
    public String getDeviceSendProductName() {
        return deviceSendProductName;
    }
    @XmlAttribute
    public void setDeviceSendProductName(String deviceSendProductName) {
        this.deviceSendProductName = deviceSendProductName;
    }
    public String getDeviceSendProductVersion() {
        return deviceSendProductVersion;
    }
    @XmlAttribute
    public void setDeviceSendProductVersion(String deviceSendProductVersion) {
        this.deviceSendProductVersion = deviceSendProductVersion;
    }
    public String getDeviceAddress() {
        return deviceAddress;
    }
    @XmlAttribute
    public void setDeviceAddress(String deviceAddress) {
        this.deviceAddress = deviceAddress;
    }
    public String getDeviceMacAddress() {
        return deviceMacAddress;
    }
    @XmlAttribute
    public void setDeviceMacAddress(String deviceMacAddress) {
        this.deviceMacAddress = deviceMacAddress;
    }
    @Override
    public String toString() {
        return "Logs [eventCount=" + eventCount + ", deviceSendProductName=" + deviceSendProductName
                + ", deviceSendProductVersion=" + deviceSendProductVersion + ", deviceAddress=" + deviceAddress
                + ", deviceMacAddress=" + deviceMacAddress + ", Log=" + Log + "]";
    }

}
