package com.angshi.mimicwebpolicy.util;

import com.angshi.mimicwebpolicy.Entity.Policy;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class Policyutil {
    public static  Policy parseXmlToObj(String policyXml){
        Policy policy=new Policy();
        try {
            Document doc = DocumentHelper.parseText(policyXml);
            Element root = doc.getRootElement();
            List<Element> list=root.elements();
            for(Element e:list){
                List<Attribute>attributeList=e.attributes();
                String key = attributeList.get(0).getValue();
                String value = attributeList.get(1).getValue();
                if ("Policy.name".equals(key)){
                    policy.setName(attributeList.get(1).getValue());
                }
                if ("ip".equals(key)){
                    if(value.contains(",")){
                        List<String>ipList = Arrays.asList(value.split(","));
                        policy.setIp(ipList);
                    }else{
                     policy.setIp(Arrays.asList(value));
                    }

                }
            }
        }catch(DocumentException e){
            log.warn(e.getLocalizedMessage());
        }
        return policy;
    }
    @Test
    public void testParsePolicy(){
        System.out.println( parseXmlToObj("<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<Policy>" +
                "   <Item key=\"Policy.name\" value=\"majorityVoting|consensusVoting\"/>" +
                "   <Item key=\"ip\" value=\"192.168.1.0,192.168.11.0\"/>" +
                "</Policy>"));
    }

}
