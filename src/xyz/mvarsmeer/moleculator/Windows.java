package xyz.mvarsmeer.moleculator;

import java.awt.Dimension;
import javax.swing.JFrame;
import java.awt.Color;
import java.util.ArrayList;

public class Windows {
	
	ArrayList<Atom> Elementos = new ArrayList<Atom>();
	Boolean Active = false;
	JFrame WindowActive;
	
	public Windows() {
		
		File archivo = new File();
		Elementos = archivo.LeerArchivo("src\\xyz\\mvarsmeer\\moleculator\\Elements.txt");
		
	}

	public void CreateWindow(String Seccion, Color color) {
		
		JFrame Window = new JFrame(Seccion);
		
		if(Active == false) {
			WindowActive = Window;
			Active = true;
		}
		
		Window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Window.setSize(new Dimension(480, 340));
		Window.setLocationRelativeTo(null);
		Window.setIgnoreRepaint(true);
		Window.setResizable(false);
		Window.setLayout(null);
		
		Window.setVisible(true);
		
		ArrayList<DrawAtom> Atomos = new ArrayList<DrawAtom>();
		
		int x = 20;
		int y = 45;
		
		for(int cont = 0; cont < Elementos.size(); cont++) {
			
			Atom Actual = Elementos.get(cont);
			
			if(Actual.getTipo().equals(Seccion)) {
				
				DrawAtom Atomo = new DrawAtom(x,y,color,Actual);
				Atomos.add(Atomo);
				
				if(x < 370) {
					x += 55;
				} else {
					x = 20;
					y += 56;
				}
				
			}
			
		}
		
		for(int cont = 0; cont < Atomos.size(); cont++) {
				
			Atomos.get(cont).paint(Window.getGraphics());
				
		}
		
	}
	
}
