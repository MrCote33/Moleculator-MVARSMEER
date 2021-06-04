package xyz.mvarsmeer.moleculator;

import java.awt.Canvas;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MouseButtons extends MouseAdapter {
	
	ArrayList<DrawAtom> ListaElemento;
	ArrayList<DrawLine> ListaLineas;
	
	ArrayList<ArrayList<DrawAtom>> ListaGrupos;
	ArrayList<String> ListaFormulas;
	
	Canvas DrawingZone;
	DrawAtom Elemento;
	Menu Desplegar;
	
	public MouseButtons(Canvas DrawingZone) {
		
		this.DrawingZone = DrawingZone;
		
	}
	
	public void updateGraphics(ArrayList<DrawAtom> ListaElemento, ArrayList<DrawLine> ListaLineas) {
		
		this.ListaElemento = ListaElemento;
		this.ListaLineas = ListaLineas;
		this.Desplegar = new Menu(ListaLineas);
		
	}
	
	public void updateLists(ArrayList<ArrayList<DrawAtom>> ListaGrupos, ArrayList<String> ListaFormulas) {
		
		this.ListaGrupos = ListaGrupos;
		this.ListaFormulas = ListaFormulas;
		
	}
	
	public void updateActive(DrawAtom Elemento) {
		
		this.Elemento = Elemento;

	}
	
	public void mouseClicked(MouseEvent event) {
		
		if(event.getButton() == MouseEvent.BUTTON1) {

			if(this.Elemento != null) {
				Elemento.Active = false;
			}

		}
		
		if(event.getButton() == MouseEvent.BUTTON3) {

			for(int i = 0; i < ListaElemento.size(); i++) {
				
				int x = ListaElemento.get(i).x;
				int y = ListaElemento.get(i).y;
				
				if(event.getX() >= x+7 && event.getX() <= x+(ListaElemento.get(i).Diametro-14)) {
					
					if(event.getY() >= y+7 && event.getY() <= y+(ListaElemento.get(i).Diametro-14)) {
						
						this.Elemento = ListaElemento.get(i);
						Desplegar.Pop(ListaElemento, i, ListaGrupos, ListaFormulas, DrawingZone, event);
						
					}
					
				}
				
			}
			
		}
		
	}

}
