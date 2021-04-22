package xyz.mvarsmeer.moleculator;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import java.util.ArrayList;

public class Windows {
	
	ArrayList<Atom> Elementos = new ArrayList<Atom>();
	Boolean Active = false;
	JFrame WindowActive;
	
	public Windows() {
		
		File archivo = new File();
		Elementos = archivo.LeerArchivo("src\\xyz\\mvarsmeer\\moleculator\\Elements.txt");
		
	}

	public void CreateWindow(String Seccion, Color color, ArrayList<DrawAtom> Dibujar) {
		
		JFrame Window = new JFrame(Seccion);
		
		if(Active == false) {

			WindowActive = Window;
			Active = true;

		}
		
		Window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Window.setSize(new Dimension(510, 360));
		Window.setLocationRelativeTo(null);
		Window.setIgnoreRepaint(false);
		Window.setResizable(false);
		Window.setLayout(null);
		Window.setVisible(true);
		
		Selection boton = new Selection(Dibujar, Window);
		
		int x = 10;
		int y = 13;
		
		for(int cont = 0; cont < Elementos.size(); cont++) {
			
			Atom Actual = Elementos.get(cont);
			
			if(Actual.getTipo().equals(Seccion)) {
				
				DrawAtom Elemento = new DrawAtom(x, y, color, Actual);
				boton.CrearBoton(x, y, Actual.getSimbolo(), color, Elemento);
				
				if(x < 375) {

					x += 60;

				} else {

					x = 10;
					y += 60;

				}
				
			}
			
		}
		
	}
	
}
