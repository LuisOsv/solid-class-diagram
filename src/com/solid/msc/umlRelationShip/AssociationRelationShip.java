package com.solid.msc.umlRelationShip;

import java.awt.*;
import java.awt.geom.*;

public class AssociationRelationShip implements UmlRelationshipDrawer {
    private Graphics2D graphics2D;
    private Point2D startPoint;
    private Point2D endPoint;
    private final static float ARROW_SIZE = 20;
    private Color lineColor;
    private Color arrowColor;
    private Color backgroundArrowColor;
    private final static double ARROW_ANGLE = 75;
    private final static Stroke LINE_STROKE = new BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1.0f,
            null, 0.0f);

    private final static Stroke ARROW_STROKE = new BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1.0f,
            null, 0.0f);

    public AssociationRelationShip(Graphics2D graphics2D, Point2D originPoint, Point2D targetPoint, Color lineColor,
                                   Color arrowColor, Color backgroundArrowColor) {
        this.graphics2D = graphics2D;
        this.startPoint = originPoint;
        this.endPoint = targetPoint;
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

        graphics2D.setColor(arrowColor);
        graphics2D.draw(polygon);
        graphics2D.setColor(backgroundArrowColor);
        graphics2D.setStroke(new BasicStroke());
        graphics2D.fill(polygon);
        polygon.closePath();

    }

}
