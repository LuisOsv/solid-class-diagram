package com.solid.msc;

import com.solid.msc.UmlEntities.UmlComponent;

import java.awt.*;

public class RelationHelper {

    private static RelationHelper relationHelper;
    private UmlComponent originUmlObject;
    private Point targetTemporaryPoint;
    private RelationshipType relationshipType;

    private RelationHelper() {
        relationshipType = RelationshipType.ASSOCIATION;
    }

    public UmlComponent getOriginUmlObject() {
        return originUmlObject;
    }

    public void setOriginUmlObject(UmlComponent originUmlObject) {
        this.originUmlObject = originUmlObject;
    }

    public boolean isAddingRelation() {
        return originUmlObject != null;
    }

    public void completeRelation(UmlComponent umlObject, RelationshipType relationshipType) {
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
