package com.angshi.mimicwebpolicy.Entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@ToString
@XmlRootElement
public class SoftUpdateResult {
    @XmlElement
    private String ResultCode;
    @XmlElement
    private String ResultDescription;
    @XmlElement
    private String ResultMessageCode;
}
