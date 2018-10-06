package com.solid.msc;

import javax.swing.*;
import java.awt.*;


public class BuilderUMLComponents extends JPanel {

    private UmlBoard umlBoard;

    public BuilderUMLComponents(UmlBoard umlBoard) {
        this.umlBoard = umlBoard;
        initializePanel();
        addEntities();
    }

    private void addEntities() {
        this.add(new MenuItemUMLComponent("Class", Color.DARK_GRAY, umlBoard, EntityType.CLASS));
        this.add(new MenuItemUMLComponent("<<Interface>>", Color.lightGray, umlBoard, EntityType.INTERFACE));
    }

    private void initializePanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createTitledBorder("Entities"));
    }
}
