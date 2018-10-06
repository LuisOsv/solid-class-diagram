package com.solid.msc;

import javax.swing.*;


public class SelectableUMLRelationships extends JPanel {

    public SelectableUMLRelationships() {
        initializePanel();
        addEntities();
    }

    private void addEntities() {
        MenuBuilderUMLRelationships association = new MenuBuilderUMLRelationships(RelationshipType.ASSOCIATION);
        MenuBuilderUMLRelationships dependency = new MenuBuilderUMLRelationships(RelationshipType.DEPENDENCY);
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
