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
		
		ReaderFile archivo = new ReaderFile();
		Elementos = archivo.LeerArchivo("src\\xyz\\mvarsmeer\\moleculator\\Elements.txt");
		
	}

	public void CreateWindow(String Seccion, Color color, ArrayList<DrawAtom> Dibujar) {
		
		JFrame Window = new JFrame(Seccion);
		
		if(Active == false) {

			WindowActive = Window;
			Active = true;

		}
		
		Window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Window.setSize(new Dimension(716, 484));
		Window.setLocationRelativeTo(null);
		Window.setResizable(false);
		Window.setLayout(null);
		Window.setVisible(true);
		
		Selection boton = new Selection(Dibujar, Elementos, Window);
		
		int x = 10;
		int y = 10;
		
		for(int cont = 0; cont < Elementos.size(); cont++) {
			
			Atom Actual = Elementos.get(cont);
			
			if(Actual.getTipo().equals(Seccion)) {
				
				boton.CrearBoton(x, y, Actual, color);
				
				if(x < 550) {

					x += 85;

				} else {

					x = 10;
					y += 85;

				}
				
			}
			
		}
		
	}
	
}
