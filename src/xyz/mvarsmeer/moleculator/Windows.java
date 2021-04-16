package xyz.mvarsmeer.moleculator;

import java.awt.Dimension;
import javax.swing.JFrame;
import java.awt.Color;
import java.util.ArrayList;

public class Windows {

  public void CreateWindow(String Seccion, Color color) {

    JFrame Window = new JFrame(Seccion);
    Window.setSize(new Dimension(427, 240));
    Window.setLocationRelativeTo(null);
    Window.setLayout(null);
    Window.setResizable(false);
    Window.setVisible(true);

    ArrayList<Atom> Lista = new ArrayList<Atom>();

    File archivo = new File();
    Lista = archivo.LeerArchivo("src\\xyz\\mvarsmeer\\moleculator\\Elements.txt");

    for (int i = 0; i < Lista.size(); i++) {

      System.out.println(Lista.get(i).getTipo());

    }

  }

}
