import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Buttons {

  public void CrearBoton(JFrame Window, int x, int y, String Contenido, String color) {

    JButton Boton = new JButton(Contenido);
    Boton.setBounds(x, y, 160, 30);
    Boton.setBackground(Color.decode(color));
    Window.add(Boton);

  }

}
