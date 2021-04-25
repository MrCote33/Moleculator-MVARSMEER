package xyz.mvarsmeer.moleculator;

import java.awt.Canvas;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {
    
	public static void Pop(ArrayList<DrawAtom> Elements, int Active, Canvas Dibujo, MouseEvent e) {
		
		DrawAtom Element = Elements.get(Active);

        JPopupMenu Menu = new JPopupMenu();

        JMenuItem Nombre = new JMenuItem(Element.Atomo.getNombre(), JMenuItem.CENTER);
                  Nombre.setEnabled(false);
        JMenuItem Link = new JMenuItem("Link atom");
        JMenuItem Delete = new JMenuItem("Delete atom");

        Link.addActionListener(new ActionListener() {

		    public void actionPerformed(ActionEvent e) {

                if(Element.Atomo.getEnlaces() > 0){

                    System.out.println("Escoja otro atomo para enlazar");

                }

            }

		});

        Delete.addActionListener(new ActionListener() {

		    public void actionPerformed(ActionEvent e) {
		    	
		    	Elements.remove(Active);
		    	
		    	if(Elements.size() > 0) {
		    		Elements.get(0).Repaint = true;
		    	} else {
		    		Dibujo.repaint();
		    	}

            }

		});

        Menu.add(Nombre);
        Menu.add(Link);
        Menu.add(Delete);
        Menu.show(e.getComponent(), e.getX(), e.getY());

	}

}
