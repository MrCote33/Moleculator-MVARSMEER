package xyz.mvarsmeer.moleculator;

import java.awt.Dimension;
import javax.swing.JFrame;

public class Windows {

  public void CreateWindow(String Nombre) {

    JFrame Window = new JFrame(Nombre);
    Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Window.setSize(new Dimension(427, 240));
    Window.setLocationRelativeTo(null);
    Window.setLayout(null);
    Window.setResizable(false);

  }

}
