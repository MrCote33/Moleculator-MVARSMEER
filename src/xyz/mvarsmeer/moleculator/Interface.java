package xyz.mvarsmeer.moleculator;

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

public class Interface {

	public void initInterface() {
		
		ArrayList<DrawAtom> Atomos = new ArrayList<DrawAtom>();
		ArrayList<DrawLine> Enlaces = new ArrayList<DrawLine>();
		
		ArrayList<ArrayList<DrawAtom>> Grupos = new ArrayList<ArrayList<DrawAtom>>();
		ArrayList<String> Formulas = new ArrayList<String>();

		Frame Window = new Frame("Moleculator");
		Window.addWindowListener(new WindowListener());
		Window.setSize(1064,480);
		Window.setMinimumSize(new Dimension(1064,480));
		Window.setLocationRelativeTo(null);
		Window.setLayout(null);
		
		Label Equipo = new Label("MVARSMEER");
		Equipo.setBounds(78, 51, 100, 20);
		Equipo.setForeground(Color.BLACK);
		Window.add(Equipo);

		Label Group = new Label("Grupos de moleculas");
		Group.setBounds(870, 51, 150, 20);
		Group.setForeground(Color.BLACK);
		Window.add(Group);
		
		Panel Formula = new Panel();
		Formula.setBounds(846,82,186,330);
		Formula.setBackground(Color.decode("#7A8A99"));
		Window.add(Formula);
		
		ScrollPanel Panel = new ScrollPanel();
		
		Buttons Boton = new Buttons(Atomos);
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
		
		Click.updateGraphics(Atomos, Enlaces);
		Click.updateLists(Grupos, Formulas);
		
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
		
		Grupos ObjetoGroup = new Grupos(Grupos);
		Formula ListFormula = new Formula(Formulas);
		
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
				Group.setBounds(WindowsX-196, 51, 150, 20);
				Formula.setBounds(WindowsX-218, 82, 186, 330);
				
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
					
					ObjetoGroup.getGrupo(Enlaces);
					ListFormula.getFormula(Grupos);
					Formula.add(Panel.getPanel(Formulas,Grupos));
					
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
