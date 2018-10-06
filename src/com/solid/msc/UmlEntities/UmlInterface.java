package com.solid.msc.UmlEntities;

import com.solid.msc.UmlObject;

import java.awt.*;

public class UmlInterface extends UmlObject {

    public UmlInterface(int positionX, int positionY) {
        super(positionX, positionY);
    }

    @Override
    public void drawRelation(Graphics2D graphics2D, Point point1, Point point2) {
        super.drawRelation(graphics2D, point1, point2);
    }

    @Override
    public String getName() {
        return "Interface";
    }
}
