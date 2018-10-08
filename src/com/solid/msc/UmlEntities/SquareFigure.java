package com.solid.msc.UmlEntities;

import javax.swing.*;

public class SquareFigure extends JPanel {

    private JTextField name;

    public SquareFigure(String name) {
        this.setBorder(BorderFactory.createEtchedBorder());
        this.name = new JTextField(name);
        this.add(this.name);
    }

    public JTextField getTextField() {
        return name;
    }
}
