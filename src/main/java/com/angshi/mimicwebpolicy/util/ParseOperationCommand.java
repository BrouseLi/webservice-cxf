package com.angshi.mimicwebpolicy.util;

import com.angshi.mimicwebpolicy.Entity.Command;
import com.angshi.mimicwebpolicy.Entity.Operation;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.*;
import org.junit.jupiter.api.Test;
import java.util.List;
@Slf4j
public class ParseOperationCommand {
    public static Command parseOPerationCommand(String commandXml){
        Command command =new Command();
        Operation operation=new Operation();
        try {
            Document doc = DocumentHelper.parseText(commandXml);
            Element root = doc.getRootElement();
            List<Element> list=root.elements();
            for(Element e:list){
                if ("Command".equals(e.getName())){
                    List<Attribute>attributes=e.attributes();
                    String code =attributes.get(0).getValue();
                    String version =attributes.get(1).getValue();
                    String mode =attributes.get(2).getValue();
                    String id =attributes.get(3).getValue();
                    String description = attributes.get(4).getValue();
                    command.setCode(code);
                    command.setVersion(version);
                    command.setMode(mode);
                    command.setId(id);
                    command.setDescription(description);
                }
                List<Attribute>attributeList=e.elements().get(0).attributes();
                String type = attributeList.get(0).getValue();
                String delay = attributeList.get(1).getValue();
                String reason = attributeList.get(2).getValue();
                operation.setType(type);
                operation.setDelay(Integer.valueOf(delay));
                operation.setReason(reason);
                command.setOperation(operation);
            }
        }catch(DocumentException e){
            log.warn(e.getLocalizedMessage());
        }
        return command;

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
