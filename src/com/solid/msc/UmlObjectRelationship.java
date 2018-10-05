package com.solid.msc;

import javax.swing.*;
import java.awt.*;
import java.awt.dnd.DropTarget;

public class UmlObjectRelationship extends JPanel {
    DropTarget dt;

    public UmlObjectRelationship() {
        this.setLayout(null);
        MouseEventsListener panelMover = new MouseEventsListener(this);
        this.addMouseListener(panelMover);
        this.addMouseMotionListener(panelMover);
        new DropTarget(this, new OnDropTargetListener(this));
    }

    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Component[] components = getComponents();
        for (int i = 0; i < components.length; i++) {
            UmlObject umlObject = (UmlObject) components[i];
            drawRelations(graphics2D, umlObject);
        }

        drawNewRelation(graphics2D);
    }

    private void drawNewRelation(Graphics2D graphics2D) {
        if (RelationHelper.getInstance().isAddingRelation()) {
            RelationHelper.getInstance().getOriginUmlObject().drawNewRelation(graphics2D);
        }
    }

    public void addUmlObject(Component umlObject) {
        this.add(umlObject);
    }

    public void drawRelations(Graphics2D graphics2D, UmlObject umlObject) {
        if (umlObject.getRelationShips().size() > 0) {
            Point point1 = umlObject.getCenter(umlObject);
            for (int j = 0; j < umlObject.getRelationShips().size(); j++) {
                UmlObject childUmlObject = (UmlObject) umlObject.getRelationShips().get(j);
                Point point2 = umlObject.getCenter(childUmlObject);
                umlObject.drawRelation(graphics2D, point2, point1);
            }
        }
    }
}
