package com.solid.msc;

import com.solid.msc.UmlEntities.UmlClass;
import com.solid.msc.UmlEntities.UmlInterface;

import javax.swing.*;
import java.awt.*;
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
        if(entityType.equals(EntityType.CLASS)){
            DrawableComponent umlComponent = new UmlClass((int) dragSourceDropEvent.getLocation().getX(), (int) dragSourceDropEvent.getLocation().getY());
            this.umlBoard.addUmlObject(umlComponent);
            umlComponent.getFigure().setVisible(false);
            umlComponent.getFigure().setVisible(true);
            this.umlBoard.repaint();

        }else {
            DrawableComponent umlComponent = new UmlInterface((int) dragSourceDropEvent.getLocation().getX(), (int) dragSourceDropEvent.getLocation().getY());
            this.umlBoard.addUmlObject(umlComponent);
            umlComponent.getFigure().setVisible(false);
            umlComponent.getFigure().setVisible(true);

            JLabel interfaceLeftSymbol = new JLabel("<<");
            JLabel interfaceRightSymbol = new JLabel(">>");

            umlComponent.getFigure().add(interfaceLeftSymbol, BorderLayout.WEST);
            umlComponent.getFigure().add(umlComponent.getTextField(),BorderLayout.CENTER);
            umlComponent.getFigure().add(interfaceRightSymbol,BorderLayout.EAST);

            this.umlBoard.repaint();
        }

    }
}
