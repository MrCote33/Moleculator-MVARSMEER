package xyz.mvarsmeer.moleculator;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.util.ArrayList;

public class Custom {

    Boolean Active = false;
	JFrame WindowActive;

	public void CreateWindow(String Seccion, ArrayList<DrawAtom> Dibujar) {
		
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

		JButton Boton = new JButton("Create a new Atom");
		Boton.setBackground(Color.decode("#000000"));
		Boton.setBounds(128, 490, 30, 130);
		Boton.setFocusPainted(false);
		
		Window.add(Boton);
		Window.setVisible(true);

    }

}

