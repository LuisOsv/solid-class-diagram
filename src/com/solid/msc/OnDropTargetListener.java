package com.solid.msc;

import com.solid.msc.UmlEntities.UmlClass;

import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;

public class OnDropTargetListener implements DropTargetListener {

    private UmlObjectRelationship umlObjectRelationship;

    public OnDropTargetListener(UmlObjectRelationship umlObjectRelationship) {
        this.umlObjectRelationship = umlObjectRelationship;
    }

    @Override
    public void dragEnter(DropTargetDragEvent dropTargetDragEvent) {

    }

    @Override
    public void dragOver(DropTargetDragEvent dropTargetDragEvent) {

    }

    @Override
    public void dropActionChanged(DropTargetDragEvent dropTargetDragEvent) {

    }

    @Override
    public void dragExit(DropTargetEvent dropTargetEvent) {

    }

    @Override
    public void drop(DropTargetDropEvent dropTargetDropEvent) {
        UmlObject object = new UmlClass((int) dropTargetDropEvent.getLocation().getX(), (int) dropTargetDropEvent.getLocation().getY());
        this.umlObjectRelationship.addUmlObject(object);
        object.setVisible(false);
        object.setVisible(true);
        this.umlObjectRelationship.repaint();
    }
}
