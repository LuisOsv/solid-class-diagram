package com.solid.msc.umlRelationShip;

import com.solid.msc.RelationshipType;

import java.awt.*;
import java.awt.geom.Point2D;

public class UmlRelationShipFactory {

    public static UmlRelationshipDrawer getUmlRelationShip(RelationshipType relationshipType, Graphics2D graphics2D,
                                                           Point2D originPoint, Point2D targetPoint) {
        UmlRelationshipDrawer umlRelationshipDrawer = null;

        switch (relationshipType) {
            case DEPENDENCY: {
                umlRelationshipDrawer =
                        new DependencyRelationShip(graphics2D, originPoint, targetPoint, Color.BLACK, Color.BLACK, Color.WHITE);
                break;
            }
            case ASSOCIATION: {
                umlRelationshipDrawer =
                        new AssociationRelationShip(graphics2D, originPoint, targetPoint, Color.BLACK, Color.BLACK, Color.WHITE);
            }
        }

        return umlRelationshipDrawer;
    }

}
