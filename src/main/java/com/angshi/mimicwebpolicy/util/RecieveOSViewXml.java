package com.angshi.mimicwebpolicy.util;

import com.angshi.mimicwebpolicy.Entity.Hardware;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.StringWriter;
import static com.angshi.mimicwebpolicy.feign.GetOsView.addBoard;


public class RecieveOSViewXml {
    @Test
    public static void main(String argv[]) throws Exception{
        String strXML = osViewMessage();
        System.out.println(strXML);
    }
    public static String osViewMessage() throws Exception
    {
        Document document = DocumentHelper.createDocument();
        //创建根节点
        Element root = document.addElement("ViewPack");
        Element view=root.addElement("View");
        view.addAttribute("code","SystemStatus_View");
        view.addAttribute("version","1.00");
        view.addAttribute("description","系统状态视图");
        //获取到本机视图
        addBoard(view);
        //获取远程机器视图
        /**
         * 在此处编写远程获取执行体系统状态视图
         */
       return prettysString(document);
    }

    /**
     *
     * @param document
     * @return 格式化xml结果
     * @throws IOException
     */
    public static String prettysString(Document document) throws IOException {
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setNewLineAfterDeclaration(false);
        format.setEncoding(document.getXMLEncoding());
        StringWriter stringWriter = new StringWriter();
        XMLWriter writer = new XMLWriter(stringWriter, format);
        writer.write(document);
        writer.close();
        return stringWriter.toString();
    }

}
