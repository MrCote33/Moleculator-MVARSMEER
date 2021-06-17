package xyz.mvarsmeer.moleculator.addons;

import java.awt.Color;
import java.awt.Panel;
import java.util.ArrayList;
import javax.swing.JScrollBar;

import xyz.mvarsmeer.moleculator.buttons.InterfaceButtons;
import xyz.mvarsmeer.moleculator.draw.DrawAtom;

public class ScrollPanel {
	
	Panel Contenedor = new Panel();
	JScrollBar Scroll = new JScrollBar();
	
	public void updatePanel() {
		
		Contenedor.setBounds(0,0,186,450);
		Scroll.setBounds(170, 0, 16, 330);
		
	}
	
	public void showPanel(ArrayList<String> Formulas, ArrayList<ArrayList<DrawAtom>> Grupos) {
		
		InterfaceButtons Boton = new InterfaceButtons(null);
		Contenedor.removeAll();
		
		for(int i = 0; i < Formulas.size(); i++) {
			
			ArrayList<DrawAtom> Grupo = Grupos.get(i);
			
			int R = 0;
			int G = 0;
			int B = 0;
			
			for(int j = 0; j < Grupo.size(); j++) {
				
				R += Grupo.get(j).Paint.getRed();
				G += Grupo.get(j).Paint.getGreen();
				B += Grupo.get(j).Paint.getBlue();
				
			}
			
			R = R / Grupo.size();
			G = G / Grupo.size();
			B = B / Grupo.size();
			
			Color RGB = Color.decode("#"+Integer.toHexString(R)+Integer.toHexString(G)+Integer.toHexString(B));
			
			Boton.CrearFormula(Contenedor, 0, 30*i, Formulas.get(i), RGB);
			
		}
		
		Contenedor.repaint();
		
	}

}
