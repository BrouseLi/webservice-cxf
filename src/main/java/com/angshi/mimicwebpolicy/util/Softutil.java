package com.angshi.mimicwebpolicy.util;

import com.angshi.mimicwebpolicy.Entity.Soft;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.*;

import java.util.Arrays;
import java.util.List;
@Slf4j
public class Softutil {
    public static Soft parseXmlToObj(String policyXml){
        Soft soft=new Soft();
        try {
            Document doc = DocumentHelper.parseText(policyXml);
            Element root = doc.getRootElement();
            List<Element> list=root.elements();
            for(Element e:list){
                List<Attribute>attributeList=e.attributes();
                String key = e.getName();
                String value = e.getText();
                if ("id".equals(key)){
                    soft.setId(value);
                }
                if ("version".equals(key)){
                    soft.setVersion(value);
                }
                if ("code".equals(key)){
                    if(value.contains(",")){
                        List<String>ipList = Arrays.asList(value.split(","));
                        soft.setCode(ipList);
                    }else{
                        soft.setCode(Arrays.asList(value));
                    }

                }
            }
        }catch(DocumentException e){
            log.warn(e.getLocalizedMessage());
        }
        return soft;
    }
}
