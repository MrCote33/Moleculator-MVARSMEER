package xyz.mvarsmeer.moleculator;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class DrawLine {
	
	DrawAtom Primero;
	DrawAtom Segundo;
	
	public void setFirst(DrawAtom Actual) {

		this.Primero = Actual;
		
	}
	
	public void setSecond(DrawAtom Actual) {

		this.Segundo = Actual;
		this.Segundo.Repaint = true;

	}

	public void paint(Graphics g){

		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		g2.setColor(Color.decode("#FF0000"));
		g2.setStroke(new BasicStroke(6));
		g2.drawLine(Primero.x+25, Primero.y+25, Segundo.x+25, Segundo.y+25);

	}

}
