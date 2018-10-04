package com.solid.msc;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class UmlObject extends JPanel {
	ArrayList<Component> relationShips;
	JTextField className;
	
	public ArrayList<Component> getRelationShips() {
		return relationShips;
	}

	public UmlObject() {
		relationShips =  new ArrayList<Component>();
        Rectangle r = new Rectangle(75, 75, 125, 40);
        
        //this.setLayout(new FlowLayout());
		className = new JTextField("Enter the name");
			
        
        this.setBounds(r);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.add(className);
       // this.repaint();
	}
	
	public void relateUmlObject(UmlObject childUmlObject){
		relationShips.add(childUmlObject);
	}
}
