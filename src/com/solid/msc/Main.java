package com.solid.msc;

import com.solid.msc.UmlEntities.UmlClass;
import com.solid.msc.UmlEntities.UmlObject;
import com.solid.msc.menuOptions.EntityMenuBuilder;
import com.solid.msc.menuOptions.RelationshipMenuBuilder;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public void init() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400);
        this.setLocation(200, 200);
        this.getContentPane().setLayout(new BorderLayout());

        UmlBoard umlBoard = new UmlBoard();
        UmlObject umlObject1 = new UmlClass();
        umlObject1.setPosition(50, 50);
        UmlObject umlObject2 = new UmlClass();
        umlObject2.setPosition(100, 200);

        umlBoard.addUmlObject(umlObject1);
        umlBoard.addUmlObject(umlObject2);

        JPanel menus = new JPanel();
        BoxLayout layout1 = new BoxLayout(menus, BoxLayout.Y_AXIS);
        menus.setLayout(layout1);
        EntityMenuBuilder builderUMLComponents = new EntityMenuBuilder(umlBoard);
        RelationshipMenuBuilder relationshipMenuBuilder = new RelationshipMenuBuilder();

        builderUMLComponents.setAlignmentX(Component.LEFT_ALIGNMENT);
        relationshipMenuBuilder.setAlignmentX(Component.LEFT_ALIGNMENT);

        menus.add(builderUMLComponents);
        menus.add(relationshipMenuBuilder);

        this.getContentPane().add(menus, BorderLayout.WEST);
        this.getContentPane().add(umlBoard, BorderLayout.CENTER);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        Main application = new Main();
        application.init();
    }
}
