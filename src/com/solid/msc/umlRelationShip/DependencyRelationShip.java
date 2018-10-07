package com.solid.msc.umlRelationShip;

import java.awt.*;
import java.awt.geom.*;

public class DependencyRelationShip implements UmlRelationshipDrawer {
    Graphics2D graphics2D;
    Point2D startPoint;
    Point2D endPoint;
    final static float ARROW_SIZE = 20;
    Color lineColor;
    Color arrowColor;
    Color backgroundArrowColor;
    final static double ARROW_ANGLE = 75;
    final static float[] DASHING_PATTERN = {10f, 4f};
    final static Stroke LINE_STROKE = new BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1.0f,
            DASHING_PATTERN, 0.0f);

    final static Stroke ARROW_STROKE = new BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1.0f,
            null, 0.0f);

    public DependencyRelationShip(Graphics2D graphics2D, Point2D startPoint, Point2D endPoint, Color lineColor,
                                  Color arrowColor, Color backgroundArrowColor) {
        this.graphics2D = graphics2D;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.lineColor = lineColor;
        this.arrowColor = arrowColor;
        this.backgroundArrowColor = backgroundArrowColor;
    }

    @Override
    public void drawLineWithConnectorBetweenTwoObject() {
        drawLine();
        drawConnector();
    }


    protected void drawLine() {
        graphics2D.setColor(lineColor);
        graphics2D.setStroke(LINE_STROKE);
        graphics2D.drawLine((int) startPoint.getX(), (int) startPoint.getY(), (int) (endPoint.getX()),
                (int) (endPoint.getY()));
    }

    protected void drawConnector() {
        double lineAngle = calculateLineAngle(startPoint, endPoint);
        double lineDirectionStartX = ARROW_SIZE * Math.cos(ARROW_ANGLE - lineAngle);
        double lineDirectionStartY = ARROW_SIZE * Math.sin(ARROW_ANGLE - lineAngle);
        double lineDirectionEndX = ARROW_SIZE * Math.cos(ARROW_ANGLE + lineAngle);
        double lineDirectionEndY = ARROW_SIZE * Math.sin(ARROW_ANGLE + lineAngle);

        GeneralPath polygon = new GeneralPath();


        polygon.moveTo(endPoint.getX(), endPoint.getY());
        polygon.lineTo(endPoint.getX() + lineDirectionStartX, endPoint.getY() + lineDirectionStartY);
        polygon.lineTo(endPoint.getX() + lineDirectionEndX, endPoint.getY() + lineDirectionEndY);
        polygon.lineTo(endPoint.getX(), endPoint.getY());

        graphics2D.setStroke(ARROW_STROKE);

        graphics2D.setColor(arrowColor);
        graphics2D.draw(polygon);
        graphics2D.setColor(backgroundArrowColor);
        graphics2D.setStroke(new BasicStroke());
        graphics2D.fill(polygon);
        polygon.closePath();
    }

}
