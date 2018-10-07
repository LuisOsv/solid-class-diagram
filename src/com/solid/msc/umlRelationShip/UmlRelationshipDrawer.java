package com.solid.msc.umlRelationShip;

import java.awt.geom.Point2D;

public interface UmlRelationshipDrawer {

    void drawLineWithConnectorBetweenTwoObject();

    default double calculateLineAngle(Point2D startPoint, Point2D endPoint) {
        double deltaX = (startPoint.getX() - endPoint.getX());
        if (deltaX == 0.0d) {
            return Math.PI / 2;
        } else {
            return Math.atan((startPoint.getY() - endPoint.getY()) / deltaX) + (startPoint.getX() < endPoint.getX() ? Math.PI : 0);
        }
    }

}