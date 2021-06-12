package xyz.mvarsmeer.moleculator.addons;

import java.awt.Font;
import java.awt.Canvas;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.util.ArrayList;

public class Menu {

	ErrorMessage Error = new ErrorMessage();
	ArrayList<DrawLine> Lineas;
	DrawLine Linea;
	
	public Menu(ArrayList<DrawLine> Lineas) {
		
		this.Lineas = Lineas;
		
	}
	
	public void Pop(ArrayList<DrawAtom> Elements, int Active, Canvas Dibujo, MouseEvent e) {

		FontReader Fuente = new FontReader();
		Font Fuente1 = Fuente.CreateFont("src\\xyz\\mvarsmeer\\moleculator\\JetBrainsMono-Bold.ttf",11);

		DrawAtom Element = Elements.get(Active);
		JPopupMenu Menu = new JPopupMenu();

		JMenuItem Nombre = new JMenuItem(Element.Atomo.getNombre(), JMenuItem.CENTER);
		Nombre.setFont(Fuente1.deriveFont(13f));	
		Nombre.setBackground(Elements.get(Active).Paint);
		Nombre.setEnabled(false);

		JMenuItem Move = new JMenuItem("Mover");
		Move.setFont(Fuente1);

		JMenuItem Magnify = new JMenuItem("Aumentar");
		Magnify.setFont(Fuente1);

		JMenuItem Minimize = new JMenuItem("Reducir");
		Minimize.setFont(Fuente1);

		JMenuItem Link = new JMenuItem("Unir");
		Link.setFont(Fuente1);

		JMenuItem Modify = new JMenuItem("Modificar");
		Modify.setFont(Fuente1);

		JMenuItem Delete = new JMenuItem("Borrar");
		Delete.setFont(Fuente1);
		
		Move.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				
				DrawAtom AtomActual = Elements.get(Active);
				AtomActual.Active = true;
				
			}
			
		});

		Magnify.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e){

				DrawAtom AtomActual = Elements.get(Active);

				if(AtomActual.Diametro < 75){

					AtomActual.Diametro = AtomActual.Diametro + 5;
					AtomActual.Repaint = true;

				} else {

					Error.NewMessage("Magnify");

				}
				
			}

		});

		Minimize.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e){

				DrawAtom AtomActual = Elements.get(Active);

				if(AtomActual.Diametro > 45){

					AtomActual.Diametro = AtomActual.Diametro - 5;
					AtomActual.Repaint = true;

				} else {

					Error.NewMessage("Minimaze");

				}

			}

		});


		Link.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				if(Linea == null) {
					
					Linea = new DrawLine();
					
				}

				if(Element.Enlaces > 0) {
					
					if(Linea.Primero == null) {
						
						Linea.setFirst(Element);
						
					}
					
					if(Linea.Segundo == null && Linea.Primero != Element) {
						
						Linea.setSecond(Element);
						Linea.Primero.Enlaces -= 1;
						Linea.Segundo.Enlaces -= 1;
						
						for(int cont = 0; cont < Lineas.size(); cont++) {
							
							if(Linea.Primero.equals(Lineas.get(cont).Primero)) {
								
								if(Linea.Segundo.equals(Lineas.get(cont).Segundo)) {
									
									Lineas.get(cont).EnlEfectivos += 1;
									Linea = null;
									
								}
								
							}
								
							if(Linea != null && Linea.Primero.equals(Lineas.get(cont).Segundo)) {
								
								if(Linea.Segundo.equals(Lineas.get(cont).Primero)) {
									
									Lineas.get(cont).EnlEfectivos += 1;
									Linea = null;
									
								}
								
							}
							
						}
						
						if(Linea != null) {
							
							Lineas.add(Linea);
							Linea = null;
							
						}
						
					}
					
				} else {
					
					Error.NewMessage("Link Atom");
					
				}

			}

		});

		Modify.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e){

				Custom ModAtom = new Custom(Element);
				ModAtom.CreateWindow("Modificar " + Element.Atomo.getNombre(), Elements);
				
			}

		});

		Delete.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				ArrayList<Integer> Eliminar = new ArrayList<Integer>();
				DrawAtom AtomActual = Elements.get(Active);
				
				if(Linea != null) {
					
					if(Linea.Primero != null && Linea.Primero == AtomActual) {
						Linea.Primero = null;
					}
					
				}
				
				for(int cont1 = 0; cont1 < Lineas.size(); cont1++) {
					
					DrawLine LineaActual = Lineas.get(cont1);
					
					if(LineaActual.Primero == AtomActual) {

						LineaActual.Segundo.Enlaces += LineaActual.EnlEfectivos;
						Eliminar.add(cont1);

					}
					
					if(LineaActual.Segundo == AtomActual) {

						LineaActual.Primero.Enlaces += LineaActual.EnlEfectivos;
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
		Menu.add(Move);
		Menu.add(Magnify);
		Menu.add(Minimize);
		Menu.add(Link);
		Menu.add(Modify);
		Menu.add(Delete);
		Menu.show(e.getComponent(), e.getX(), e.getY());

	}

}
