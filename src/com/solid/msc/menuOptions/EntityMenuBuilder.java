package com.solid.msc.menuOptions;

import com.solid.msc.UmlBoard;
import com.solid.msc.UmlEntities.UmlClass;
import com.solid.msc.UmlEntities.UmlInterface;

import javax.swing.*;
import java.awt.*;


public class EntityMenuBuilder extends JPanel {

    private UmlBoard umlBoard;

    public EntityMenuBuilder(UmlBoard umlBoard) {
        this.umlBoard = umlBoard;
        initializePanel();
        addEntities();
    }

    private void addEntities() {
        this.add(new EntityMenuItem("Class", Color.DARK_GRAY, umlBoard, UmlClass.class));
        this.add(new EntityMenuItem("<<Interface>>", Color.lightGray, umlBoard, UmlInterface.class));
    }

    private void initializePanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createTitledBorder("Entities"));
    }
}
