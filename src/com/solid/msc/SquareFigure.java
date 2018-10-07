package com.solid.msc;

import javax.swing.*;

public class SquareFigure extends JPanel {

    private JTextField name;

    public SquareFigure(String name) {
        this.setBorder(BorderFactory.createEtchedBorder());
        this.name = new JTextField(name);
        this.add(this.name);
    }

    public void setEntityName(String name) {
        this.name.setText(name);
    }

    public JTextField getTextField() {
        return name;
    }
}
