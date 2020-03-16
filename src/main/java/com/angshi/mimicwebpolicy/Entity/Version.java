package com.angshi.mimicwebpolicy.Entity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "Version")
public class Version {
    private String description;
    private String value;

    public String getDescription() {
        return description;
    }
@XmlAttribute
    public void setDescription(String description) {
        this.description = description;
    }

    public Version(String description) {
        this.description = description;
    }

    public String getValue() {
        return value;
    }
@XmlValue
    public void setValue(String value) {
        this.value = value;
    }

    public Version(String description, String value) {
        this.description = description;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Version{" +
                "description='" + description + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
