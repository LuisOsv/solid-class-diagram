package com.solid.msc;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public interface DrawableObject {

    void drawRelation(Graphics2D graphics2D, Point point1, Point point2, RelationshipType relationshipType);

    void addRelation(DrawableObject relatedDrawableObject, RelationshipType relationshipType);

    ArrayList<Relation> getRelationShips();

    String getName();

    void setName(String name);

    JPanel getFigure();


    void drawNewRelation(Graphics2D graphics2D, RelationshipType relationshipType);

    Point getCenter();


}
