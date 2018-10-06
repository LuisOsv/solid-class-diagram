package com.solid.msc;

import java.awt.*;

public class RelationHelper {

    private static RelationHelper relationHelper;
    private DrawableObject originUmlObject;
    private Point targetTemporaryPoint;

    private void AddRelationHelper() {

    }

    public DrawableObject getOriginUmlObject() {
        return originUmlObject;
    }

    public void setOriginUmlObject(DrawableObject originUmlObject) {
        this.originUmlObject = originUmlObject;
    }

    public boolean isAddingRelation() {
        return originUmlObject != null;
    }

    public void completeRelation(DrawableObject umlObject) {
        this.originUmlObject.addRelation(umlObject);
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

    public static RelationHelper getInstance() {
        if (relationHelper == null) {
            relationHelper = new RelationHelper();
        }
        return relationHelper;
    }
}
