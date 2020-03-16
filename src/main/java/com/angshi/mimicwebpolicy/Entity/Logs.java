package com.angshi.mimicwebpolicy.Entity;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Logs")
public class Logs {
	private String eventCount;
	private String deviceSendProductName;
	private String deviceSendProductVersion;
	private String deviceAddress;
	private String deviceMacAddress;
	private Log log;
	public Logs(String eventCount, String deviceSendProductName, String deviceSendProductVersion, String deviceAddress,
			String deviceMacAddress, Log log) {
		super();
		this.eventCount = eventCount;
		this.deviceSendProductName = deviceSendProductName;
		this.deviceSendProductVersion = deviceSendProductVersion;
		this.deviceAddress = deviceAddress;
		this.deviceMacAddress = deviceMacAddress;
		this.log = log;
	}
	public Log getLog() {
		return log;
	}
	@XmlElement(name="Log")
	public void setLog(Log log) {
		this.log = log;
	}
	public Logs() {
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
				+ ", deviceMacAddress=" + deviceMacAddress + ", log=" + log + "]";
	}
	
}
