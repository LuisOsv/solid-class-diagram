package com.solid.msc;

public class Relation {
    private DrawableComponent targetDrawableObject;
    private RelationshipType relationshipType;

    public Relation(DrawableComponent targetDrawableObject, RelationshipType relationshipType) {
        this.targetDrawableObject = targetDrawableObject;
        this.relationshipType = relationshipType;
    }

    public DrawableComponent getTargetDrawableObject() {
        return targetDrawableObject;
    }

    public RelationshipType getRelationshipType() {
        return relationshipType;
    }
}
