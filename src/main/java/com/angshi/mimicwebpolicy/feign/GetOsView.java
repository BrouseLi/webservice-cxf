package com.angshi.mimicwebpolicy.feign;

import org.dom4j.Element;

public class GetOsView {
    public static void addBoard(Element view) throws Exception {
        Element hdEle=view.addElement("Hardware");
        Element boards=hdEle.addElement("Boards");
        Element board=boards.addElement("Board");
        board.addAttribute("name","申威");
        board.addAttribute("status","");
        board.addAttribute("reason","");
        Element inetF=board.addElement("Interfaces");
        getNetworkDao.getNetIFXml(inetF);
        Element cpuEle=board.addElement("CpuUsage");
        getCpuBaseDao.getCpuBasexml(cpuEle);
        Element memEle=board.addElement("MemUsage");
        getMemDao.getMemIXml(memEle);
        Element diskEle=board.addElement("DiskUsage");
        getDiskDao.getFsXml(diskEle);
    }
}
