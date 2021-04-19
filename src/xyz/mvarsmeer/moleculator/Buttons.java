package xyz.mvarsmeer.moleculator;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Buttons implements ActionListener {
	
	Windows Atomos = new Windows();

	public void CrearBoton(Frame Window, int x, int y, String Contenido, String color) {

		JButton Boton = new JButton(Contenido);
		Boton.setBackground(Color.decode(color));
		Boton.setBounds(x, y, 160, 30);
		Boton.addActionListener(this);
		Boton.setFocusPainted(false);
		Window.add(Boton);

	}

	public void actionPerformed(ActionEvent e) {
		
		JButton Actual = (JButton) e.getSource();
		
		if(Atomos.Active) {
			Atomos.WindowActive.dispose();
			Atomos.Active = false;
		}
		
		Atomos.CreateWindow(Actual.getText(), Actual.getBackground());

	}

}
