package xyz.mvarsmeer.moleculator;

import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectColor {

	Color color;

	public SelectColor(Color Base){

		this.color = Base;

	}

	public void setColor(Color color) {

		this.color = color;

	}

	public Color getColor(){

		return this.color;
		
	}

	public void NewColor() {

		JFrame Window = new JFrame("Seleccione un color");
		Window.setSize(new Dimension(510, 360));
		Window.setLocationRelativeTo(null);
		Window.setIgnoreRepaint(false);
		Window.setResizable(false);
		Window.setLayout(null);
		Window.setVisible(true);

		JColorChooser Options = new JColorChooser();
		Options.setSize(510, 240);

		JButton Select = new JButton("Seleccionar color");
		Select.setFont(new Font("Courier", Font.PLAIN, 11));
		Select.setBounds(155, 250, 200, 40);

		Select.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e){

				Color Seleccionado = Options.getColor();
				setColor(Seleccionado);

			}

		});

		Window.add(Options);
		Window.add(Select);
	}

}
