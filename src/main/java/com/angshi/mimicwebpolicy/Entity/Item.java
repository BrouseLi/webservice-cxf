package com.angshi.mimicwebpolicy.Entity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Item {
	private String key;
	private String value;
	public String getKey() {
		return key;
	}
	@XmlAttribute
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	@XmlAttribute
	public void setValue(String value) {
		this.value = value;
	}
	public Item(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "<Item key =\""+key+"\" value =\""+value+"\"/>";
	}
	
}
