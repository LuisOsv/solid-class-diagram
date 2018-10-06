package com.solid.msc;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseEvent;


public class MouseEventsListener extends MouseInputAdapter {
    private UmlBoard panel;
    private Point offset = new Point();
    private int selectedIndex;
    private boolean dragging = false;

    public MouseEventsListener(UmlBoard umlRelationship) {
        this.panel = umlRelationship;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        super.mouseClicked(mouseEvent);

        DrawableObject umlObject = getEntityByPoint(mouseEvent.getPoint());
        if (umlObject != null) {
            handleEntityClickedEvent(umlObject);
        }
    }

    private void handleEntityClickedEvent(DrawableObject umlObject) {
        if (RelationHelper.getInstance().isAddingRelation()) {
            RelationHelper.getInstance().completeRelation(umlObject);
        } else {
            RelationHelper.getInstance().setOriginUmlObject(umlObject);
        }
        this.panel.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        if (RelationHelper.getInstance().isAddingRelation()) {
            RelationHelper.getInstance().setTargetTemporaryPoint(mouseEvent.getPoint());
            panel.repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        Point point = mouseEvent.getPoint();
        // This way of identifying the target JPanel should work as
        // long as the target is not focusable and does not contain
        // any components that consume MouseEvents, eg, JTextField.
        DrawableObject component = getEntityByPoint(point);
        if (component != null) {
            offset.x = point.x - component.getFigure().getBounds().x;
            offset.y = point.y - component.getFigure().getBounds().y;
            dragging = true;
        }
    }

    private DrawableObject getEntityByPoint(Point point) {
        DrawableObject component = null;
        for (int j = 0; j < panel.getDrawableObjects().size(); j++) {
            Rectangle rectangle = panel.getDrawableObjects().get(j).getFigure().getBounds();
            if (rectangle.contains(point)) {
                component = panel.getDrawableObjects().get(j);
            }
        }
        return component;
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        dragging = false;
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        if (dragging) {
            int x = mouseEvent.getX() - offset.x;
            int y = mouseEvent.getY() - offset.y;
            DrawableObject drawableObject = getEntityByPoint(mouseEvent.getPoint());
            if (drawableObject != null) {
                drawableObject.getFigure().setLocation(x, y);
                panel.repaint();
            }
        }
    }
}
