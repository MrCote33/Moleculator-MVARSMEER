package xyz.mvarsmeer.moleculator.buttons;

import java.awt.Font;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import java.awt.Canvas;
import javax.swing.JButton;
import java.util.ArrayList;
import java.util.Arrays;

import xyz.mvarsmeer.moleculator.draw.DrawAtom;
import xyz.mvarsmeer.moleculator.readers.FontReader;
import xyz.mvarsmeer.moleculator.windows.Custom;
import xyz.mvarsmeer.moleculator.windows.Windows;
import xyz.mvarsmeer.moleculator.windows.Settings;

public class InterfaceButtons implements ActionListener {
	
	ArrayList<DrawAtom> ListaDibujo;
	Windows Atomos = new Windows();
	Custom NewAtom = new Custom(null);
	Settings Config = new Settings();
	Font Fuente;
	Canvas PanelDibujo;
	Frame MainFrame;
	String[] Categorias ={"Metales alcainos","Alcalinoterreos","Otros metales","Metales de transicion",
						  "Lantanidos","Actinidos","Metaloides","No metales","Halogenos","Gases nobles"};

	public InterfaceButtons(ArrayList<DrawAtom> ListaDibujo) {

		this.ListaDibujo = ListaDibujo;

	}

	public void CrearBoton(Frame Window, int x, int y, String Contenido, String color) {

		FontReader SetFont = new FontReader();
		Font Fuente = SetFont.CreateFont("src\\xyz\\mvarsmeer\\moleculator\\resources\\JetBrainsMono-Bold.ttf", 10);

		JButton Boton = new JButton(Contenido);
		Boton.setBackground(Color.decode(color));
		Boton.setBounds(x, y, 170, 30);
		Boton.setFocusPainted(false);
		Boton.setFont(Fuente);
		Boton.addActionListener(this);

		Window.add(Boton);

	}

	public void CrearIcono(Frame Window, Canvas Panel, int x, int y,int Ancho, int Alto, Icon Path,String texto, String color){

		JButton Boton = new JButton(Path);
		Boton.setText(texto);
		Boton.setBackground(Color.decode(color));
		Boton.setBounds(x, y, Ancho, Alto);
		Boton.setFocusPainted(false);
		Boton.addActionListener(this);

		PanelDibujo = Panel;
		MainFrame = Window;

		Window.add(Boton);

	}

	public void CrearFormula(Panel Zone, int x, int y, String Formula, Color color) {

		FontReader SetFont = new FontReader();
		Font Fuente = SetFont.CreateFont("src\\xyz\\mvarsmeer\\moleculator\\resources\\JetBrainsMono-Bold.ttf", 10);

		JButton Boton = new JButton(Formula);
		Boton.setBackground(color);
		Boton.setForeground(Color.BLACK);
		Boton.setBounds(x, y, 186, 30);
		Boton.setFocusPainted(false);
		Boton.setFont(Fuente);

		Zone.add(Boton);

	}

	public void actionPerformed(ActionEvent e) {
		
		JButton Actual = (JButton) e.getSource();

		if(Atomos.Active) {

			Atomos.WindowActive.dispose();
			Atomos.Active = false;

		}

		if(NewAtom.Active) {

			NewAtom.WindowActive.dispose();
			NewAtom.Active = false;

		}

		if(Arrays.asList(Categorias).contains(Actual.getText())){

			Atomos.CreateWindow(Actual,Actual.getText(),Actual.getBackground(),ListaDibujo);

		}

		if(Actual.getText() == "Configuracion"){

			Config.CreateWindow(PanelDibujo,MainFrame);

		}

		if(Actual.getText() == "Custom"){

			NewAtom.CreateWindow(Actual.getText(),ListaDibujo);

		}

	}

}
