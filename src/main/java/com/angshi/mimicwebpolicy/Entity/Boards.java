package com.angshi.mimicwebpolicy.Entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Boards {
    private List<Board> list;

    public List<Board> getList() {
        return list;
    }
@XmlElement(name = "Board")
    public void setList(List<Board> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Boards{" +
                "list=" + list +
                '}';
    }

    public Boards(List<Board> list) {
        this.list = list;
    }
}
