package com.solid.msc;

import javax.swing.*;
import java.awt.*;
import java.awt.dnd.DropTarget;
import java.util.ArrayList;

public class UmlBoard extends JPanel {
    private ArrayList<DrawableComponent> drawableObjects;

    public UmlBoard() {
        this.setLayout(null);
        drawableObjects = new ArrayList<DrawableComponent>();
        MouseEventsListener panelMover = new MouseEventsListener(this);
        this.addMouseListener(panelMover);
        this.addMouseMotionListener(panelMover);
        new DropTarget(this, new OnDropTargetListener(this));
    }

    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for (DrawableComponent drawableObject : drawableObjects) {
            drawRelations(graphics2D, drawableObject);
        }

        drawNewRelation(graphics2D);
    }

    public ArrayList<DrawableComponent> getDrawableObjects() {
        return drawableObjects;
    }

    private void drawNewRelation(Graphics2D graphics2D) {
        if (RelationHelper.getInstance().isAddingRelation()) {
            RelationHelper.getInstance().getOriginUmlObject().drawNewRelation(graphics2D, RelationHelper.getInstance().getRelationshipType());
        }
    }

    public void addUmlObject(DrawableComponent drawableObject) {
        this.drawableObjects.add(drawableObject);
        this.add(drawableObject.getFigure());
    }

    public void drawRelations(Graphics2D graphics2D, DrawableComponent umlObject) {
        if (umlObject.getRelationShips().size() > 0) {
            Point point1 = umlObject.getCenter();
            for (int j = 0; j < umlObject.getRelationShips().size(); j++) {
                UmlObject childUmlObject = (UmlObject) umlObject.getRelationShips().get(j).getTargetDrawableObject();
                Point point2 = childUmlObject.getCenter();
                umlObject.drawRelation(graphics2D, point1, point2, umlObject.getRelationShips().get(j).getRelationshipType());
            }
        }
    }
}
