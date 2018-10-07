package com.solid.msc;

import com.solid.msc.UmlEntities.UmlClass;
import com.solid.msc.UmlEntities.UmlInterface;

import javax.swing.*;
import java.awt.*;


public class MenuBuilderUMLComponents extends JPanel {

    private UmlBoard umlBoard;

    public MenuBuilderUMLComponents(UmlBoard umlBoard) {
        this.umlBoard = umlBoard;
        initializePanel();
        addEntities();
    }

    private void addEntities() {
        this.add(new MenuItemUMLComponent("Class", Color.DARK_GRAY, umlBoard, UmlClass.class));
        this.add(new MenuItemUMLComponent("<<Interface>>", Color.lightGray, umlBoard, UmlInterface.class));
    }

    private void initializePanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createTitledBorder("Entities"));
    }
}
