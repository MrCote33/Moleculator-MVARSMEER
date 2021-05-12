package xyz.mvarsmeer.moleculator;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

public class Interface {

	public void initInterface() {
		
		ArrayList<DrawAtom> Atomos = new ArrayList<DrawAtom>();
		ArrayList<DrawLine> Enlaces = new ArrayList<DrawLine>();

		Frame Window = new Frame("Moleculator");
		Window.addWindowListener(new WindowListener());
		Window.setSize(854,480);
		Window.setMinimumSize(new Dimension(854,480));
		Window.setLocationRelativeTo(null);
		Window.setLayout(null);
		
		Label Equipo = new Label("MVARSMEER");
		Equipo.setBounds(80, 60, 100, 20);
		Equipo.setForeground(Color.BLACK);
		Window.add(Equipo);
		
		Buttons Boton = new Buttons(Atomos);
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
		MouseButtons Click = new MouseButtons(Atomos, Enlaces, DrawingZone);
		
		DrawingZone.setBounds(225, 60, 586, 380);
		DrawingZone.addMouseListener(Click);
		DrawingZone.setBackground(Color.decode("#0F0F0F"));
		Window.add(DrawingZone);
		
		Window.setVisible(true);
		
		DrawingZone.createBufferStrategy(2);
		BufferStrategy Buffer = DrawingZone.getBufferStrategy();
		Graphics Drawing = Buffer.getDrawGraphics();
		
		int WindowsX = Window.getBounds().width;
		int WindowsY = Window.getBounds().height;
		
		while(true) {
			
			try {

				Thread.sleep(10);

			} catch (InterruptedException e) {

				e.printStackTrace();

			}
			
			if(WindowsX != Window.getBounds().width || WindowsY != Window.getBounds().height) {
				
				WindowsX = Window.getBounds().width;
				WindowsY = Window.getBounds().height;
				DrawingZone.setBounds(225,60,WindowsX-268,WindowsY-100);
				Buffer = DrawingZone.getBufferStrategy();
				Drawing = Buffer.getDrawGraphics();
				
			}

			for(int cont1 = 0; cont1 < Atomos.size(); cont1++ ) {
				
				DrawAtom Actual = Atomos.get(cont1);
				
				if(Actual.Repaint) {
					
					Actual.repaint(Drawing);
					
					for(int cont2 = 0; cont2 < Enlaces.size(); cont2++) {
						
						DrawLine Repintar = Enlaces.get(cont2);
						Repintar.paint(Drawing);
						
					}
					
					for(int cont2 = 0; cont2 < Atomos.size(); cont2++) {
						
						DrawAtom Repintar = Atomos.get(cont2);
						Repintar.paint(Drawing);
						
					}
					
					Actual.Repaint = false;
					
					Buffer.show();
					
				}
				
				if(Actual.Active) {
					
					Click.updateActive(Actual);
					Point location = DrawingZone.getMousePosition();
					
					if(location != null) {
						
						Actual.x = location.x;
						Actual.y = location.y;
						
					}
					
					Actual.Repaint = true;
					
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
		
		ArrayList<DrawAtom> ListaElemento;
		ArrayList<DrawLine> ListaLineas;
		Canvas DrawingZone;
		DrawAtom Elemento;
		Menu Desplegar;
		
		public MouseButtons(ArrayList<DrawAtom> ListaElemento, ArrayList<DrawLine> ListaLineas, Canvas DrawingZone) {
			
			this.ListaElemento = ListaElemento;
			this.ListaLineas = ListaLineas;
			this.DrawingZone = DrawingZone;
			this.Desplegar = new Menu(ListaLineas);
			
		}
		
		public void updateActive(DrawAtom Elemento) {
			
			this.Elemento = Elemento;

		}
		
		public void mouseClicked(MouseEvent event) {
			
			if(event.getButton() == MouseEvent.BUTTON1) {

				if(this.Elemento != null) {
					Elemento.Active = false;
				}

			}
			
			if(event.getButton() == MouseEvent.BUTTON3) {

				for(int i = 0; i < ListaElemento.size(); i++) {
					
					int x = ListaElemento.get(i).x;
					int y = ListaElemento.get(i).y;
					
					if(event.getX() >= x+7 && event.getX() <= x+35) {
						
						if(event.getY() >= y+7 && event.getY() <= y+35) {
							
							this.Elemento = ListaElemento.get(i);
							Desplegar.Pop(ListaElemento, i, DrawingZone, event);
							
						}
						
					}
					
				}
				
			}
			
		}
		
	}
	
}
