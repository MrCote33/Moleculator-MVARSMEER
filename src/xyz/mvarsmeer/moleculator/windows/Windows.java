package xyz.mvarsmeer.moleculator.windows;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.util.ArrayList;

import xyz.mvarsmeer.moleculator.buttons.Selection;
import xyz.mvarsmeer.moleculator.draw.DrawAtom;
import xyz.mvarsmeer.moleculator.information.Atom;
import xyz.mvarsmeer.moleculator.readers.ReaderFile;

public class Windows {
	
	ArrayList<ArrayList<Atom>> Elementos = new ArrayList<ArrayList<Atom>>();
	Selection Botones = new Selection();
	
	public Boolean Active = false;
	public JFrame WindowActive;
	
	public Windows() {
		
		ReaderFile archivo = new ReaderFile();
		Elementos = archivo.LeerArchivo("src\\xyz\\mvarsmeer\\moleculator\\resources\\Elements.txt");
		
	}

	public void CreateWindow(JButton Boton, String Seccion, Color color, ArrayList<DrawAtom> Dibujar) {
		
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
		
		ArrayList<Atom> Atomos = Elementos.get((Boton.getY()-82)/30);
		Botones.updateObject(Dibujar, Atomos, Window);
		
		int x = 10;
		int y = 10;
		
		for(int cont = 0; cont < Atomos.size(); cont++) {
			
			Atom Actual = Atomos.get(cont);
			Botones.CrearBoton(x, y, Actual, color);
				
			if(x < 550) {

				x += 85;

			} else {

				x = 10;
				y += 85;
				
			}
			
		}
		
	}
	
}
