package com.solid.msc.UmlEntities;

import com.solid.msc.UmlRelation;
import com.solid.msc.RelationHelper;
import com.solid.msc.RelationshipType;
import com.solid.msc.umlRelationShip.AssociationRelationShip;
import com.solid.msc.umlRelationShip.DependencyRelationShip;
import com.solid.msc.umlRelationShip.DrawLineWithConnectorBetweenTwoObject;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;


public abstract class UmlObject implements UmlComponent {
    private ArrayList<UmlRelation> umlRelationShips;
    private String name;
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
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
        this.figure.setName(name);
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
            Stroke defaultStroke;
            defaultStroke = graphics2D.getStroke();
            Stroke stroke2 = null;
            float[] dashingPattern2 = {10f, 4f};
            if (relationshipType == RelationshipType.DEPENDENCY) {
                stroke2 = new BasicStroke(4f, BasicStroke.CAP_BUTT,
                        BasicStroke.JOIN_MITER, 1.0f, null, 0.0f);
                DrawLineWithConnectorBetweenTwoObject relationship =
                        new DependencyRelationShip(graphics2D,originPoint,targetPoint,Color.BLACK,
                                Color.BLACK, Color.WHITE);

                relationship.drawLineWithConnectorBetweenTwoObject();
            } else {
                if (relationshipType == RelationshipType.ASSOCIATION) {
                    stroke2 = new BasicStroke(4f, BasicStroke.CAP_BUTT,
                            BasicStroke.JOIN_MITER, 1.0f, dashingPattern2, 0.0f);

                    DrawLineWithConnectorBetweenTwoObject relationship =
                            new AssociationRelationShip(graphics2D,originPoint,targetPoint,Color.BLACK,
                                    Color.BLACK, Color.WHITE);

                    relationship.drawLineWithConnectorBetweenTwoObject();
                }
            }
            if (stroke2 != null) {
                graphics2D.setStroke(stroke2);
            }
            graphics2D.draw(new Line2D.Double(originPoint, targetPoint));
            graphics2D.setStroke(defaultStroke);
        }
    }

    @Override
    public void drawNewRelation(Graphics2D graphics2D, RelationshipType relationshipType) {
        Point originPoint = RelationHelper.getInstance().getOriginUmlObject().getCenter();
        Point targetPoint = RelationHelper.getInstance().getTargetTemporaryPoint();
        drawRelation(graphics2D, originPoint, targetPoint, relationshipType);
    }

    @Override
    public Point getCenter() {
        Point point = new Point();
        point.x = (int) getFigure().getBounds().getCenterX();
        point.y = (int) getFigure().getBounds().getCenterY();
        return point;
    }
}
