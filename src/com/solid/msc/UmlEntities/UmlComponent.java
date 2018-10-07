package com.solid.msc.UmlEntities;

import com.solid.msc.UmlRelation;
import com.solid.msc.RelationshipType;
import com.solid.msc.UmlBoard;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public interface UmlComponent {

    void drawRelation(Graphics2D graphics2D, Point originPoint, Point targetPoint, RelationshipType relationshipType);

    void addRelation(UmlComponent relatedDrawableObject, RelationshipType relationshipType);

    ArrayList<UmlRelation> getUmlRelationShips();

    String getName();

    void setName(String name);

    JPanel getFigure();

    JTextField getTextField();


    void drawNewRelation(Graphics2D graphics2D, RelationshipType relationshipType);

    Point getConnectionPoint();

    void drawFigureOnBoard(UmlBoard umlBoard);

    void setPosition(int positionX, int positionY);
}
