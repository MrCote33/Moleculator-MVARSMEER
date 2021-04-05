import java.awt.Graphics;
import java.awt.Point;

public class DrawAtom {
	
	public void paint(Graphics g, Point location) {
		
		int X = 0;
		int Y = 0;
		
		if(location == null) {
			X = 0;
			Y = 0;
		} else {
			X = location.x;
			Y = location.y;
		}
		
		g.drawArc(X, Y, 50, 50, 0, 360);
		
	}

}