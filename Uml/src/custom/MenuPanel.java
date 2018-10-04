package custom;

import javax.swing.BoxLayout;
import javax.swing.JPanel;


public class MenuPanel extends JPanel {

	private UmlRelationship panelToAddObjects;
	
	public MenuPanel(UmlRelationship panelToAddObjects){
		this.panelToAddObjects = new UmlRelationship();
		
		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		this.add(new OptionMenuDraggable("Class"));
		
	}
	
	
}
