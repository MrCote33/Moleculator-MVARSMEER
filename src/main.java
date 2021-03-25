import java.awt.Dimension;
import javax.swing.JFrame;

public class Main {
	
	private static void CreateWindow() {
		
		 JFrame Window = new JFrame("Moleculator");
		 Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 Window.setSize(new Dimension(854,480));
		 Window.setLocationRelativeTo(null);
		 Window.setVisible(true);
		
	}

	public static void main(String[] args) {
		
		CreateWindow();

	}

}
