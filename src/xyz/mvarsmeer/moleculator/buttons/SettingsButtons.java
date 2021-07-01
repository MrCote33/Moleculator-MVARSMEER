package xyz.mvarsmeer.moleculator.buttons;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Color;
import java.awt.AWTException;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import xyz.mvarsmeer.moleculator.readers.FontReader;
import xyz.mvarsmeer.moleculator.windows.Settings;
import xyz.mvarsmeer.moleculator.addons.ArchiveOptions;
import xyz.mvarsmeer.moleculator.addons.ExportOptions;
import xyz.mvarsmeer.moleculator.draw.DrawAtom;
import xyz.mvarsmeer.moleculator.draw.DrawLine;

public class SettingsButtons implements ActionListener {
	
	Settings Config = new Settings();
	ArrayList<DrawAtom> ListaElemento;
	ArrayList<DrawLine> ListaLineas;
	Canvas PanelDibujo;
	Frame MainFrame;
	Font Fuente;

	public void SetCanvas(Canvas PanelDibujo, Frame MainFrame) {

		this.PanelDibujo = PanelDibujo;
		this.MainFrame = MainFrame;
	
	}
	
	public void setLists(ArrayList<DrawAtom> ListaElemento, ArrayList<DrawLine> ListaLineas) {
		
		this.ListaElemento = ListaElemento;
		this.ListaLineas = ListaLineas;
		
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
		ArchiveOptions archive = new ArchiveOptions(ListaElemento, ListaLineas);
		JButton Actual = (JButton) e.getSource();

		if(Actual.getText() == "Guardar"){
			archive.GuardarCanvas();
		}

		if(Actual.getText() == "Cargar"){
			archive.CargarCanvas();
		}

		if(Actual.getText() == "Exportar a PNG"){

			try {

				export.GuardadoPNG(PanelDibujo,MainFrame);

			} catch (AWTException e1) {

				e1.printStackTrace();

			}

		}

		if(Actual.getText() == "Exportar a PDF"){

			try {

				export.GuardadoPDF(PanelDibujo,MainFrame);

			} catch (AWTException e1) {

				e1.printStackTrace();

			}

		}

	}

}