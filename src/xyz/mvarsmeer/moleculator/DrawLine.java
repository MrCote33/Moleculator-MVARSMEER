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

	
	public void setFirst(DrawAtom Actual) {

		this.Primero = Actual;
		
	}
	
	public void setSecond(DrawAtom Actual) {

		this.Segundo = Actual;
		this.Segundo.Repaint = true;
		this.EnlEfectivos = EnlEfectivos+1;

	}

	public void paint(Graphics g){

		FontReader Fuente = new FontReader();
		Font Fuente1 = Fuente.CreateFont("src\\xyz\\mvarsmeer\\moleculator\\JetBrainsMono-Bold.ttf", 12);

		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		g2.setFont(Fuente1);
		g2.setColor(Color.decode("#FF0000"));

		g2.setStroke(new BasicStroke(6));

		g2.drawLine(Primero.x+(Primero.Diametro/2), Primero.y+(Primero.Diametro/2), Segundo.x+(Segundo.Diametro/2), Segundo.y+(Segundo.Diametro/2));
		g2.setColor(Color.WHITE);

		g2.drawString(String.valueOf(EnlEfectivos), Primero.x+Primero.Diametro,  Primero.y);
		g2.drawString(String.valueOf(EnlEfectivos), Segundo.x+Segundo.Diametro,  Segundo.y);

	}

}
