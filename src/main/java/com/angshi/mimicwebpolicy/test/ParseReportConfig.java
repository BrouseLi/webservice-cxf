package com.angshi.mimicwebpolicy.test;

import com.angshi.mimicwebpolicy.util.FileUtil;
import com.angshi.mimicwebpolicy.util.XMLUtil;
import org.dom4j.DocumentException;
import org.junit.jupiter.api.Test;
import java.io.IOException;


public class ParseReportConfig {
    @Test
    public void parseReportConfig() throws DocumentException, IOException {
        String path="/Users/liang/Documents/config.xml";
        String content=FileUtil.getFileContent(path);
        String reportConfigContent=XMLUtil.formatXml(content);
        System.out.println(reportConfigContent);
    }
}
