package com.angshi.mimicwebpolicy.feign;

import org.dom4j.*;
import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.NetworkIF;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Arrays;

public class getNetworkDao {
    public  static  void  getNetIFXml(Element netElement) throws SocketException {
        SystemInfo si=new SystemInfo();
        HardwareAbstractionLayer hal=si.getHardware();
        NetworkIF[] networkIFs=hal.getNetworkIFs();
        for (NetworkIF net : networkIFs) {
            Element xmlElement= netElement.addElement("Interface");
            NetworkInterface inetF= net.queryNetworkInterface();

            xmlElement.addAttribute("name",net.getName()+net.getDisplayName());
            if(inetF.isUp())
            {
                xmlElement.addAttribute("status","connected");
            }
            else{
                xmlElement.addAttribute("status","disconnected");
            }
            xmlElement.addAttribute("ipv4",Arrays.toString(net.getIPv4addr()));
            xmlElement.addAttribute("mask",Arrays.toString(net.getSubnetMasks()));
            xmlElement.addAttribute("gateway","192.168.1.1");
            xmlElement.addAttribute("mac",net.getMacaddr());
            xmlElement.addAttribute("speed",String.valueOf(net.getSpeed()));

            try {
                long inP1 = net.getBytesRecv();
                long outP1 = net.getBytesSent();
                Thread.sleep(1000);
                net.updateAttributes();
                long inP2 = net.getBytesRecv();
                long outP2 = net.getBytesSent();

                long inPage=inP2-inP1;
                long outPage=outP2-outP1;
                double tuntu=(inPage+outPage)*8/1000000;
                xmlElement.addAttribute("bandwidth",Double.toString(tuntu)+"Mbps");
                if(Arrays.toString(net.getIPv4addr()).contains("192.168"))
                {
                    xmlElement.addAttribute("admin","no");
                }
                else if(Arrays.toString(net.getIPv4addr()).contains("192.168.100"))
                {
                    xmlElement.addAttribute("admin","yes");
                }
                else
                {
                    xmlElement.addAttribute("admin","no");
                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }

        }

    }
}
