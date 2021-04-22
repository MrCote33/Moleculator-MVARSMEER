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
		
		//this.Dibujar.add(this.Asignado);
		this.Activo.dispose();

	}
    
}