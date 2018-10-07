package com.solid.msc;

import java.awt.*;

public class RelationHelper {

    private static RelationHelper relationHelper;
    private DrawableComponent originUmlObject;
    private Point targetTemporaryPoint;
    private RelationshipType relationshipType;

    private void AddRelationHelper() {

    }

    public DrawableComponent getOriginUmlObject() {
        return originUmlObject;
    }

    public void setOriginUmlObject(DrawableComponent originUmlObject) {
        this.originUmlObject = originUmlObject;
    }

    public boolean isAddingRelation() {
        return originUmlObject != null;
    }

    public void completeRelation(DrawableComponent umlObject, RelationshipType relationshipType) {
        this.originUmlObject.addRelation(umlObject, relationshipType);
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

    public void setRelationshipType(RelationshipType relationshipType) {
        this.relationshipType = relationshipType;
    }

    public RelationshipType getRelationshipType() {
        return relationshipType;
    }

    public static RelationHelper getInstance() {
        if (relationHelper == null) {
            relationHelper = new RelationHelper();
        }
        return relationHelper;
    }
}
