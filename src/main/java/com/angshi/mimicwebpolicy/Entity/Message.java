package com.angshi.mimicwebpolicy.Entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@XmlRootElement(name = "Message")
public class Message  {
    @XmlElement(name = "Result")
    private List<SoftUpdateResult> result;
}
