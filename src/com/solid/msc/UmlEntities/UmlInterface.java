package com.solid.msc.UmlEntities;

import com.solid.msc.RelationshipType;
import com.solid.msc.UmlBoard;
import com.solid.msc.UmlObject;

import javax.swing.*;
import java.awt.*;

public class UmlInterface extends UmlObject {

    public UmlInterface(int positionX, int positionY) {
        super(positionX, positionY);
    }

    @Override
    public void drawRelation(Graphics2D graphics2D, Point originPoint, Point targetPoint, RelationshipType relationshipType) {
        super.drawRelation(graphics2D, originPoint, targetPoint, relationshipType);
    }

    @Override
    public String getName() {
        return "Interface";
    }

    @Override
    public void drawFigureOnBoard(UmlBoard umlBoard) {
        umlBoard.addUmlObject(this);
        this.getFigure().setVisible(false);
        this.getFigure().setVisible(true);

        JLabel interfaceLeftSymbol = new JLabel("<<");
        JLabel interfaceRightSymbol = new JLabel(">>");

        this.getFigure().add(interfaceLeftSymbol, BorderLayout.WEST);
        this.getFigure().add(this.getTextField(),BorderLayout.CENTER);
        this.getFigure().add(interfaceRightSymbol,BorderLayout.EAST);

        umlBoard.repaint();
    }

}
