package xyz.mvarsmeer.moleculator;

import java.awt.Font;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ErrorMessage {

    Boolean Active = false;
	JFrame WindowActive;

	public void NewMessage(String Area){

		JFrame Window = new JFrame("Error");
		Window.setSize(new Dimension(300, 190));
		Window.setLocationRelativeTo(null);
		Window.setIgnoreRepaint(false);
		Window.setResizable(false);
		Window.setLayout(null);
		Window.setVisible(true);

		if(Active == false) {

			WindowActive = Window;
			Active = true;

		}

		JLabel Error = new JLabel("No se puede realizar la accion", JLabel.CENTER);
		Error.setFont(new Font("Arial", Font.BOLD, 12));
		Error.setBounds(40, 0, 200, 100);

		if(Area == "Magnify"){

			Error.setText("Ya llego al tamaño maximo");

		}

		if(Area == "Minimaze"){

			Error.setText("Ya llego al tamaño minimo");

		}

		if(Area == "Link Atom"){

			Error.setText("El atomo no tiene enlaces libres");

		}
		
		JButton Acept = new JButton("Aceptar");
		Acept.setFont(new Font("Arial", Font.BOLD, 12));
		Acept.setBounds(100, 85, 80, 30);

		Acept.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e){

				Active = false;
				WindowActive.dispose();

			}

		});

		Window.add(Error);
		Window.add(Acept);

	}

}
