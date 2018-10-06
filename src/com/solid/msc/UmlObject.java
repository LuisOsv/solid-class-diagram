package com.solid.msc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.geom.Line2D;
import java.util.ArrayList;


public abstract class UmlObject extends JPanel {
    private ArrayList<Component> relationShips;
    private JTextField umlFieldNameComponent;

    public ArrayList<Component> getRelationShips() {
        return relationShips;
    }

    public UmlObject(int positionX, int positionY) {
        Rectangle rectangle = new Rectangle(positionX, positionY, 125, 40);
        initializePanel(rectangle);
    }

    public void relateUmlObject(UmlObject childUmlObject) {
        relationShips.add(childUmlObject);
    }

    private void initializePanel(Rectangle rectangle) {
        String placeholder = "Enter the name";
        relationShips = new ArrayList<Component>();
        umlFieldNameComponent = new JTextField(placeholder);
        this.setBounds(rectangle);
        this.setBorder(BorderFactory.createEtchedBorder());
        umlFieldNameComponent.setForeground(Color.GRAY);
        umlFieldNameComponent.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                if (umlFieldNameComponent.getText().equals(placeholder)) {
                    umlFieldNameComponent.setText("");
                    umlFieldNameComponent.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (umlFieldNameComponent.getText().isEmpty()) {
                    umlFieldNameComponent.setForeground(Color.GRAY);
                    umlFieldNameComponent.setText(placeholder);
                }
            }
        });
        this.add(umlFieldNameComponent);
    }

    protected void drawRelation(Graphics2D graphics2D, Point point1, Point point2) {
        if (point1 != null && point2 != null) {
            Stroke defaultStroke;
            defaultStroke = graphics2D.getStroke();

            float[] dashingPattern2 = {10f, 4f};
            Stroke stroke2 = new BasicStroke(4f, BasicStroke.CAP_BUTT,
                    BasicStroke.JOIN_MITER, 1.0f, dashingPattern2, 0.0f);

            graphics2D.setStroke(stroke2);
            graphics2D.draw(new Line2D.Double(point1, point2));
            graphics2D.setStroke(defaultStroke);
        }
    }

    protected void drawNewRelation(Graphics2D graphics2D) {
        Point originPoint = getCenter(RelationHelper.getInstance().getOriginUmlObject().getBounds());
        Point targetPoint = RelationHelper.getInstance().getTargetTemporaryPoint();
        drawRelation(graphics2D, originPoint, targetPoint);
    }

    public Point getCenter(Component component) {
        Rectangle rectangle = component.getBounds();
        return getCenter(rectangle);
    }

    private Point getCenter(Rectangle rectangle) {
        Point point = new Point();
        point.x = (int) rectangle.getCenterX();
        point.y = (int) rectangle.getCenterY();
        return point;
    }
}
