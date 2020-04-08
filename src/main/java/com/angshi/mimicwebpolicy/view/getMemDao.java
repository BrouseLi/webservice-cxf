package com.angshi.mimicwebpolicy.view;


import org.dom4j.Element;
import oshi.SystemInfo;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.PhysicalMemory;
import oshi.software.os.OperatingSystem;

public class getMemDao {

    public static void getMemIXml(Element xmlEle) throws Exception
    {
        SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer hal = si.getHardware();
        OperatingSystem os = si.getOperatingSystem();
        GlobalMemory gMem= hal.getMemory();

        PhysicalMemory[] memP= gMem.getPhysicalMemory();
        Element eleMem= xmlEle.addElement("MemUsage");
        eleMem.setText(String.valueOf(gMem.getTotal()-gMem.getAvailable())+"/"+String.valueOf(gMem.getTotal()));
    }
}
