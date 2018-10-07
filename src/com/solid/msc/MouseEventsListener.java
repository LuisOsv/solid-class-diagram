package com.solid.msc;

import com.solid.msc.UmlEntities.UmlComponent;

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

        UmlComponent umlObject = getEntityByPoint(mouseEvent.getPoint());
        if (umlObject != null) {
            handleEntityClickedEvent(umlObject);
        }
    }

    private void handleEntityClickedEvent(UmlComponent umlObject) {
        if (RelationHelper.getInstance().isAddingRelation()) {
            RelationHelper.getInstance().completeRelation(umlObject, RelationHelper.getInstance().getRelationshipType());
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
        UmlComponent component = getEntityByPoint(point);
        if (component != null) {
            offset.x = point.x - component.getFigure().getBounds().x;
            offset.y = point.y - component.getFigure().getBounds().y;
            dragging = true;
        }
    }

    private UmlComponent getEntityByPoint(Point point) {
        UmlComponent component = null;
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
            UmlComponent drawableObject = getEntityByPoint(mouseEvent.getPoint());
            if (drawableObject != null) {
                drawableObject.getFigure().setLocation(x, y);
                panel.repaint();
            }
        }
    }
}
