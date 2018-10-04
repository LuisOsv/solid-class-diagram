package custom;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JFrame;

public class Main extends JFrame {
	
	public void init() {
		
		 
	     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     this.setSize(400,400);
	     this.setLocation(200,200);
	     this.getContentPane().setLayout(new BorderLayout());
	     
	     
	     
	     UmlRelationship umlPanel = new UmlRelationship();
	     UmlObject object1 = new UmlObject();
	     UmlObject object2 = new UmlObject();
	     UmlObject object3 = new UmlObject();
	     
	     object1.relateUmlObject(object3);
	     object1.relateUmlObject(object2);
	     
	     umlPanel.addUmlObject(object1);
	     umlPanel.addUmlObject(object2);
	     umlPanel.addUmlObject(object3);
	     
	     MenuPanel menu = new MenuPanel(umlPanel);
	     this.getContentPane().add(menu,BorderLayout.WEST);
	     
	     
	     this.getContentPane().add(umlPanel,BorderLayout.CENTER);
	     
	     this.setVisible(true);
	}

	public static void main(String[] args) {
		Main x = new Main();
		x.init();

	}

}
