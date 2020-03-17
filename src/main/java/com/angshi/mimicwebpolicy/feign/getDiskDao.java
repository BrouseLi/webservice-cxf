package com.angshi.mimicwebpolicy.feign;


import org.dom4j.Element;
import oshi.SystemInfo;
import oshi.hardware.HWDiskStore;
import oshi.hardware.HWPartition;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.FileSystem;
import oshi.software.os.OSFileStore;
import oshi.software.os.OperatingSystem;
import oshi.util.FormatUtil;

public class getDiskDao {


    public static void getFsXml(Element diskEle) {
        SystemInfo si=new SystemInfo();
        HardwareAbstractionLayer hal=si.getHardware();
        OperatingSystem os= si.getOperatingSystem();
        FileSystem fileSystem = os.getFileSystem();
        long sumUseable=0;
        long sumTotalSpace=0;
        OSFileStore[] fsArray = fileSystem.getFileStores();
        for (OSFileStore fs : fsArray) {
            long usable = fs.getUsableSpace();
            long total = fs.getTotalSpace();
            sumUseable+=fs.getUsableSpace();
            sumTotalSpace+=fs.getTotalSpace();
        }
        diskEle.setText(String.valueOf(sumTotalSpace-sumUseable)+"/"+String.valueOf(sumTotalSpace));
    }
}
