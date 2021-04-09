package xyz.mvarsmeer.moleculator;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class DrawAtom {
	
	String Paint = "#00FF00";
	
	public void paint(Graphics g, int x, int y) {
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_SPEED);
		
		g2.fillRect(0, 0, 586, 380);
		g2.setColor(Color.decode(Paint));
		g2.fillArc(x, y, 50, 50, 0, 360);
		
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.drawArc(x, y, 49, 49, 0, 360);
		
		g2.setColor(Color.decode("#000000"));
		g2.setFont(new Font("Arial", Font.BOLD, 17));
		g2.drawString("H", x+19, y+30);
		
	}

}