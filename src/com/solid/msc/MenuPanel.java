package com.solid.msc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;


public class MenuPanel extends JPanel {

	private UmlObjectRelationship panelToAddObjects;
	private JButton line;
	
	public MenuPanel(UmlObjectRelationship panelToAddObjects){
		this.panelToAddObjects = new UmlObjectRelationship();
		
		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		line = new JButton("Line");
		line.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});

		this.add(new OptionMenuDraggable("Class"));
		
	}
	
	
}
