package com.solid.msc;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

// Make a Label draggable; You can use the example to make any component draggable
public class OptionMenuDraggable extends JPanel implements DragGestureListener, DragSourceListener {
	DragSource dragSource;

	public OptionMenuDraggable(String text) {
		this.add(new JLabel(text));

		dragSource = new DragSource();

		dragSource.createDefaultDragGestureRecognizer(this, DnDConstants.ACTION_COPY_OR_MOVE, this);

		Border border = BorderFactory.createLineBorder(Color.BLUE, 5);
		this.setBorder(border);
		this.setMaximumSize(new Dimension(100, 100));


	}

	@Override
	public void dragDropEnd(DragSourceDropEvent dsde) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dragEnter(DragSourceDragEvent dsde) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dragExit(DragSourceEvent dse) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dragOver(DragSourceDragEvent dsde) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dropActionChanged(DragSourceDragEvent dsde) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dragGestureRecognized(DragGestureEvent dge) {
		Transferable transferable = new StringSelection(null);

		dragSource.startDrag(dge, DragSource.DefaultCopyDrop, transferable, this);
		
	}



}
