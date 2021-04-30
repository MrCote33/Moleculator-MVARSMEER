package xyz.mvarsmeer.moleculator;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Selection implements ActionListener  {
    
	JFrame Activo;
    ArrayList<DrawAtom> Dibujar;
    ArrayList<Atom> Elementos;
    
    public Selection(ArrayList<DrawAtom> Lista, ArrayList<Atom> Elementos, JFrame Window) {
    	
    	this.Dibujar = Lista;
    	this.Elementos = Elementos;
    	this.Activo = Window;
    	
    }

    public void CrearBoton(int x, int y, Atom Contenido, Color color) {

		JButton Boton = new JButton();

		String Numero ="<left>"+ Contenido.getEnlaces()+"</left><BR>";
		String Simbolo = "<center><big>"+Contenido.getSimbolo()+ "</center></big><BR>";
		String Nombre = "<center>"+ Contenido.getNombre()+"</center>";

		Boton.setText("<html><p>" + Numero + Simbolo + Nombre + "</p></html");
		Boton.setBounds(x, y, 85, 85);
        Boton.setBackground(color);
        Boton.setFont(new Font("Courier", Font.PLAIN, 12));
		Boton.addActionListener(this);
		Boton.setFocusPainted(false);
		this.Activo.add(Boton);

	}

	public void actionPerformed(ActionEvent e) {

		JButton Actual = (JButton) e.getSource();

		for(int i=0; i < Elementos.size() ;i++){

			if(Actual.getText().equals(Elementos.get(i).getSimbolo())){

				Atom Atomo = Elementos.get(i);
				DrawAtom Dibujo = new DrawAtom(Actual.getX(),Actual.getY(), Actual.getBackground(), Atomo);
				this.Dibujar.add(Dibujo);
				
			}

		}

		this.Activo.dispose();
		
	}

}