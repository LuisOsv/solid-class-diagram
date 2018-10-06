package com.solid.msc;

import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;

public class RelationshipTypesEventListener extends MouseInputAdapter {

    private RelationshipType relationshipType;
    public RelationshipTypesEventListener(RelationshipType relationshipType){
        this.relationshipType = relationshipType;
    }
    @Override
    public void mouseClicked(MouseEvent mouseEvent){
        super.mouseClicked(mouseEvent);
        System.out.println(relationshipType);
        RelationHelper.getInstance().setRelationshipType(relationshipType);
    }
}
