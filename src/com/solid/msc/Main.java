package com.solid.msc;

import com.solid.msc.UmlEntities.UmlClass;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public void init() {


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400);
        this.setLocation(200, 200);
        this.getContentPane().setLayout(new BorderLayout());


        UmlBoard umlBoard = new UmlBoard();
        UmlObject object1 = new UmlClass(50, 50);
        UmlObject object2 = new UmlClass(100, 200);

        umlBoard.addUmlObject(object1);
        umlBoard.addUmlObject(object2);

        JPanel menus = new JPanel();
        BoxLayout layout1 = new BoxLayout(menus, BoxLayout.Y_AXIS);
        menus.setLayout(layout1);
        BuilderUMLComponents builderUMLComponents = new BuilderUMLComponents(umlBoard);
        SelectableUMLRelationships selectableUMLRelationships = new SelectableUMLRelationships();

        builderUMLComponents.setAlignmentX(Component.LEFT_ALIGNMENT);
        selectableUMLRelationships.setAlignmentX(Component.LEFT_ALIGNMENT);


        menus.add(builderUMLComponents);
        menus.add(selectableUMLRelationships);

        this.getContentPane().add(menus, BorderLayout.WEST);


        this.getContentPane().add(umlBoard, BorderLayout.CENTER);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        Main x = new Main();
        x.init();

    }

}
