package xyz.mvarsmeer.moleculator;

import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
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

		JLabel Texto = new JLabel("Nombre del nuevo elemento", JLabel.CENTER);
		Texto.setFont(new Font("Courier", Font.PLAIN, 12));
		Texto.setBounds(128, 20, 220, 20);

		JTextField Rellenar= new JTextField();
		Rellenar.setFont(new Font("Courier", Font.PLAIN, 12));
		Rellenar.setBounds(128, 40, 220, 20);

		JLabel Texto2 = new JLabel("Numero de enlaces", JLabel.CENTER);
		Texto2.setFont(new Font("Courier", Font.PLAIN, 12));
		Texto2.setBounds(128, 80, 220, 20);

		JLabel Texto3 = new JLabel("Diminutivo del elemento", JLabel.CENTER);
		Texto3.setFont(new Font("Courier", Font.PLAIN, 12));
		Texto3.setBounds(128, 160, 220, 20);

		JTextField Rellenar2 = new JTextField();
		Rellenar2.setFont(new Font("Courier", Font.PLAIN, 12));
		Rellenar2.setBounds(185, 180, 110, 20);

		JButton Boton = new JButton("Create a new Atom");
		Boton.setFont(new Font("Courier", Font.PLAIN, 12));
		Boton.setBackground(Color.decode("#E9E4E3"));
		Boton.setBounds(165, 260, 150, 30);
		Boton.setFocusPainted(false);

		Window.add(Texto);
		Window.add(Rellenar);
		Window.add(Texto2);
		//Window.add(Opciones);
		Window.add(Texto3);
		Window.add(Rellenar2);
		Window.add(Boton);
		Window.setVisible(true);

    }

}

