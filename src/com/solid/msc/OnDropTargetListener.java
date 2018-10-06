package com.solid.msc;

import com.solid.msc.UmlEntities.UmlClass;

import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;

public class OnDropTargetListener implements DropTargetListener {

    private UmlBoard umlBoard;

    public OnDropTargetListener(UmlBoard umlBoard) {
        this.umlBoard = umlBoard;
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
        //moved from here
    }
}
