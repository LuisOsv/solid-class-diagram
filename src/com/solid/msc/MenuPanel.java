package com.solid.msc;

import javax.swing.*;


public class MenuPanel extends JPanel {

    public MenuPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.add(new OptionMenuDraggable("Class"));
        this.add(new OptionMenuDraggable("Interface"));
    }
}
