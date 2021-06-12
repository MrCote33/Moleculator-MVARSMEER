package xyz.mvarsmeer.moleculator.draw;

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
		this.EnlEfectivos = 0;
		
	}
	
	public void setSecond(DrawAtom Actual) {

		this.Segundo = Actual;
		this.Segundo.Repaint = true;
		updateColor();
		this.EnlEfectivos += 1;

	}
	
	public void updateColor() {
		
		int R = (this.Primero.Paint.getRed() + this.Segundo.Paint.getRed()) / 2;
		int G = (this.Primero.Paint.getGreen() + this.Segundo.Paint.getGreen()) / 2;
		int B = (this.Primero.Paint.getBlue() + this.Segundo.Paint.getBlue()) / 2;
		
		this.Paint = Color.decode("#"+Integer.toHexString(R)+Integer.toHexString(G)+Integer.toHexString(B));
		
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
		
		int MedioX = ((Primero.x + (Primero.Diametro/2)) + (Segundo.x + (Segundo.Diametro/2))) / 2;
		int MedioY = ((Primero.y + (Primero.Diametro/2)) + (Segundo.y + (Segundo.Diametro/2))) / 2;
		
		g2.fillArc(MedioX-14, MedioY-13, 30, 30, 0, 360);
		
		g2.setColor(Color.BLACK);
		g2.drawString(String.valueOf(this.EnlEfectivos), MedioX-2, MedioY+5);

	}

}
