package com.angshi.mimicwebpolicy.service;

import com.angshi.mimicwebpolicy.client.CxfClient;
import com.angshi.mimicwebpolicy.util.FileUtil;
import com.angshi.mimicwebpolicy.util.XMLUtil;
import org.dom4j.DocumentException;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
public class TestWarnImpl implements TestWarn {
    @Override
    public void testReportLog() throws IOException, DocumentException {
        String warn=XMLUtil.formatXml(FileUtil.getFileContent("/home/warn.xml"));
        CxfClient cxfClient =new CxfClient();
        cxfClient.createClient("http://15.1.5.244:8084/zzjg/app/services/WSSmCommUpper?wsdl");
        cxfClient.reportWarnLog(cxfClient.getClient(),warn);
    }
}
