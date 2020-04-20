package com.angshi.mimicwebpolicy.util;

import com.angshi.mimicwebpolicy.Entity.Message;
import com.angshi.mimicwebpolicy.Entity.ObjToXml;
import com.angshi.mimicwebpolicy.Entity.SoftUpdateResult;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

public class XMLUtil {
    public static String GenerrateSoftUpdateReslutXml(String resultCode , List<String> list ){
        List<SoftUpdateResult> list1=new ArrayList<SoftUpdateResult>();
        List<String> code= Arrays.asList(resultCode.split(","));
            if("200".equals(code.get(0))){
                SoftUpdateResult softUpdateResult =new SoftUpdateResult(resultCode,"success",list.get(0));
                list1.add(softUpdateResult);
            }else{
                SoftUpdateResult softUpdateResult =new SoftUpdateResult(resultCode,"error",list.get(0));
                list1.add(softUpdateResult);
            }
            if("200".equals(code.get(1))){
                SoftUpdateResult softUpdateResult =new SoftUpdateResult(resultCode,"success",list.get(1));
                list1.add(softUpdateResult);
            }else{
                SoftUpdateResult softUpdateResult =new SoftUpdateResult(resultCode,"error",list.get(1));
                list1.add(softUpdateResult);
            }
        return ObjToXml.convertToXml(new Message(list1));
    }
    public static String formatXml(String xml) throws DocumentException, IOException {
        Document document= DocumentHelper.parseText(xml);
        return RecieveOSViewXml.prettysString(document);
    }
}
