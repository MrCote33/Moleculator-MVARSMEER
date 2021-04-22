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
    
    public Selection(ArrayList<DrawAtom> Lista, JFrame Window) {
    	
    	this.Dibujar = Lista;
    	this.Activo = Window;
    	
    }

    public void CrearBoton(int x, int y, String Contenido, Color color, DrawAtom Elemento) {

		JButton Boton = new JButton(Contenido);
		
		Boton.setBounds(x, y, 55, 55);
        Boton.setBackground(color);
        Boton.setFont(new Font("Courier", Font.PLAIN, 12));
		Boton.addActionListener(this);
		Boton.setFocusPainted(false);
		this.Activo.add(Boton);

	}

	public void actionPerformed(ActionEvent e) {

		JButton Actual = (JButton) e.getSource();

		File archivo = new File();
		ArrayList<Atom> Elementos = archivo.LeerArchivo("src\\xyz\\mvarsmeer\\moleculator\\Elements.txt");

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