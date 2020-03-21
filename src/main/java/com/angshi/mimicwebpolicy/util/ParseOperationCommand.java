package com.angshi.mimicwebpolicy.util;

import org.junit.jupiter.api.Test;

public class ParseOperationCommand {
    public static String parseOPerationCommand(String commandXml){

        return null;

    }

    @Test
    public void testParseOperation(){
        System.out.println(parseOPerationCommand("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<CommandPack>\n" +
                "\t<Command code=\"Operation_Command\" version=\"1.00\" mode=\"transient\" id=\"\" description=\"维护性操作命令\">\n" +
                "\t\t<Operation type=\"reboot\" delay=\"0\" reason=\"定期维护\"/>\n" +
                "\t</Command>\n" +
                "</CommandPack>"));
    }
}
