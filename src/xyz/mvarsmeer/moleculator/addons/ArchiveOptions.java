package xyz.mvarsmeer.moleculator.addons;

import java.util.ArrayList;

import xyz.mvarsmeer.moleculator.draw.DrawAtom;
import xyz.mvarsmeer.moleculator.draw.DrawLine;

public class ArchiveOptions {
	
	ArrayList<DrawAtom> ListaElemento;
	ArrayList<DrawLine> ListaLineas;

	public ArchiveOptions(ArrayList<DrawAtom> ListaElemento, ArrayList<DrawLine> ListaLineas){

		this.ListaElemento = ListaElemento;
		this.ListaLineas = ListaLineas;

	}

	public void GuardarCanvas(){
		
	}

	public void CargarCanvas() {
		
	}
}
