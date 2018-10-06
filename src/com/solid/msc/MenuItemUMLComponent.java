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

public class MenuItemUMLComponent extends JPanel implements DragGestureListener {
    private DragSource dragSource;
    private UmlBoard umlBoard;
    private EntityType entityType;

    public MenuItemUMLComponent(String menuName, Color borderColor, UmlBoard umlBoard, EntityType entityType) {
        this.add(new JLabel(menuName));
        dragSource = new DragSource();
        dragSource.createDefaultDragGestureRecognizer(this, DnDConstants.ACTION_COPY_OR_MOVE, this);
        Border border = BorderFactory.createLineBorder(borderColor, 3);
        this.setBorder(border);
        this.setMaximumSize(new Dimension(100, 50));
        this.umlBoard = umlBoard;
        this.entityType = entityType;
    }

    @Override
    public void dragGestureRecognized(DragGestureEvent dragGestureEvent) {
        Transferable transferable = new StringSelection(null);
        dragSource.startDrag(dragGestureEvent, DragSource.DefaultCopyDrop, transferable, new DragListener(umlBoard, entityType));
    }
}
