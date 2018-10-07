package com.solid.msc.menuOptions;

import com.solid.msc.RelationHelper;
import com.solid.msc.RelationshipType;

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
        RelationHelper.getInstance().setRelationshipType(relationshipType);
    }
}
