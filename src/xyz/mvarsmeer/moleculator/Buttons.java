package xyz.mvarsmeer.moleculator;

import java.awt.Font;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.util.ArrayList;

public class Buttons implements ActionListener {
	
	ArrayList<DrawAtom> ListaDibujo;
	Windows Atomos = new Windows();
	Custom NewAtom = new Custom();
	
	public Buttons(ArrayList<DrawAtom> ListaDibujo) {
		
		this.ListaDibujo = ListaDibujo;
		
	}

	public void CrearBoton(Frame Window, int x, int y, String Contenido, String color) {

		JButton Boton = new JButton(Contenido);
		Boton.setBackground(Color.decode(color));
		Boton.setBounds(x-5, y, 165, 30);
		Boton.setFocusPainted(false);
		Boton.setFont(new Font("Arial", Font.BOLD, 12));
		Boton.addActionListener(this);
		
		Window.add(Boton);

	}

	public void actionPerformed(ActionEvent e) {
		
		JButton Actual = (JButton) e.getSource();

		if(Atomos.Active ) {

			Atomos.WindowActive.dispose();
			Atomos.Active = false;

		}

		if(NewAtom.Active) {

			NewAtom.WindowActive.dispose();
			NewAtom.Active = false;

		}
		
		if(Actual.getText() == "Custom"){

			NewAtom.CreateWindow(Actual.getText(),ListaDibujo);

		} else {

			Atomos.CreateWindow(Actual.getText(),Actual.getBackground(),ListaDibujo);

		}

	}

}
