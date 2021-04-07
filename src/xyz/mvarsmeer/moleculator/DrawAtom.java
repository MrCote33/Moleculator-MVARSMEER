package xyz.mvarsmeer.moleculator;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;

public class DrawAtom {
	
	public void paint(Graphics g, Point location) {
		
		int X = 0;
		int Y = 0;
		
		if(location == null) {
			X = 0;
			Y = 0;
		} else {
			X = location.x - 25;
			Y = location.y - 25;
		}
		
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(Color.decode("#D8A4DE"));
		g2.drawArc(X, Y, 50, 50, 0, 360);
		g2.fillArc(X, Y, 51, 51, 0, 360);
		
	}

}