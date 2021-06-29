package xyz.mvarsmeer.moleculator.windows;

import java.awt.Font;
import java.awt.Frame;
import java.util.ArrayList;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Canvas;

import xyz.mvarsmeer.moleculator.buttons.SettingsButtons;
import xyz.mvarsmeer.moleculator.readers.FontReader;
import xyz.mvarsmeer.moleculator.draw.DrawAtom;
import xyz.mvarsmeer.moleculator.draw.DrawLine;

public class Settings {

	public Boolean Active = false;
	public JFrame WindowActive;

	public void CreateWindow(Canvas PanelDibujo, Frame MainFrame, ArrayList<DrawAtom> Atomos, ArrayList<DrawLine> Enlaces) {
		
		FontReader Fuentes = new FontReader();
		Font Fuente = Fuentes.CreateFont("src\\xyz\\mvarsmeer\\moleculator\\resources\\JetBrainsMono-Bold.ttf", 14);
		
		SettingsButtons Boton = new SettingsButtons();

		JFrame Window = new JFrame("Configuracion");

		if(Active == false) {

			WindowActive = Window;
			Active = true;

		}
		
		Boton.SetCanvas(PanelDibujo,MainFrame);

		Window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Window.setSize(new Dimension(280, 274));
		Window.setLocationRelativeTo(null);
		Window.setIgnoreRepaint(false);
		Window.setResizable(false);
		Window.setLayout(null);

		JLabel Archivo = new JLabel("Archivo");
		Archivo.setFont(Fuente);
		Archivo.setBounds(30, 2, 100, 30);

		Boton.CrearBoton(Window, 30, 44, 100, 32, "Guardar", "#F1AE53");
		Boton.CrearBoton(Window, 30, 76, 100, 32, "Cargar", "#F1AE53");
		
		Boton.setLists(Atomos, Enlaces);

		JLabel Exportar = new JLabel("Modelo");
		Exportar.setFont(Fuente);
		Exportar.setBounds(30, 118, 100, 30);

		Boton.CrearBoton(Window, 30, 150, 200, 32, "Exportar a PNG", "#8AB3FF");
		Boton.CrearBoton(Window, 30, 182, 200, 32, "Exportar a PDF", "#8AB3FF");

		Window.add(Archivo);
		Window.add(Exportar);
		Window.setVisible(true);

	}

}
