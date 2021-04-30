package xyz.mvarsmeer.moleculator;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.util.ArrayList;

public class Custom {

    Boolean Active = false;
	JFrame WindowActive;
	ArrayList<DrawAtom> Dibujar;

	public void CreateWindow(String Seccion, ArrayList<DrawAtom> Dibujar) {
		
		Font Fuente = new Font("Courier", Font.PLAIN, 12);
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
		Texto.setFont(Fuente);
		Texto.setBounds(128, 40, 220, 20);

		JTextField Rellenar = new JTextField();
		Rellenar.setFont(Fuente);
		Rellenar.setBounds(128, 60, 220, 20);

		JLabel Texto2 = new JLabel("Numero de enlaces", JLabel.CENTER);
		Texto2.setFont(Fuente);
		Texto2.setBounds(128, 110, 220, 20);
		
		JTextField Rellenar2 = new JTextField();
		Rellenar2.setFont(Fuente);
		Rellenar2.setBounds(210, 130, 60, 20);

		JLabel Texto3 = new JLabel("Diminutivo del elemento", JLabel.CENTER);
		Texto3.setFont(Fuente);
		Texto3.setBounds(128, 180, 220, 20);

		JTextField Rellenar3 = new JTextField();
		Rellenar3.setFont(Fuente);
		Rellenar3.setBounds(210, 200, 60, 20);

		JButton Boton = new JButton("Create a new Atom");
		Boton.setFont(Fuente);
		Boton.setBackground(Color.decode("#E9E4E3"));
		Boton.setBounds(140, 260, 200, 30);
		Boton.setFocusPainted(false);

		Window.add(Texto);
		Window.add(Rellenar);
		Window.add(Texto2);
		Window.add(Rellenar2);
		Window.add(Texto3);
		Window.add(Rellenar3);
		Window.add(Boton);
		
		Window.setVisible(true);
		
		Boton.addActionListener(new ActionListener() {

		    public void actionPerformed(ActionEvent e) {

		    	if(Rellenar.getText().length() > 0) {

		    		if(Rellenar2.getText().matches("[0-9]+")) {

		    			if(Rellenar3.getText().length() > 0 && Rellenar3.getText().length() <= 2) {

		    				Atom Atomo = new Atom("Custom", Rellenar.getText(), Rellenar3.getText(), Integer.parseInt(Rellenar2.getText()));
							DrawAtom Dibujo = new DrawAtom(15,15, Color.decode("#E9E4E3"), Atomo);
							Dibujar.add(Dibujo);

							Active = false;
							WindowActive.dispose();

		    			}

		    		}

		    	}

		    	Rellenar.setText("");
	    		Rellenar2.setText("");
	    		Rellenar3.setText("");

		    }

		});

    }

}
