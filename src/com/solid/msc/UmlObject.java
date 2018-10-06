package com.solid.msc;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;


public abstract class UmlObject implements DrawableObject {
    private ArrayList<DrawableObject> relationShips;
    private String name;
    private SquareFigure figure;

    public UmlObject(int positionX, int positionY) {
        figure = new SquareFigure(getName());
        figure.setBounds(new Rectangle(positionX, positionY, 125, 40));
        relationShips = new ArrayList<DrawableObject>();
    }

    @Override
    public ArrayList<DrawableObject> getRelationShips() {
        return relationShips;
    }

    @Override
    public void addRelation(DrawableObject childUmlObject) {
        relationShips.add(childUmlObject);
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

    @Override
    public void drawRelation(Graphics2D graphics2D, Point point1, Point point2) {
        graphics2D.draw(new Line2D.Double(point1, point2));
    }

    @Override
    public void drawNewRelation(Graphics2D graphics2D) {
        Point originPoint = RelationHelper.getInstance().getOriginUmlObject().getCenter();
        Point targetPoint = RelationHelper.getInstance().getTargetTemporaryPoint();
        drawRelation(graphics2D, originPoint, targetPoint);
    }

    @Override
    public Point getCenter() {
        Point point = new Point();
        point.x = (int) getFigure().getBounds().getCenterX();
        point.y = (int) getFigure().getBounds().getCenterY();
        return point;
    }
}
