package xyz.mvarsmeer.moleculator;

import java.awt.Font;
import java.awt.Color;
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
		Window.setSize(new Dimension(400, 200));
		Window.setLocationRelativeTo(null);
		Window.setIgnoreRepaint(false);
		Window.setResizable(false);
		Window.setLayout(null);
		Window.setVisible(true);

		if(Active == false) {

			WindowActive = Window;
			Active = true;

		}

		JLabel Error = new JLabel("the action cannot be executed", JLabel.CENTER);
		Error.setFont(Fuente);
		Error.setBounds(20, 0, 350, 100);

		if(Area == "Magnify"){

			Error.setText("It has already reached the maximum size");

		}

		if(Area == "Minimaze"){

			Error.setText("It has already reached the minimum size");

		}

		if(Area == "Link Atom"){

			Error.setText("The atom has no free bonds");

		}
		
		JButton Acept = new JButton("Acept");
		Acept.setFont(Fuente);
		Acept.setFocusPainted(false);
		Acept.setBackground(Color.WHITE);
		Acept.setBounds(148, 85, 90, 30);

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
