package xyz.mvarsmeer.moleculator.addons;

import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectColor {

	Color color;
	Boolean Active = false;
	JFrame WindowActive;

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
		Window.setSize(new Dimension(624, 390));
		Window.setLocationRelativeTo(null);
		Window.setIgnoreRepaint(false);
		Window.setResizable(false);
		Window.setLayout(null);
		Window.setVisible(true);

		if(Active == false) {

			WindowActive = Window;
			Active = true;

		}

		JColorChooser Options = new JColorChooser();
		AbstractColorChooserPanel[] panels = Options.getChooserPanels();
		
		for (AbstractColorChooserPanel Nombre : panels) {
			if(!Nombre.getDisplayName().equals("RGB")) {

			   Options.removeChooserPanel(Nombre);
			   
			} 
		}

		Options.setPreviewPanel(new JPanel());
		Options.setSize(610, 310);
		

		JButton Select = new JButton("Seleccionar color");
		Select.setFont(new Font("Arial", Font.BOLD, 12));
		Select.setBounds(205, 310, 200, 40);
		Select.setBackground(Color.WHITE);

		Select.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e){

				Color Seleccionado = Options.getColor();
				setColor(Seleccionado);
				Active = false;
				WindowActive.dispose();

			}

		});

		Window.add(Options);
		Window.add(Select);

	}

}
