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
    private DrawableComponent drawableComponent;

    public DragListener(UmlBoard umlBoard, DrawableComponent drawableComponent) {
        this.umlBoard = umlBoard;
        this.drawableComponent = drawableComponent;
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
        drawableComponent.setPosition((int) dragSourceDropEvent.getLocation().getX(), (int) dragSourceDropEvent.getLocation().getX());
        drawableComponent.drawFigureOnBoard(umlBoard);
    }
}
