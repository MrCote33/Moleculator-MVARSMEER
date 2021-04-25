package xyz.mvarsmeer.moleculator;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class DrawLine {
    
    int E1x;
    int E1y;
    int E2x;
    int E2y;

    public DrawLine(int E1x, int E1y, int E2x, int E2y){

        this.E1x = E1x;
        this.E1y = E1y;
        this.E2x = E2x;
        this.E2y = E2y;

    }

    public void paint(Graphics g){

        Graphics2D g2 = (Graphics2D) g;

        g2.drawLine(E1x, E1y, E2x, E2y);
        g2.setColor(Color.RED);

    }

}
