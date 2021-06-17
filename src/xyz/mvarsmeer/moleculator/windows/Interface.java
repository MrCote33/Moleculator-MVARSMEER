package xyz.mvarsmeer.moleculator.windows;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.Point;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import xyz.mvarsmeer.moleculator.draw.DrawAtom;
import xyz.mvarsmeer.moleculator.draw.DrawLine;
import xyz.mvarsmeer.moleculator.buttons.InterfaceButtons;
import xyz.mvarsmeer.moleculator.buttons.MouseButtons;

public class Interface {
	
	ArrayList<DrawAtom> Atomos;
	ArrayList<DrawLine> Enlaces;
	ArrayList<String> Formulas;
	
	public Interface() {
		
		Atomos = new ArrayList<DrawAtom>();
		Enlaces = new ArrayList<DrawLine>();
		Formulas = new ArrayList<String>();
		
	}

	public void initInterface() {
		
		Frame Window = new Frame("Moleculator");
		Window.addWindowListener(new WindowListener());
		Window.setSize(1064,480);
		Window.setMinimumSize(new Dimension(1064,480));
		Window.setLocationRelativeTo(null);
		Window.setLayout(null);
		
		Label Categorias = new Label("Categorias");
		Categorias.setBounds(86, 51, 100, 20);
		Categorias.setForeground(Color.BLACK);
		Window.add(Categorias);

		Label Equipo = new Label("MVARSMEER");
		Equipo.setBounds((Window.getWidth()/2)-35, 450, 100, 20);
		Equipo.setForeground(Color.BLACK);
		Window.add(Equipo);

		Label Group = new Label("Grupos de moleculas");
		Group.setBounds(878, 51, 150, 20);
		Group.setForeground(Color.BLACK);
		Window.add(Group);
		
		Panel Formula = new Panel();
		Formula.setBounds(846,82,186,330);
		Formula.setBackground(Color.decode("#7A8A99"));
		Window.add(Formula);
		
		InterfaceButtons Boton = new InterfaceButtons(Atomos);
		Boton.CrearBoton(Window, 32, 82, "Metales alcainos", "#FFC8B0");
		Boton.CrearBoton(Window, 32, 112, "Alcalinoterreos", "#FFE6CC");
		Boton.CrearBoton(Window, 32, 142, "Otros metales", "#FFF2CC");
		Boton.CrearBoton(Window, 32, 172, "Metales de transicion", "#D0E882");
		Boton.CrearBoton(Window, 32, 202, "Lantanidos", "#D1E8A2");
		Boton.CrearBoton(Window, 32, 232, "Actinidos", "#B8E8B3");
		Boton.CrearBoton(Window, 32, 262, "Metaloides", "#D5E8D4");
		Boton.CrearBoton(Window, 32, 292, "No metales", "#E1D5E7");
		Boton.CrearBoton(Window, 32, 322, "Halogenos", "#D8A4DE");
		Boton.CrearBoton(Window, 32, 352, "Gases nobles", "#DAE8FC");
		Boton.CrearBoton(Window, 32, 382, "Custom", "#E9E4E3");

		Canvas DrawingZone = new Canvas();
		MouseButtons Click = new MouseButtons(DrawingZone);

		Icon settings = new ImageIcon("src\\xyz\\mvarsmeer\\moleculator\\resources\\Settings.png");
		Boton.CrearIcono(Window, DrawingZone, 32, 412, 170, 35, settings,"Configuracion", "#FFFFFF");

		Click.updateGraphics(Atomos, Enlaces);
		
		DrawingZone.setBounds(226, 55, 596, 393);
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
				
				DrawingZone.setBounds(226,55,WindowsX-468,WindowsY-87);
				Group.setBounds(WindowsX-186, 51, 150, 20);
				Formula.setBounds(WindowsX-218, 82, 186, 330);
				Equipo.setBounds((WindowsX/2)-35, WindowsY-30, 100, 20);
				
				Buffer = DrawingZone.getBufferStrategy();
				Drawing = Buffer.getDrawGraphics();
				
				try {

					Thread.sleep(250);

				} catch (InterruptedException e) {

					e.printStackTrace();

				}
				
				if(Atomos.size() > 0) {

					Atomos.get(0).Repaint = true;

				}
				
			}

			for(int cont1 = 0; cont1 < Atomos.size(); cont1++ ) {
				
				DrawAtom Actual = Atomos.get(cont1);
				
				if(Actual.Repaint && !Actual.Active) {
					
					Formula.removeAll();
					
				}
				
				if(Actual.Repaint) {
					
					Actual.repaint(Drawing);
					
					for(int cont2 = 0; cont2 < Enlaces.size(); cont2++) {
						
						DrawLine Repintar = Enlaces.get(cont2);
						Repintar.updateColor();
						Repintar.paint(Drawing);
						
					}
					
					for(int cont2 = 0; cont2 < Atomos.size(); cont2++) {
						
						DrawAtom Repintar = Atomos.get(cont2);
						Repintar.paint(Drawing);
						
					}
					
					Buffer.show();
					Actual.Repaint = false;
					
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
	
}
