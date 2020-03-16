package com.angshi.mimicwebpolicy.Entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Hardware {
    private Boards boards;

    public Hardware(Boards boards) {
        this.boards = boards;
    }

    public Boards getBoards() {
        return boards;
    }
@XmlElement
    public void setBoards(Boards boards) {
        this.boards = boards;
    }
}
