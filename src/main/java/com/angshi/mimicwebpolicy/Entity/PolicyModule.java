package com.angshi.mimicwebpolicy.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
@Setter
@XmlRootElement(name = "Policy")
public class PolicyModule {
    @XmlElement(name="Item")
    private List<Item> list;

}
