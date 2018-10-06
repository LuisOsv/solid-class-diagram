package com.solid.msc;

public class Relation {
    private DrawableObject targetDrawableObject;
    private RelationshipType relationshipType;

    public Relation(DrawableObject targetDrawableObject, RelationshipType relationshipType) {
        this.targetDrawableObject = targetDrawableObject;
        this.relationshipType = relationshipType;
    }

    public DrawableObject getTargetDrawableObject() {
        return targetDrawableObject;
    }

    public RelationshipType getRelationshipType() {
        return relationshipType;
    }
}
