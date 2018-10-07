package com.solid.msc.menuOptions;

import com.solid.msc.RelationshipType;

import javax.swing.*;
import java.awt.*;

public class RelationshipMenuItem extends JToggleButton {

    public RelationshipMenuItem(RelationshipType relationshipType) {
        super(relationshipType.toString());
        this.setMaximumSize(new Dimension(100, 50));
        this.setAlignmentX(Component.LEFT_ALIGNMENT);
        RelationshipTypesEventListener relationshipTypesEventListener = new RelationshipTypesEventListener(relationshipType);
        this.addMouseListener(relationshipTypesEventListener);
    }
}
