package com.solid.msc;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public interface DrawableObject {

    void drawRelation(Graphics2D graphics2D, Point point1, Point point2);

    void addRelation(DrawableObject relatedUmlObject);

    String getName();

    void setName(String name);

    JPanel getFigure();

    ArrayList<DrawableObject> getRelationShips();

    void drawNewRelation(Graphics2D graphics2D);

    Point getCenter();


}
