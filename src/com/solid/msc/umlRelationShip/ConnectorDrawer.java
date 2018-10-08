package com.solid.msc.umlRelationShip;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;

public class ConnectorDrawer {

    private final static float ARROW_SIZE = 20;
    private final static double ARROW_ANGLE = 75;
    final static Stroke ARROW_STROKE = new BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1.0f,
            null, 0.0f);


    public double calculateLineAngle(Point2D startPoint, Point2D endPoint) {
        double deltaX = (startPoint.getX() - endPoint.getX());
        if (deltaX == 0.0d) {
            return Math.PI / 2;
        } else {
            return Math.atan((startPoint.getY() - endPoint.getY()) / deltaX) + (startPoint.getX() < endPoint.getX() ? Math.PI : 0);
        }
    }

    public void drawConnector(Graphics2D graphics2D, Point2D startPoint, Point2D endPoint) {
        double lineAngle = calculateLineAngle(startPoint, endPoint);
        double lineDirectionStartX = ARROW_SIZE * Math.cos(lineAngle - ARROW_ANGLE);
        double lineDirectionStartY = ARROW_SIZE * Math.sin(lineAngle - ARROW_ANGLE);
        double lineDirectionEndX = ARROW_SIZE * Math.cos(lineAngle + ARROW_ANGLE);
        double lineDirectionEndY = ARROW_SIZE * Math.sin(lineAngle + ARROW_ANGLE);

        GeneralPath polygon = new GeneralPath();


        polygon.moveTo(endPoint.getX(), endPoint.getY());
        polygon.lineTo(endPoint.getX() + lineDirectionStartX, endPoint.getY() + lineDirectionStartY);
        polygon.lineTo(endPoint.getX() + lineDirectionEndX, endPoint.getY() + lineDirectionEndY);
        polygon.lineTo(endPoint.getX(), endPoint.getY());

        graphics2D.setStroke(ARROW_STROKE);

        graphics2D.setColor(Color.BLACK);
        graphics2D.draw(polygon);
        graphics2D.setColor(Color.WHITE);
        graphics2D.setStroke(new BasicStroke());
        graphics2D.fill(polygon);
        polygon.closePath();
    }
}
