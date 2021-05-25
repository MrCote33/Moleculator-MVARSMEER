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
	
	DrawAtom Elemento;
	String Nombre;
	String Simbolo;
	Color color;
	int Enl;

	Boolean Active = false;
	JFrame WindowActive;
	ArrayList<DrawAtom> Dibujar;

	public Custom(DrawAtom Elemento){
		
		this.Elemento = Elemento; 

		if(Elemento != null) {
			
			this.Nombre = Elemento.Atomo.getNombre();
			this.Simbolo = Elemento.Atomo.getSimbolo();
			this.color = Elemento.Paint;
			this.Enl = Elemento.Atomo.getTotalEnl();
			
		} else {
			
			this.Nombre = "";
			this.Simbolo = "";
			this.color = Color.decode("#E9E4E3");
			this.Enl = 0;
			
		}

	}

	public void CreateWindow(String Seccion, ArrayList<DrawAtom> Dibujar) {
		
		FontReader Fuente = new FontReader();

		Font Fuente1 = Fuente.CreateFont("src\\xyz\\mvarsmeer\\moleculator\\JetBrainsMono-Bold.ttf", 11);
		Font Fuente2 = Fuente.CreateFont("src\\xyz\\mvarsmeer\\moleculator\\ParadroidMono-Light.ttf", 12);

		JFrame Window = new JFrame(Seccion);
		SelectColor ColorSeleccionado = new SelectColor(color);

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

		JTextField Rellenar = new JTextField(Nombre);
		Rellenar.setFont(Fuente2);
		Rellenar.setBounds(128, 40, 220, 20);

		JLabel Texto2 = new JLabel("Numero de enlaces", JLabel.CENTER);
		Texto2.setFont(Fuente1);
		Texto2.setBounds(128, 80, 220, 20);
		
		JTextField Rellenar2 = new JTextField(Enl);
		Rellenar2.setText(String.valueOf(Enl));
		Rellenar2.setFont(Fuente2);
		Rellenar2.setBounds(210, 100, 60, 20);

		JLabel Texto3 = new JLabel("Diminutivo del elemento", JLabel.CENTER);
		Texto3.setFont(Fuente1);
		Texto3.setBounds(128, 140, 220, 20);

		JTextField Rellenar3 = new JTextField(Simbolo);
		Rellenar3.setFont(Fuente2);
		Rellenar3.setBounds(210, 160, 60, 20);

		JButton Colores = new JButton("Seleccione un color");
		Colores.setFont(Fuente1);
		Colores.setBackground(ColorSeleccionado.getColor());
		Colores.setBounds(162, 200, 157, 30);
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

							if(Nombre.length() == 0) {
								
								Atom Atomo = new Atom("Custom", Rellenar.getText(), Rellenar3.getText(), Integer.parseInt(Rellenar2.getText()));
								DrawAtom Dibujo = new DrawAtom(15, 15, 60, ColorSeleccionado.getColor(), Atomo);
								Dibujar.add(Dibujo);
								Active = false;
								WindowActive.dispose();
								
							} else {
								
								if(Elemento.Enlaces == Elemento.Atomo.getTotalEnl()) {
									
									Elemento.Atomo = new Atom("Custom", Rellenar.getText(), Rellenar3.getText(), Integer.parseInt(Rellenar2.getText()));
									Elemento.Enlaces = Elemento.Atomo.getTotalEnl();
									Elemento.Repaint = true;
									Active = false;
									WindowActive.dispose();
									
								} else {
									
									if(Integer.parseInt(Rellenar2.getText()) >= (Elemento.Atomo.getTotalEnl()-Elemento.Enlaces)) {
										
										Elemento.Atomo = new Atom("Custom", Rellenar.getText(), Rellenar3.getText(), Integer.parseInt(Rellenar2.getText()));
										Elemento.Enlaces = Elemento.Atomo.getEnlaces() - Elemento.Enlaces;
										Elemento.Repaint = true;
										Active = false;
										WindowActive.dispose();
										
									} else {
										
										Rellenar2.setText("Error");
										
									}
									
								}
								
							}

						} else {

							Rellenar3.setText("Error");

						}

					} else {

						Rellenar2.setText("Error");
						

					}

				} else {

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
