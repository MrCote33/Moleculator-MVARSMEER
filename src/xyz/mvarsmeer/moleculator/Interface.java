package xyz.mvarsmeer.moleculator;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
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
		Equipo.setBounds(735, 445, 100, 20);
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
		
		Canvas DrawingZone = new Canvas();
		MouseButtons Click = new MouseButtons(Boton.Dibujar, DrawingZone);
		
		DrawingZone.setBounds(225, 60, 586, 380);
		DrawingZone.addMouseListener(Click);
		DrawingZone.setBackground(Color.decode("#0F0F0F"));
		Window.add(DrawingZone);
		
		Window.setVisible(true);
		
		DrawingZone.createBufferStrategy(2);
		BufferStrategy Buffer = DrawingZone.getBufferStrategy();
		Graphics Drawing = Buffer.getDrawGraphics();
		
		while(true) {
			
			try {

				Thread.sleep(10);

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
					
					Actual.repaint(Drawing);
					
					for(int cont2 = 0; cont2 < Boton.Dibujar.size(); cont2++) {
						
						DrawAtom Repintar = Boton.Dibujar.get(cont2);
						Repintar.paint(Drawing);
						
					}
					
					Actual.Repaint = false;
					
					Buffer.show();
					
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
		
		Canvas DrawingZone;
		ArrayList<DrawAtom> ListaElemento;
		DrawAtom Elemento;
		
		public MouseButtons(ArrayList<DrawAtom> ListaElemento, Canvas DrawingZone) {
			
			this.ListaElemento = ListaElemento;
			this.DrawingZone = DrawingZone;
			
		}
		
		public void updateActive(DrawAtom Elemento) {
			
			this.Elemento = Elemento;

		}
		
		public void mouseClicked(MouseEvent event) {
			
			if(event.getButton() == MouseEvent.BUTTON1) {

				Elemento.Active = false;

			}
			
			if(event.getButton() == MouseEvent.BUTTON3) {

				for(int i = 0; i < ListaElemento.size(); i++) {
					
					int x = ListaElemento.get(i).x;
					int y = ListaElemento.get(i).y;
					
					if(event.getX() >= x+7 && event.getX() <= x+35) {
						
						if(event.getY() >= y+7 && event.getY() <= y+35) {
							
							this.Elemento = ListaElemento.get(i);
							Menu.Pop(ListaElemento, i, DrawingZone, event);
							
						}
						
					}
					
				}
				
			}
			
		}
		
	}
	
}
