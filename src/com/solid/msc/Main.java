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


        UmlObjectRelationship umlPanel = new UmlObjectRelationship();
        UmlObject object1 = new UmlClass(50, 50);
        UmlObject object2 = new UmlClass(100, 200);

        umlPanel.addUmlObject(object1);
        umlPanel.addUmlObject(object2);

        MenuPanel menu = new MenuPanel();
        this.getContentPane().add(menu, BorderLayout.WEST);


        this.getContentPane().add(umlPanel, BorderLayout.CENTER);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        Main x = new Main();
        x.init();

    }

}
