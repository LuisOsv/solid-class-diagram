package com.solid.msc;

import java.awt.*;

public class RelationHelper {

    private static RelationHelper relationHelper;
    private UmlObject originUmlObject;
    private Point targetTemporaryPoint;
    private  RelationshipType relationshipType;

    private void AddRelationHelper() {

    }

    public UmlObject getOriginUmlObject() {
        return originUmlObject;
    }

    public void setOriginUmlObject(UmlObject originUmlObject) {
        this.originUmlObject = originUmlObject;
    }

    public boolean isAddingRelation() {
        return originUmlObject != null;
    }

    public void completeRelation(UmlObject umlObject) {
        this.originUmlObject.relateUmlObject(umlObject);
        RelationHelper.getInstance().clear();
    }

    private void clear() {
        this.originUmlObject = null;
        this.targetTemporaryPoint = null;
    }

    public Point getTargetTemporaryPoint() {
        return targetTemporaryPoint;
    }

    public void setTargetTemporaryPoint(Point targetTemporaryPoint) {
        this.targetTemporaryPoint = targetTemporaryPoint;
    }

    public void setRelationshipType(RelationshipType relationshipType){
        this.relationshipType = relationshipType;
    }

    public RelationshipType getRelationshipType(){
        return relationshipType;
    }

    public static RelationHelper getInstance() {
        if (relationHelper == null) {
            relationHelper = new RelationHelper();
        }
        return relationHelper;
    }
}
