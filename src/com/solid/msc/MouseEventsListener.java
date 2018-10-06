package com.solid.msc;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseEvent;


public class MouseEventsListener extends MouseInputAdapter {
    private JPanel panel;
    private Point offset = new Point();
    private int selectedIndex;
    private boolean dragging = false;

    public MouseEventsListener(JPanel umlRelationship) {
        this.panel = umlRelationship;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        super.mouseClicked(mouseEvent);

        UmlObject umlObject = (UmlObject) getEntityByPoint(mouseEvent.getPoint());
        if (umlObject != null) {
            handleEntityClickedEvent(umlObject);
        }
    }

    private void handleEntityClickedEvent(UmlObject umlObject) {
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
        Component component = getEntityByPoint(point);
        if (component != null) {
            offset.x = point.x - component.getBounds().x;
            offset.y = point.y - component.getBounds().y;
            dragging = true;
        }
    }

    private Component getEntityByPoint(Point point) {
        Component component = null;
        Component[] components = panel.getComponents();
        for (int j = 0; j < components.length; j++) {
            Rectangle rectangle = components[j].getBounds();
            if (rectangle.contains(point)) {
                component = components[j];
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
            Component component = getEntityByPoint(mouseEvent.getPoint());
            if (component != null) {
                component.setLocation(x, y);
                panel.repaint();
            }
        }
    }
}
