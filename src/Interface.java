import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Interface {

	public void CreateWindow() {

		JFrame Window = new JFrame("Moleculator");
		Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Window.setSize(new Dimension(854, 480));
		Window.setLocationRelativeTo(null);
		Window.setVisible(true);
		Window.setLayout(null);

		JLabel Equipo = new JLabel("MVARSMEER", JLabel.CENTER);
		Equipo.setSize(80, 15);
		Equipo.setLocation(2, 2);

		Window.add(Equipo);
		DrawAtom Atom = new DrawAtom();

		Buttons Boton = new Buttons();
		Boton.CrearBoton(Window, 30, 30, "Alcalinos", "x");
		Boton.CrearBoton(Window, 30, 60, "Terreos", "x");
		Boton.CrearBoton(Window, 30, 90, "Otros Metales", "x");
		Boton.CrearBoton(Window, 30, 120, "Metales de transicion", "x");
		Boton.CrearBoton(Window, 30, 150, "Lantanidos", "x");
		Boton.CrearBoton(Window, 30, 180, "Actinidos", "x");
		Boton.CrearBoton(Window, 30, 210, "Metaloides", "x");
		Boton.CrearBoton(Window, 30, 240, "No Metales", "x");
		Boton.CrearBoton(Window, 30, 270, "Halogenos", "x");
		Boton.CrearBoton(Window, 30, 300, "Gases Nobles", "x");

		while (Window.isActive()) {

			Window.repaint();
			Point location = Window.getMousePosition();
			Atom.paint(Window.getGraphics(), location);

		}

	}

}
