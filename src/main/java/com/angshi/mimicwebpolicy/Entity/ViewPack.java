package com.angshi.mimicwebpolicy.Entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ViewPack {
    private View view;

    public ViewPack(View view) {
        this.view = view;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    @Override
    public String toString() {
        return "ViewPack{" +
                "view=" + view +
                '}';
    }
}
