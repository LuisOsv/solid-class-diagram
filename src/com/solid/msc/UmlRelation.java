package com.solid.msc;

import com.solid.msc.UmlEntities.UmlComponent;

public class UmlRelation {
    private UmlComponent targetDrawableObject;
    private RelationshipType relationshipType;

    public UmlRelation(UmlComponent targetDrawableObject, RelationshipType relationshipType) {
        this.targetDrawableObject = targetDrawableObject;
        this.relationshipType = relationshipType;
    }

    public UmlComponent getTargetDrawableObject() {
        return targetDrawableObject;
    }

    public RelationshipType getRelationshipType() {
        return relationshipType;
    }
}
