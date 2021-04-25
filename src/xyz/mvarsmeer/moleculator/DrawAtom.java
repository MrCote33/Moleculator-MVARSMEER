package xyz.mvarsmeer.moleculator;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class DrawAtom {
	
	int x;
	int y;
	Color Paint;
	Atom Atomo;
	Boolean Active = true;
	Boolean Repaint = false;
	
	public DrawAtom(int X, int Y, Color Paint, Atom Atomo) {
		
		this.x = X;
		this.y = Y;
		this.Paint = Paint;
		this.Atomo = Atomo;
		
	}
	
	public void paint(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_SPEED);
		g2.setColor(this.Paint);
		g2.fillArc(this.x, this.y, 50, 50, 0, 360);
		
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.drawArc(this.x, this.y, 49, 49, 0, 360);
		
		g2.setColor(Color.decode("#000000"));
		g2.setFont(new Font("Courier", Font.PLAIN, 17));
		
		if(Atomo.getSimbolo().length() == 2) {

			g2.drawString(this.Atomo.getSimbolo(), this.x+15, this.y+25);

		} else {

			g2.drawString(this.Atomo.getSimbolo(), this.x+20, this.y+25);

		}
		
		g2.setFont(new Font("Courier", Font.PLAIN, 12));
		
		if(Atomo.getEnlaces() >= 10) {

			g2.drawString(String.valueOf(this.Atomo.getEnlaces()), this.x+17, this.y+37);

		} else {

			g2.drawString(String.valueOf(this.Atomo.getEnlaces()), this.x+21, this.y+37);

		}
		
	}
	
	public void repaint(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		g2.fillRect(0, 0, 586, 380);
		
	}
	
}