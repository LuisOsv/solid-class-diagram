package com.solid.msc.UmlEntities;

import com.solid.msc.RelationshipType;
import com.solid.msc.UmlBoard;
import com.solid.msc.UmlObject;

import java.awt.*;

public class UmlClass extends UmlObject {

    @Override
    public void drawRelation(Graphics2D graphics2D, Point originPoint, Point targetPoint, RelationshipType relationshipType) {
        super.drawRelation(graphics2D, originPoint, targetPoint, relationshipType);
    }

    @Override
    public String getName() {
        return "Class";
    }

    @Override
    public void drawFigureOnBoard(UmlBoard umlBoard) {
        umlBoard.addUmlObject(this);
        this.getFigure().setVisible(false);
        this.getFigure().setVisible(true);
        umlBoard.repaint();
    }
}
