package com.angshi.mimicwebpolicy.Entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Versions")
public class Versions {
    private Version version1;
    private Version version2;

    @Override
    public String toString() {
        return "Versions{" +
                "version1=" + version1 +
                ", version2=" + version2 +
                '}';
    }

    public Version getVersion1() {
        return version1;
    }
@XmlElement
    public void setVersion1(Version version1) {
        this.version1 = version1;
    }

    public Version getVersion2() {
        return version2;
    }
@XmlElement
    public void setVersion2(Version version2) {
        this.version2 = version2;
    }

    public Versions(Version version1, Version version2) {
        this.version1 = version1;
        this.version2 = version2;
    }
}
