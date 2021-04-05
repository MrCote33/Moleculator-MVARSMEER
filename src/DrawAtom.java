import java.awt.Graphics;
import java.awt.Point;

public class DrawAtom {
	
	public void paint(Graphics g, Point location) {
		
		g.drawArc(location.x, location.y, 50, 50, 0, 360);
		
	}

}