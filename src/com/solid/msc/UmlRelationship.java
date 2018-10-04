package com.solid.msc;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import javax.swing.JPanel;

public class UmlRelationship extends JPanel {
	
	public UmlRelationship() {
		this.setLayout(null);
		DragPanel panelMover = new DragPanel(this);
        this.addMouseListener(panelMover);
        this.addMouseMotionListener(panelMover);
        //this.repaint();
		//this.setBounds(0, 0, 1000, 1000);
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
}
