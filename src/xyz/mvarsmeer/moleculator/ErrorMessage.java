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
		
		FontReader SetFont = new FontReader();
		Font Fuente = SetFont.CreateFont("src\\xyz\\mvarsmeer\\moleculator\\JetBrainsMono-Bold.ttf", 12);

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
		Error.setFont(Fuente);
		Error.setBounds(20, 0, 250, 100);

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
		Acept.setFont(Fuente);
		Acept.setBounds(90, 85, 90, 30);

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
