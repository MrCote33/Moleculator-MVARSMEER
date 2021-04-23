package xyz.mvarsmeer.moleculator;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Interface {

	public void initInterface() {

		Frame Window = new Frame("Moleculator");
		Window.addWindowListener(new WindowListener());
		Window.setSize(new Dimension(854, 480));
		Window.setLocationRelativeTo(null);
		Window.setResizable(false);
		Window.setLayout(null);
		
		Buttons Boton = new Buttons();
		Boton.CrearBoton(Window, 35, 60, "Metales alcainos", "#FFC8B0");
		Boton.CrearBoton(Window, 35, 90, "Alcalinoterreos", "#FFE6CC");
		Boton.CrearBoton(Window, 35, 120, "Otros metales", "#FFF2CC");
		Boton.CrearBoton(Window, 35, 150, "Metales de transicion", "#D0E882");
		Boton.CrearBoton(Window, 35, 180, "Lantanidos", "#D1E8A2");
		Boton.CrearBoton(Window, 35, 210, "Actinidos", "#B8E8B3");
		Boton.CrearBoton(Window, 35, 240, "Metaloides", "#D5E8D4");
		Boton.CrearBoton(Window, 35, 270, "No metales", "#E1D5E7");
		Boton.CrearBoton(Window, 35, 300, "Halogenos", "#D8A4DE");
		Boton.CrearBoton(Window, 35, 330, "Gases nobles", "#DAE8FC");
		Boton.CrearBoton(Window, 35, 360, "Custom", "#E9E4E3");

		Canvas DrawingZone = new Canvas();
		DrawingZone.setBounds(225, 60, 586, 380);
		DrawingZone.setBackground(Color.decode("#0F0F0F"));
		Window.add(DrawingZone);

		Window.setVisible(true);
		
		while(true) {
			
			try {

				Thread.sleep(17);

			} catch (InterruptedException e) {

				e.printStackTrace();

			}

			for(int cont = 0; cont < Boton.Dibujar.size(); cont++ ) {
				
				DrawAtom Actual = Boton.Dibujar.get(cont);
				Actual.paint(DrawingZone.getGraphics());
				
			}
			
		}

	}
	
	static class WindowListener extends WindowAdapter {

		public void windowClosing(WindowEvent e) {

			System.exit(0);

		}

	}

}
