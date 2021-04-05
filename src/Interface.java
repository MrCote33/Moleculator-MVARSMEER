import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Interface {
	
	public void CreateWindow() {
		
		JFrame Window = new JFrame("Moleculator");
		Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Window.setSize(new Dimension(854,480));
		Window.setLocationRelativeTo(null);
		Window.setVisible(true);
		Window.setLayout(null);
		
		JLabel Equipo = new JLabel("MVARSMEER",JLabel.CENTER);
		Equipo.setSize(80,15);
		Equipo.setLocation(2,2);
		
		Window.add(Equipo);
		DrawAtom Atom = new DrawAtom();
		
		while(Window.isActive()) {
			
			Window.repaint();
			Point location = Window.getMousePosition();
			Atom.paint(Window.getGraphics(), location);
			
		}
		
	}

}
