package com.solid.msc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class MenuPanel extends JPanel {

	private JToggleButton classObject;
	private JToggleButton interfaceObject;
	private UmlRelationship panelToAddObjects;
	
	public MenuPanel(UmlRelationship panelToAddObjects){
		this.panelToAddObjects = panelToAddObjects;
		
		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
				
		classObject = new JToggleButton("Insert a class");
		interfaceObject = new JToggleButton("Insert a Interface");
		
		classObject.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				UmlObject umlObjet = new UmlObject();

				MenuPanel.this.panelToAddObjects.addUmlObject(umlObjet);
				umlObjet.setVisible(false);
				umlObjet.setVisible(true);
				
				
				//panelToAddObjects.getTopLevelAncestor().repaint();
				//panelToAddObjects.repaint();
				
				
			}
		});
		
		this.add(classObject);
		this.add(interfaceObject);	
		
	}
}
