package com.solid.msc;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public interface DrawableComponent {

    void drawRelation(Graphics2D graphics2D, Point originPoint, Point targetPoint, RelationshipType relationshipType);

    void addRelation(DrawableComponent relatedDrawableObject, RelationshipType relationshipType);

    ArrayList<Relation> getRelationShips();

    String getName();

    void setName(String name);

    JPanel getFigure();

    JTextField getTextField();


    void drawNewRelation(Graphics2D graphics2D, RelationshipType relationshipType);

    Point getCenter();

    void drawFigureOnBoard(UmlBoard umlBoard);

    void setPosition(int positionX, int positionY);
}
