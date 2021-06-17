package xyz.mvarsmeer.moleculator.buttons;

import java.awt.Font;
import java.awt.Color;
import java.awt.AWTException;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

import xyz.mvarsmeer.moleculator.readers.FontReader;
import xyz.mvarsmeer.moleculator.windows.Settings;
import xyz.mvarsmeer.moleculator.addons.ExportOptions;

public class SettingsButtons implements ActionListener {
	
	Settings Config = new Settings();
	Font Fuente;
	Canvas PanelDibujo;

	public void SetCanvas(Canvas PanelDibujo) {

		this.PanelDibujo=PanelDibujo;
	
	}

	public void CrearBoton(JFrame Window, int x, int y,int Ancho, int Alto, String Contenido, String color) {

		FontReader SetFont = new FontReader();
		Font Fuente = SetFont.CreateFont("src\\xyz\\mvarsmeer\\moleculator\\resources\\JetBrainsMono-Bold.ttf", 11);

		JButton Boton = new JButton(Contenido);
		Boton.setBackground(Color.decode(color));
		Boton.setBounds(x, y, Ancho, Alto);
		Boton.setFocusPainted(false);
		Boton.setFont(Fuente);
		Boton.addActionListener(this);
		
		Window.add(Boton);
		
	}

	public void actionPerformed(ActionEvent e) {

		ExportOptions export = new ExportOptions();

		JButton Actual = (JButton) e.getSource();

		if(Actual.getText() == "Guardar"){

			System.out.println("Aca va el guardar");

		}

		if(Actual.getText() == "Cargar"){

			System.out.println("Aca va el Cargar");

		}

		if(Actual.getText() == "Exportar a PNG"){

			try {

				export.GuardadoPNG(PanelDibujo);

			} catch (AWTException e1) {

				e1.printStackTrace();

			}

		}

		if(Actual.getText() == "Exportar a PDF"){

			try {

				export.GuardadoPDF(PanelDibujo);

			} catch (AWTException e1) {

				e1.printStackTrace();

			}

		}

	}

}