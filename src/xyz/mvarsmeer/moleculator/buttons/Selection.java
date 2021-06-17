package xyz.mvarsmeer.moleculator.buttons;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.util.ArrayList;

import xyz.mvarsmeer.moleculator.draw.DrawAtom;
import xyz.mvarsmeer.moleculator.information.Atom;
import xyz.mvarsmeer.moleculator.readers.FontReader;

public class Selection implements ActionListener  {
	
	JFrame Activo;
	ArrayList<DrawAtom> Dibujar;
	ArrayList<Atom> Elementos;
	
	public void updateObject(ArrayList<DrawAtom> Lista, ArrayList<Atom> Elementos, JFrame Window) {
		
		this.Dibujar = Lista;
		this.Elementos = Elementos;
		this.Activo = Window;
		
	}

	public void CrearBoton(int x, int y, Atom Contenido, Color color) {

		FontReader Fuente = new FontReader();
		Font Fuente1 = Fuente.CreateFont("src\\xyz\\mvarsmeer\\moleculator\\resources\\ParadroidMono-Light.ttf", 10);

		JButton Boton = new JButton();

		String Numero ="<left>"+ Contenido.getEnlaces()+"</left><BR>";
		String Simbolo = "<center><big>"+Contenido.getSimbolo()+ "</center></big><BR>";
		String Nombre = "<center>"+ Contenido.getNombre()+"</center>";

		Boton.setText("<html><p>" + Numero + Simbolo + Nombre + "</p></html");
		Boton.setBounds(x, y, 85, 85);
		Boton.setBackground(color);
		Boton.setFont(Fuente1);
		Boton.addActionListener(this);
		Boton.setFocusPainted(false);
		this.Activo.add(Boton);

	}

	public void actionPerformed(ActionEvent e) {

		JButton Actual = (JButton) e.getSource();

		for(int i=0; i < Elementos.size() ;i++){

			if(Actual.getText().contains(">"+Elementos.get(i).getSimbolo()+"<")){

				Atom Atomo = Elementos.get(i);
				DrawAtom Dibujo = new DrawAtom(Actual.getX(),Actual.getY(), 60, Actual.getBackground(), Atomo);
				this.Dibujar.add(Dibujo);
				
			}

		}
		
		Activo.removeAll();
		this.Activo.dispose();
		
	}

}