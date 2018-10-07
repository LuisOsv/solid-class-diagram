package com.solid.msc.menuOptions;

import com.solid.msc.TransferableEntity;
import com.solid.msc.UmlBoard;
import com.solid.msc.UmlEntities.UmlComponent;
import com.solid.msc.UmlEntities.UmlComponentFactory;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;

public class EntityMenuItem extends JPanel implements DragGestureListener {
    private DragSource dragSource;
    private UmlBoard umlBoard;
    private Class<?> drawableComponentType;

    public EntityMenuItem(String menuName, Color borderColor, UmlBoard umlBoard, Class<?> drawableComponentType) {
        this.add(new JLabel(menuName));
        dragSource = new DragSource();
        dragSource.createDefaultDragGestureRecognizer(this, DnDConstants.ACTION_COPY_OR_MOVE, this);
        Border border = BorderFactory.createLineBorder(borderColor, 3);
        this.setBorder(border);
        this.setMaximumSize(new Dimension(100, 50));
        this.umlBoard = umlBoard;
        this.drawableComponentType = drawableComponentType;
    }

    @Override
    public void dragGestureRecognized(DragGestureEvent dragGestureEvent) {
        UmlComponent umlComponent = UmlComponentFactory.getDrawableComponent(drawableComponentType);
        Transferable transferable = new TransferableEntity(umlComponent);
        dragSource.startDrag(dragGestureEvent, DragSource.DefaultCopyDrop, transferable, null);
    }
}