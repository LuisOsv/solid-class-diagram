package com.solid.msc;

import javax.swing.*;
import java.awt.*;


public class DraggableUMLComponents extends JPanel {

    public DraggableUMLComponents() {
        initializePanel();
        addEntities();
    }

    private void addEntities() {
        this.add(new MenuBuilderUMLComponents("Class", Color.DARK_GRAY));
        this.add(new MenuBuilderUMLComponents("<<Interface>>", Color.lightGray));
    }

    private void initializePanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createTitledBorder("Entities"));
    }
}
