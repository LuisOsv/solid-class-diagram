package com.solid.msc;

import javax.swing.*;


public class SelectableRelationships extends JPanel {

    public SelectableRelationships() {
        initializePanel();
        addEntities();
    }

    private void addEntities() {
        OptionMenuSelectable association = new OptionMenuSelectable("Association");
        OptionMenuSelectable dependency = new OptionMenuSelectable("Dependency");
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
