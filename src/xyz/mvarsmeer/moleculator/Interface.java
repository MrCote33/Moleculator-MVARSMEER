package xyz.mvarsmeer.moleculator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Interface {

	public void CreateWindow() {

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
		Boton.CrearBoton(Window, 30, 90, "Otros Metales", "#FFF2CC");
		Boton.CrearBoton(Window, 30, 120, "Metales de transicion", "#D0E882");
		Boton.CrearBoton(Window, 30, 150, "Lantanidos", "#D1E8A2");
		Boton.CrearBoton(Window, 30, 180, "Actinidos", "#B8E8B3");
		Boton.CrearBoton(Window, 30, 210, "Metaloides", "#D5E8D4");
		Boton.CrearBoton(Window, 30, 240, "No Metales", "#E1D5E7");
		Boton.CrearBoton(Window, 30, 270, "Halogenos", "#D8A4DE");
		Boton.CrearBoton(Window, 30, 300, "Gases Nobles", "#DAE8FC");
		Boton.CrearBoton(Window, 30, 330, "Custom", "#E9E4E3");

		JPanel DrawingZone = new JPanel();
		DrawingZone.setBounds(220, 30, 586, 380);
		DrawingZone.setBackground(Color.decode("#000000"));
		Window.add(DrawingZone);

		Window.setVisible(true);

		File archivo = new File();
		archivo.LeerArchivo("src\\xyz\\mvarsmeer\\moleculator\\Elements.txt");

		DrawAtom Circle = new DrawAtom();

		int x;
		int y;

		int AnteriorX = 0;
		int AnteriorY = 0;

		while (true) {

			Point ubicacion = DrawingZone.getMousePosition();

			if (ubicacion == null) {
				x = 5;
				y = 5;
			} else {
				x = ubicacion.x;
				y = ubicacion.y;
			}

			if (x != AnteriorX || y != AnteriorY) {

				Circle.paint(DrawingZone.getGraphics(), x, y);
				AnteriorX = x;
				AnteriorY = y;

			}

		}

	}

}
