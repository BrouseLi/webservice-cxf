package com.angshi.mimicwebpolicy.Entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Modules")
public class Modules {
    private Module module;

    public Modules(Module module) {
        this.module = module;
    }

    public Module getModule() {
        return module;
    }
@XmlElement
    public void setModule(Module module) {
        this.module = module;
    }

    @Override
    public String toString() {
        return "Modules{" +
                "module=" + module +
                '}';
    }
}
