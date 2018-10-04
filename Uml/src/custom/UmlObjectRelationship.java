package custom;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import javax.swing.JPanel;
import javax.swing.TransferHandler;

public class UmlObjectRelationship extends JPanel implements DropTargetListener {
	DropTarget dt;
	public UmlObjectRelationship() {
		this.setLayout(null);
		
		
		DragPanel panelMover = new DragPanel(this);
        this.addMouseListener(panelMover);
        this.addMouseMotionListener(panelMover);
        //this.repaint();
		//this.setBounds(0, 0, 1000, 1000);
        dt = new DropTarget(new UmlObject(), this);
        
        new DropTarget(this, this);
	}

	
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        
        
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        Component[] c = getComponents();
        for (int i=0;i<c.length;i++){
        	UmlObject parentUmlObject = (UmlObject) c[i];
        	if(parentUmlObject.getRelationShips().size()>0){
        		Point2D.Double p1 = getCenter(parentUmlObject);
        		for (int j=0; j<parentUmlObject.getRelationShips().size(); j++){
        			UmlObject childUmlObject = (UmlObject) parentUmlObject.getRelationShips().get(j);
        			Point2D.Double p2 = getCenter(childUmlObject);
                    g2.draw(new Line2D.Double(p1, p2));
        		}
        	}
        }
        //repaint();
        /*
        for(int j = 0; j < c.length; j++) {
            Point2D.Double p1 = getCenter(c[j]);
            for(int k = j+1; k < c.length; k++) {
                Point2D.Double p2 = getCenter(c[k]);
                g2.draw(new Line2D.Double(p1, p2));
            }
        }
        */
    }
  
    private Point2D.Double getCenter(Component c) {
        Point2D.Double p = new Point2D.Double();
        Rectangle r = c.getBounds();
        p.x = r.getCenterX();
        p.y = r.getCenterY();
        return p;
    }
    
    public void addUmlObject(Component umlObject) {
    	this.add(umlObject);
    }


	@Override
	public void dragEnter(DropTargetDragEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void dragExit(DropTargetEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void dragOver(DropTargetDragEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void drop(DropTargetDropEvent arg0) {
		UmlObject object = new UmlObject((int)arg0.getLocation().getX(),(int)arg0.getLocation().getY());
		addUmlObject(object);
		System.out.println("Detecto drop");
		object.setVisible(false);
		object.setVisible(true);
		repaint();
		
	}


	@Override
	public void dropActionChanged(DropTargetDragEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
