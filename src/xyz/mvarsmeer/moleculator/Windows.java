package xyz.mvarsmeer.moleculator;

import java.awt.Dimension;
import javax.swing.JFrame;
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
		Window.setSize(new Dimension(480, 335));
		Window.setLocationRelativeTo(null);
		Window.setLayout(null);
		Window.setResizable(false);
		Window.setVisible(true);
		
	}
	
}
