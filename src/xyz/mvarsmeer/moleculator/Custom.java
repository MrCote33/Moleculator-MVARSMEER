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
		
		Font Fuente1 = new Font("Arial", Font.BOLD, 12);
		Font Fuente2 = new Font("Courier", Font.PLAIN, 12);
		JFrame Window = new JFrame(Seccion);
		SelectColor ColorSeleccionado = new SelectColor(Color.decode("#E9E4E3"));

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
		Texto.setFont(Fuente1);
		Texto.setBounds(128, 20, 220, 20);

		JTextField Rellenar = new JTextField();
		Rellenar.setFont(Fuente2);
		Rellenar.setBounds(128, 40, 220, 20);

		JLabel Texto2 = new JLabel("Numero de enlaces", JLabel.CENTER);
		Texto2.setFont(Fuente1);
		Texto2.setBounds(128, 80, 220, 20);
		
		JTextField Rellenar2 = new JTextField();
		Rellenar2.setFont(Fuente2);
		Rellenar2.setBounds(210, 100, 60, 20);

		JLabel Texto3 = new JLabel("Diminutivo del elemento", JLabel.CENTER);
		Texto3.setFont(Fuente1);
		Texto3.setBounds(128, 140, 220, 20);

		JTextField Rellenar3 = new JTextField();
		Rellenar3.setFont(Fuente2);
		Rellenar3.setBounds(210, 160, 60, 20);

		JButton Colores = new JButton("Seleccione un color");
		Colores.setFont(Fuente1);
		Colores.setBackground(ColorSeleccionado.getColor());
		Colores.setBounds(165, 200, 150, 30);
		Colores.setFocusPainted(false);
		Colores.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
				ColorSeleccionado.NewColor();
				Colores.setText("Color seleccionado");
				Colores.setBackground(ColorSeleccionado.getColor());
				Colores.repaint();
				Window.repaint();
				
			}
			
		});

		JButton Boton = new JButton("Create a new Atom");
		Boton.setFont(Fuente1);
		Boton.setBackground(Color.decode("#E9E4E3"));
		Boton.setBounds(140, 260, 200, 30);
		Boton.setFocusPainted(false);
		Boton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if(Rellenar.getText().length() > 0) {

					if(Rellenar2.getText().matches("[0-9]+")) {

						if(Rellenar3.getText().length() > 0 && Rellenar3.getText().length() <= 2) {

							Atom Atomo = new Atom("Custom", Rellenar.getText(), Rellenar3.getText(), Integer.parseInt(Rellenar2.getText()));
							DrawAtom Dibujo = new DrawAtom(15, 15, 60, ColorSeleccionado.getColor(), Atomo);
							Dibujar.add(Dibujo);
							Active = false;
							WindowActive.dispose();

						}else{

							Rellenar3.setText("Error");

						}

					}else{

						Rellenar2.setText("Error");
						

					}

				}else{

					Rellenar.setText("Error");

				}

			}

		});	

		Window.add(Texto);
		Window.add(Rellenar);
		Window.add(Texto2);
		Window.add(Rellenar2);
		Window.add(Texto3);
		Window.add(Rellenar3);
		Window.add(Boton);
		Window.add(Colores);
		Window.setVisible(true);
		
	}

}
