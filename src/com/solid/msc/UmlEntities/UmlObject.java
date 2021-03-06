package com.solid.msc.UmlEntities;

import com.solid.msc.RelationHelper;
import com.solid.msc.RelationshipType;
import com.solid.msc.umlRelationShip.UmlRelationShipFactory;
import com.solid.msc.umlRelationShip.UmlRelationshipDrawer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public abstract class UmlObject implements UmlComponent {
    private ArrayList<UmlRelation> umlRelationShips;
    private SquareFigure figure;

    public UmlObject() {
        figure = new SquareFigure(getName());
        figure.setBounds(new Rectangle(0, 0, 150, 40));
        umlRelationShips = new ArrayList<UmlRelation>();
    }

    @Override
    public void setPosition(int positionX, int positionY) {
        figure.setBounds(new Rectangle(positionX, positionY, 150, 40));
    }

    @Override
    public ArrayList<UmlRelation> getUmlRelationShips() {
        return umlRelationShips;
    }

    @Override
    public void addRelation(UmlComponent relatedDrawableObject, RelationshipType relationshipType) {
        UmlRelation umlRelation = new UmlRelation(relatedDrawableObject, relationshipType);
        umlRelationShips.add(umlRelation);
    }

    @Override
    public JPanel getFigure() {
        return this.figure;
    }

    public JTextField getTextField() {
        return figure.getTextField();
    }

    @Override
    public void drawRelation(Graphics2D graphics2D, Point originPoint, Point targetPoint, RelationshipType relationshipType) {
        if (originPoint != null && targetPoint != null) {
            UmlRelationshipDrawer relationship = UmlRelationShipFactory.getUmlRelationShip(relationshipType, graphics2D, originPoint, targetPoint);
            relationship.drawLineWithConnectorBetweenTwoObject();
        }
    }

    @Override
    public void drawNewRelation(Graphics2D graphics2D, RelationshipType relationshipType) {
        Point originPoint = RelationHelper.getInstance().getOriginUmlObject().getConnectionPoint();
        Point targetPoint = RelationHelper.getInstance().getTargetTemporaryPoint();
        drawRelation(graphics2D, originPoint, targetPoint, relationshipType);
    }

    @Override
    public Point getConnectionPoint() {
        Point point = new Point();
        point.x = (int) getFigure().getBounds().getCenterX();
        point.y = (int) getFigure().getBounds().getY();
        return point;
    }
}
