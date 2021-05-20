package xyz.mvarsmeer.moleculator;

import java.awt.Font;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class DrawLine {
	
	DrawAtom Primero;
	DrawAtom Segundo;
	int EnlEfectivos;
	Color Paint;
	
	public void setFirst(DrawAtom Actual) {

		this.Primero = Actual;
		
	}
	
	public void setSecond(DrawAtom Actual) {

		this.Segundo = Actual;
		this.Segundo.Repaint = true;
		
		int R = (this.Primero.Paint.getRed() + this.Segundo.Paint.getRed()) / 2;
		int G = (this.Primero.Paint.getGreen() + this.Segundo.Paint.getGreen()) / 2;
		int B = (this.Primero.Paint.getBlue() + this.Segundo.Paint.getBlue()) / 2;
		
		this.Paint = Color.decode("#"+Integer.toHexString(R)+Integer.toHexString(G)+Integer.toHexString(B));
		this.EnlEfectivos = EnlEfectivos+1;

	}

	public void paint(Graphics g){

		FontReader Fuente = new FontReader();
		Font Fuente1 = Fuente.CreateFont("src\\xyz\\mvarsmeer\\moleculator\\JetBrainsMono-Bold.ttf", 12);

		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		g2.setFont(Fuente1);
		g2.setColor(Paint);

		g2.setStroke(new BasicStroke(6));

		g2.drawLine(Primero.x+(Primero.Diametro/2), Primero.y+(Primero.Diametro/2), Segundo.x+(Segundo.Diametro/2), Segundo.y+(Segundo.Diametro/2));
		g2.setColor(Color.WHITE);

		g2.drawString(String.valueOf(EnlEfectivos), Primero.x+Primero.Diametro,  Primero.y);
		g2.drawString(String.valueOf(EnlEfectivos), Segundo.x+Segundo.Diametro,  Segundo.y);

	}

}
