package xyz.mvarsmeer.moleculator;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Interface {

	public void initInterface() {

		JFrame Window = new JFrame("Moleculator");
		Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Window.setSize(new Dimension(854, 480));
		Window.setLocationRelativeTo(null);
		Window.setLayout(null);
		Window.setResizable(false);

		JLabel Equipo = new JLabel("MVARSMEER", JLabel.CENTER);
		Equipo.setBounds(750, 420, 80, 15);
		Window.add(Equipo);

		Buttons Boton = new Buttons();
		Boton.CrearBoton(Window, 30, 30, "Metales alcainos", "#FFC8B0");
		Boton.CrearBoton(Window, 30, 60, "Alcalinoterreos", "#FFE6CC");
		Boton.CrearBoton(Window, 30, 90, "Otros metales", "#FFF2CC");
		Boton.CrearBoton(Window, 30, 120, "Metales de transicion", "#D0E882");
		Boton.CrearBoton(Window, 30, 150, "Lantanidos", "#D1E8A2");
		Boton.CrearBoton(Window, 30, 180, "Actinidos", "#B8E8B3");
		Boton.CrearBoton(Window, 30, 210, "Metaloides", "#D5E8D4");
		Boton.CrearBoton(Window, 30, 240, "No metales", "#E1D5E7");
		Boton.CrearBoton(Window, 30, 270, "Halogenos", "#D8A4DE");
		Boton.CrearBoton(Window, 30, 300, "Gases nobles", "#DAE8FC");
		Boton.CrearBoton(Window, 30, 330, "Custom", "#E9E4E3");

		Canvas DrawingZone = new Canvas();
		DrawingZone.setBounds(220, 30, 586, 380);
		Window.add(DrawingZone);

		Window.setVisible(true);

	}

}
