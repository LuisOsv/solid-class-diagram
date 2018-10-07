package com.solid.msc;

import com.solid.msc.UmlEntities.UmlComponent;
import com.solid.msc.UmlEntities.UmlObject;

import javax.swing.*;
import java.awt.*;
import java.awt.dnd.DropTarget;
import java.util.ArrayList;

public class UmlBoard extends JPanel {
    private ArrayList<UmlComponent> drawableObjects;

    public UmlBoard() {
        this.setLayout(null);
        drawableObjects = new ArrayList<UmlComponent>();
        MouseEventsListener panelMover = new MouseEventsListener(this);
        this.addMouseListener(panelMover);
        this.addMouseMotionListener(panelMover);
        new DropTarget(this, new OnDropTargetListener(this));
    }

    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for (UmlComponent drawableObject : drawableObjects) {
            drawRelations(graphics2D, drawableObject);
        }

        drawNewRelation(graphics2D);
    }

    public ArrayList<UmlComponent> getDrawableObjects() {
        return drawableObjects;
    }

    private void drawNewRelation(Graphics2D graphics2D) {
        if (RelationHelper.getInstance().isAddingRelation()) {
            RelationHelper.getInstance().getOriginUmlObject().drawNewRelation(graphics2D, RelationHelper.getInstance().getRelationshipType());
        }
    }

    public void addUmlObject(UmlComponent drawableObject) {
        this.drawableObjects.add(drawableObject);
        this.add(drawableObject.getFigure());
    }

    public void drawRelations(Graphics2D graphics2D, UmlComponent umlObject) {
        if (umlObject.getUmlRelationShips().size() > 0) {
            Point originPoint = umlObject.getCenter();
            for (int j = 0; j < umlObject.getUmlRelationShips().size(); j++) {
                UmlObject childUmlObject = (UmlObject) umlObject.getUmlRelationShips().get(j).getTargetDrawableObject();
                Point targetPoint = childUmlObject.getCenter();
                umlObject.drawRelation(graphics2D, originPoint, targetPoint, umlObject.getUmlRelationShips().get(j).getRelationshipType());
            }
        }
    }
}
