package com.solid.msc;

import java.awt.Component;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputAdapter;


public class DragPanel extends MouseInputAdapter {
	UmlObjectRelationship panel;
    Point offset = new Point();
    int selectedIndex;
    boolean dragging = false;
  
    DragPanel(UmlObjectRelationship umlRelationship) {
        this.panel = umlRelationship;
    }
  
    public void mousePressed(MouseEvent e) {
        Point p = e.getPoint();
        // This way of identifying the target JPanel should work as
        // long as the target is not focusable and does not contain
        // any components that consume MouseEvents, eg, JTextField.
        Component[] c = panel.getComponents();
        for(int j = 0; j < c.length; j++) {
            Rectangle r = c[j].getBounds();
            if(r.contains(p)) {
                offset.x = p.x - r.x;
                offset.y = p.y - r.y;
                selectedIndex = j;
                dragging = true;
                break;
            }
        }
    }
  
    public void mouseReleased(MouseEvent e) {
        dragging = false;
    }
  
    public void mouseDragged(MouseEvent e) {
        if(dragging) {
            int x = e.getX() - offset.x;
            int y = e.getY() - offset.y;
            panel.getComponent(selectedIndex).setLocation(x, y);
            panel.repaint();
        }
    }
}
