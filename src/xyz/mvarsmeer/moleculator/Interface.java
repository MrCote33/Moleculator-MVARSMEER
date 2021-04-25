package xyz.mvarsmeer.moleculator;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JLabel;

public class Interface {

	public void initInterface() {

		Frame Window = new Frame("Moleculator");
		Window.addWindowListener(new WindowListener());
		Window.setSize(new Dimension(854, 480));
		Window.setLocationRelativeTo(null);
		Window.setResizable(false);
		Window.setLayout(null);

		JLabel Equipo = new JLabel("MVARSMEER");
		Equipo.setBounds(730, 450, 100, 20);
		Equipo.setForeground(Color.BLACK);
		Window.add(Equipo);
		
		Buttons Boton = new Buttons();
		Boton.CrearBoton(Window, 35, 82, "Metales alcainos", "#FFC8B0");
		Boton.CrearBoton(Window, 35, 112, "Alcalinoterreos", "#FFE6CC");
		Boton.CrearBoton(Window, 35, 142, "Otros metales", "#FFF2CC");
		Boton.CrearBoton(Window, 35, 172, "Metales de transicion", "#D0E882");
		Boton.CrearBoton(Window, 35, 202, "Lantanidos", "#D1E8A2");
		Boton.CrearBoton(Window, 35, 232, "Actinidos", "#B8E8B3");
		Boton.CrearBoton(Window, 35, 262, "Metaloides", "#D5E8D4");
		Boton.CrearBoton(Window, 35, 292, "No metales", "#E1D5E7");
		Boton.CrearBoton(Window, 35, 322, "Halogenos", "#D8A4DE");
		Boton.CrearBoton(Window, 35, 352, "Gases nobles", "#DAE8FC");
		Boton.CrearBoton(Window, 35, 382, "Custom", "#E9E4E3");
		
		MouseButtons Click = new MouseButtons();
		
		Canvas DrawingZone = new Canvas();
		DrawingZone.setBounds(225, 60, 586, 380);
		DrawingZone.addMouseListener(Click);
		DrawingZone.setBackground(Color.decode("#0F0F0F"));
		Window.add(DrawingZone);

		Window.setVisible(true);
		
		while(true) {
			
			try {

				Thread.sleep(17);

			} catch (InterruptedException e) {

				e.printStackTrace();

			}
			
			Point location = DrawingZone.getMousePosition();

			for(int cont1 = 0; cont1 < Boton.Dibujar.size(); cont1++ ) {
				
				DrawAtom Actual = Boton.Dibujar.get(cont1);
				
				if(Actual.Active) {
					
					Click.updateActive(Actual);
					
					if(location != null) {
						
						Actual.x = location.x;
						Actual.y = location.y;
						
					}
					
					Actual.Repaint = true;
					
				}
				
				if(Actual.Repaint) {
					
					Actual.repaint(DrawingZone.getGraphics());
					
					for(int cont2 = 0; cont2 < Boton.Dibujar.size(); cont2++) {
						
						DrawAtom Repintar = Boton.Dibujar.get(cont2);
						Repintar.paint(DrawingZone.getGraphics());
						
					}
					
					Actual.Repaint = false;
					
				}
				
			}
			
		}

	}
	
	static class WindowListener extends WindowAdapter {

		public void windowClosing(WindowEvent e) {

			System.exit(0);

		}

	}
	
	static class MouseButtons extends MouseAdapter {
		
		DrawAtom Elemento;
		
		public void updateActive(DrawAtom Elemento) {

			this.Elemento = Elemento;

		}
		
		public void mouseClicked(MouseEvent event) {
			
			if(event.getButton() == MouseEvent.BUTTON1) {

				Elemento.Active = false;

			}
			
			if(event.getButton() == MouseEvent.BUTTON3) {

				Menu.Pop(Elemento, Elemento.Paint, event);
				
			}
			
		}
		
	}
	
}
