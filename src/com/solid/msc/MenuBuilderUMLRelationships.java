package com.solid.msc;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;

public class MenuBuilderUMLRelationships extends JToggleButton {

    public MenuBuilderUMLRelationships(RelationshipType relationshipType) {
        super(relationshipType.toString());
        this.setMaximumSize(new Dimension(100, 50));
        this.setAlignmentX(Component.LEFT_ALIGNMENT);
        RelationshipTypesEventListener relationshipTypesEventListener = new RelationshipTypesEventListener(relationshipType);
        this.addMouseListener(relationshipTypesEventListener);
    }
}
