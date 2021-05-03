package xyz.mvarsmeer.moleculator;

import java.awt.Canvas;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.util.ArrayList;

public class Menu {
	
	ArrayList<DrawLine> Lineas;
	DrawLine Linea;
	
	public Menu(ArrayList<DrawLine> Lineas) {
		
		this.Lineas = Lineas;
		
	}
	
	public void Pop(ArrayList<DrawAtom> Elements, int Active, Canvas Dibujo, MouseEvent e) {
		
		DrawAtom Element = Elements.get(Active);
		JPopupMenu Menu = new JPopupMenu();

		JMenuItem Nombre = new JMenuItem(Element.Atomo.getNombre(), JMenuItem.CENTER);
				  Nombre.setEnabled(false);

		JMenuItem Magnify = new JMenuItem("Magnify");
		JMenuItem Minimize = new JMenuItem("Minimize");
		JMenuItem Link = new JMenuItem("Link atom");
		JMenuItem Delete = new JMenuItem("Delete "+ Element.Atomo.getNombre());


		Magnify.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e){

				DrawAtom AtomActual = Elements.get(Active);

				if(AtomActual.Diametro < 80){

					AtomActual.Diametro = AtomActual.Diametro + 4;
					AtomActual.Repaint = true;

				}
				
			}

		});

		Minimize.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e){

				DrawAtom AtomActual = Elements.get(Active);

				if(AtomActual.Diametro > 20){

					AtomActual.Diametro = AtomActual.Diametro - 4;
					AtomActual.Repaint = true;

				}

			}

		});


		Link.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if(Element.Enlaces > 0){

					if(Linea == null) {

						Linea = new DrawLine();

					}
					
					if(Linea.Primero == null) {
						
						Linea.setFirst(Element);
						
					} else {
						
						if(Linea.Segundo == null && Linea.Primero != Element) {
							
							Linea.setSecond(Element);
							Linea.Primero.Enlaces -= 1;
							Linea.Segundo.Enlaces -= 1;
							
							Lineas.add(Linea);
							Linea = null;
							
						}
						
					}

				}

			}

		});

		Delete.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				ArrayList<Integer> Eliminar = new ArrayList<Integer>();
				DrawAtom AtomActual = Elements.get(Active);
				
				for(int cont1 = 0; cont1 < Lineas.size(); cont1++) {
					
					DrawLine LineaActual = Lineas.get(cont1);
					
					if(LineaActual.Primero == AtomActual) {

						LineaActual.Segundo.Enlaces += 1;
						Eliminar.add(cont1);

					}
					
					if(LineaActual.Segundo == AtomActual) {

						LineaActual.Primero.Enlaces += 1;
						Eliminar.add(cont1);
						
					}
					
				}
				
				for(int cont2 = Eliminar.size() - 1; cont2 >= 0; cont2--) {
					
					int num = Eliminar.get(cont2);
					Lineas.remove(num);
					
				}
				
				Elements.remove(Active);
				
				if(Elements.size() > 0) {
					
					Elements.get(0).Repaint = true;
					
				} else {
					
					Dibujo.repaint();
					
				}
				
			}
			
		});

		Menu.add(Nombre);
		Menu.add(Magnify);
		Menu.add(Minimize);
		Menu.add(Link);
		Menu.add(Delete);
		Menu.show(e.getComponent(), e.getX(), e.getY());

	}

}
