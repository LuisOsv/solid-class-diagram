package com.solid.msc;

import com.solid.msc.UmlEntities.UmlClass;

import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;

public class DragListener implements DragSourceListener {

    private UmlBoard umlBoard;
    private EntityType entityType;

    public DragListener(UmlBoard umlBoard, EntityType entityType) {
        this.umlBoard = umlBoard;
        this.entityType = entityType;
    }

    @Override
    public void dragEnter(DragSourceDragEvent dragSourceDragEvent) {

    }

    @Override
    public void dragOver(DragSourceDragEvent dragSourceDragEvent) {

    }

    @Override
    public void dropActionChanged(DragSourceDragEvent dragSourceDragEvent) {

    }

    @Override
    public void dragExit(DragSourceEvent dragSourceEvent) {

    }

    @Override
    public void dragDropEnd(DragSourceDropEvent dragSourceDropEvent) {
        DrawableObject object = new UmlClass((int) dragSourceDropEvent.getLocation().getX(), (int) dragSourceDropEvent.getLocation().getY());
        this.umlBoard.addUmlObject(object);
        object.getFigure().setVisible(false);
        object.getFigure().setVisible(true);
        this.umlBoard.repaint();

    }
}
