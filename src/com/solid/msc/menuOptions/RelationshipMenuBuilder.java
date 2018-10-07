package com.solid.msc.menuOptions;

import com.solid.msc.RelationshipType;

import javax.swing.*;


public class RelationshipMenuBuilder extends JPanel {

    public RelationshipMenuBuilder() {
        initializePanel();
        addEntities();
    }

    private void addEntities() {
        RelationshipMenuItem association = new RelationshipMenuItem(RelationshipType.ASSOCIATION);
        association.setSelected(true);
        RelationshipMenuItem dependency = new RelationshipMenuItem(RelationshipType.DEPENDENCY);
        ButtonGroup group = new ButtonGroup();
        group.add(association);
        group.add(dependency);
        this.add(association);
        this.add(dependency);
    }

    private void initializePanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createTitledBorder("Relations"));
    }
}
