package xyz.mvarsmeer.moleculator;

import java.awt.Color;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {

	public static void Pop(Atom Element,Color color, MouseEvent e) {

        JPopupMenu Menu = new JPopupMenu();

        JMenuItem Nombre = new JMenuItem(Element.getNombre(), JMenuItem.CENTER);
                  Nombre.setEnabled(false);
        JMenuItem Link = new JMenuItem("Link atom");
        JMenuItem Delete = new JMenuItem("Delete atom");

        Link.addActionListener(new ActionListener() {

		    public void actionPerformed(ActionEvent e) {

                System.out.println("Escoja otro atomo");

            }

		});


        Delete.addActionListener(new ActionListener() {

		    public void actionPerformed(ActionEvent e) {

                System.out.println("Se ha borrado el atomo");

            }

		});

        Menu.add(Nombre);
        Menu.add(Link);
        Menu.add(Delete);
        Menu.setBackground(color);
        Menu.show(e.getComponent(), e.getX(), e.getY());

	}

}
