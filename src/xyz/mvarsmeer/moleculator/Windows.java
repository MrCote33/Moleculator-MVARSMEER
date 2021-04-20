package xyz.mvarsmeer.moleculator;

import java.awt.Color;
import java.awt.Dimension;
//import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
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
		
		JPanel DrawZone = new JPanel();
		DrawZone.setBounds(0,0,480,320);
		Window.add(DrawZone);
		
		/*JButton TEST = new JButton("Add");
		TEST.setBounds(15,15,60,25);
		Window.add(TEST);*/
		
		ArrayList<DrawAtom> Atomos = new ArrayList<DrawAtom>();
		
		int x = 15;
		int y = 15;
		
		for(int cont = 0; cont < Elementos.size(); cont++) {
			
			Atom Actual = Elementos.get(cont);
			
			if(Actual.getTipo().equals(Seccion) && !Actual.getSimbolo().equals("")) {
				
				DrawAtom Atomo = new DrawAtom(x,y,color,Actual);
				//Aqui creacion de boton "Add"
				Atomos.add(Atomo);
				
				if(x < 370) {
					x += 55;
				} else {
					x = 15;
					y += 55;
				}
				
			}
			
		}
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for(int cont = 0; cont < Atomos.size(); cont++) {
			
			Atomos.get(cont).paint(DrawZone.getGraphics());
			
		}
		
	}
	
}
