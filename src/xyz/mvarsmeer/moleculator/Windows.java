package xyz.mvarsmeer.moleculator;

import java.awt.Dimension;
import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Color;
import java.util.ArrayList;

public class Windows {
	
	ArrayList<Atom> Elementos = new ArrayList<Atom>();
	
	public Windows() {
		
		File archivo = new File();
		Elementos = archivo.LeerArchivo("src\\xyz\\mvarsmeer\\moleculator\\Elements.txt");
		
	}

	public void CreateWindow(String Seccion, Color color) {
		
		JFrame Window = new JFrame(Seccion);
		Window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Window.setSize(new Dimension(480, 340));
		Window.setLocationRelativeTo(null);
		Window.setResizable(false);
		Window.setLayout(null);
		
		Canvas DrawingZone = new Canvas();
		DrawingZone.setBounds(0,0,480,300);
		DrawingZone.setIgnoreRepaint(true);
		Window.add(DrawingZone);
		
		Window.setVisible(true);
		
		ArrayList<DrawAtom> Atomos = new ArrayList<DrawAtom>();
		
		int x = 15;
		int y = 15;
		
		for(int cont = 0; cont < Elementos.size(); cont++) {
			
			Atom Actual = Elementos.get(cont);
			
			if(Actual.getTipo().equals(Seccion)) {
				
				DrawAtom Atomo = new DrawAtom(x,y,color,Actual);
				Atomos.add(Atomo);
				
				if(x < 350) {
					x += 55;
				} else {
					x = 15;
					y += 55;
				}
				
			}
			
		}
		
		for(int cont = 0; cont < Atomos.size(); cont++) {
				
			Atomos.get(cont).paint(DrawingZone.getGraphics());
				
		}
		
	}
	
}
