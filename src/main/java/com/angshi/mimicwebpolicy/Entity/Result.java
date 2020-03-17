package com.angshi.mimicwebpolicy.Entity;

import lombok.*;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@XmlRootElement
public class Result {
    @XmlElement
    private String code;
    @XmlElement
    private String msg;
    @XmlElement
    private String desc;
}
