package xyz.mvarsmeer.moleculator;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class DrawAtom {
	
	int x;
	int y;
	int Diametro;
	int Enlaces;
	Color Paint;
	Atom Atomo;
	Boolean Active = true;
	Boolean Repaint = false;
	
	public DrawAtom(int X, int Y,int Diametro, Color Paint, Atom Atomo) {
		
		this.x = X;
		this.y = Y;
		this.Diametro = Diametro;
		this.Paint = Paint;
		this.Atomo = Atomo;
		this.Enlaces = Atomo.getEnlaces();
		
	}
	
	public void paint(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		g2.setColor(this.Paint);
		g2.fillArc(this.x, this.y, Diametro, Diametro, 0, 360);
		
		g2.setColor(Color.decode("#000000"));
		g2.setFont(new Font("Courier", Font.PLAIN, Diametro/3));
		
		if(Atomo.getSimbolo().length() == 2) {

			g2.drawString(this.Atomo.getSimbolo(), this.x + Diametro/2 - 9, this.y + Diametro/2);

		} else {

			g2.drawString(this.Atomo.getSimbolo(), this.x + Diametro/2 - 5, this.y + Diametro/2);

		}
		
		g2.setFont(new Font("Courier", Font.PLAIN, Diametro / 5));
		
		if(Atomo.getEnlaces() >= 10) {

			g2.drawString(String.valueOf(this.Enlaces + " / " + this.Atomo.getTotalEnl()), this.x + Diametro/2 - 17, this.y + Diametro/2 + 18);

		} else {

			g2.drawString(String.valueOf(this.Enlaces + " / " + this.Atomo.getTotalEnl()), this.x + Diametro/2 - 8, this.y + Diametro/2 + 18);

		}
		
	}
	
	public void repaint(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		g2.clearRect(0, 0, 8000, 8000);;
		
	}
	
}