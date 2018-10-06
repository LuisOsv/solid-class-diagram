package com.solid.msc;

import javax.swing.*;
import java.awt.*;


public class DraggableOptions extends JPanel {

    public DraggableOptions() {
        initializePanel();
        addEntities();
    }

    private void addEntities() {
        this.add(new OptionMenuDraggable("Class", Color.DARK_GRAY));
        this.add(new OptionMenuDraggable("<<Interface>>", Color.lightGray));
    }

    private void initializePanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createTitledBorder("Entities"));
    }
}
