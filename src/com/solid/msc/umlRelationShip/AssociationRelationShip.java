package com.solid.msc.umlRelationShip;

import java.awt.*;
import java.awt.geom.Point2D;

public class AssociationRelationShip implements UmlRelationshipDrawer {
    private Graphics2D graphics2D;
    private Point2D originPoint;
    private Point2D targetPoint;
    private final static Stroke LINE_STROKE = new BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1.0f,
            null, 0.0f);

    public AssociationRelationShip(Graphics2D graphics2D, Point2D originPoint, Point2D targetPoint) {
        this.graphics2D = graphics2D;
        this.originPoint = originPoint;
        this.targetPoint = targetPoint;
    }

    @Override
    public void drawLineWithConnectorBetweenTwoObject() {
        drawLine();
        ConnectorDrawer connectorDrawer = new ConnectorDrawer();
        connectorDrawer.drawConnector(graphics2D, originPoint, targetPoint);
    }

    @Override
    public void drawLine() {
        graphics2D.setColor(Color.BLACK);
        graphics2D.setStroke(LINE_STROKE);
        graphics2D.drawLine((int) originPoint.getX(), (int) originPoint.getY(), (int) (targetPoint.getX()),
                (int) (targetPoint.getY()));
    }
}
