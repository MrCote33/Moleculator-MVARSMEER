package xyz.mvarsmeer.moleculator.draw;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import xyz.mvarsmeer.moleculator.information.Atom;
import xyz.mvarsmeer.moleculator.readers.FontReader;

public class DrawAtom {
	
	public int x;
	public int y;
	public int Diametro;
	public int Enlaces;
	public Color Paint;
	public Atom Atomo;
	public Boolean Active = true;
	public Boolean Repaint = false;
	public int ID;
	
	public DrawAtom(int X, int Y,int Diametro, Color Paint, Atom Atomo) {
		
		this.x = X;
		this.y = Y;
		this.Diametro = Diametro;
		this.Paint = Paint;
		this.Atomo = Atomo;
		this.Enlaces = Atomo.getEnlaces();
		
	}
	
	public void paint(Graphics g) {

		FontReader Fuente = new FontReader();
		Font FuenteSimbolo = Fuente.CreateFont("src\\xyz\\mvarsmeer\\moleculator\\resources\\ParadroidMono-Light.ttf", Diametro/3);
		Font FuenteEnl = Fuente.CreateFont("src\\xyz\\mvarsmeer\\moleculator\\resources\\ParadroidMono-Light.ttf", Diametro/6);

		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		g2.setColor(this.Paint);
		g2.fillArc(this.x, this.y, Diametro, Diametro, 0, 360);
		
		g2.setColor(Color.decode("#000000"));
		g2.setFont(FuenteSimbolo);
		
		if(Atomo.getSimbolo().length() == 2) {

			g2.drawString(this.Atomo.getSimbolo(), this.x + 3*Diametro/9 , this.y + Diametro/2);

		} else {

			g2.drawString(this.Atomo.getSimbolo(), this.x + 2*Diametro/5 , this.y + Diametro/2);

		}
		
		g2.setFont(FuenteEnl);
		
		if(Atomo.getEnlaces() >= 10) {

			g2.drawString(String.valueOf(this.Enlaces + "/" + this.Atomo.getTotalEnl()), this.x + 2*Diametro/7, this.y + 4*Diametro/5);

		} else {

			g2.drawString(String.valueOf(this.Enlaces + "/" + this.Atomo.getTotalEnl()), this.x + 3*Diametro/8 , this.y + 4*Diametro/5);

		}
		
	}
	
	public void repaint(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		g2.fillRect(0, 0, 7680, 4320);
		
	}
	
}