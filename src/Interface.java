import java.awt.Dimension;
import javax.swing.JFrame;

public class Interface {
	
	public void CreateWindow() {
		
		JFrame Window = new JFrame("Moleculator");
		 Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 Window.setSize(new Dimension(854,480));
		 Window.setLocationRelativeTo(null);
		 Window.setVisible(true);
		
	}

}
