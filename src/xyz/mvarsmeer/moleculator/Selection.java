package xyz.mvarsmeer.moleculator;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Selection implements ActionListener  {

    Windows Atomos = new Windows();

    public void CrearBoton(JFrame Window, int x, int y, String Contenido, Color color) {

		JButton Boton = new JButton(Contenido);
		Boton.setBounds(x, y, 55, 55);
        Boton.setBackground(color);
        Boton.setFont(new Font("Courier", Font.PLAIN, 12));
		Boton.addActionListener(this);
		Boton.setFocusPainted(false);
		Window.add(Boton);

	}

	public void actionPerformed(ActionEvent e) {
		
		JButton Actual = (JButton) e.getSource();
		
        System.out.println(Actual);

	}
    
}