package xyz.mvarsmeer.moleculator.information;

import java.util.ArrayList;
import java.util.Collections;

import xyz.mvarsmeer.moleculator.draw.DrawAtom;

public class Formula {
	
	ArrayList<String> Formulas = null;
	
	public Formula(ArrayList<String> Formulas) {
		
		this.Formulas = Formulas;
		
	}
	
	public void getFormula(ArrayList<ArrayList<DrawAtom>> Grupos) {
		
		Formulas.clear();
		
		for(int i = 0; i < Grupos.size(); i++) {
			
			ArrayList<DrawAtom> Grupo = Grupos.get(i);
			ArrayList<String> Repetidos = new ArrayList<String>();
			
			for(int j = 0; j < Grupo.size(); j++) {
				Repetidos.add(Grupo.get(j).Atomo.getSimbolo());
			}
			
			Collections.sort(Repetidos);
			
			ArrayList<String> Elementos = new ArrayList<String>();
			ArrayList<Integer> Veces = new ArrayList<Integer>();
			
			String Actual = Repetidos.get(0);
			int NumVeces = 0;
			
			for(int j = 0; j < Repetidos.size(); j++) {
				
				if(Actual.equals(Repetidos.get(j))) {
					
					NumVeces += 1;
					
				} else {
					
					Elementos.add(Actual);
					Veces.add(NumVeces);
					
					Actual = Repetidos.get(j);
					NumVeces = 1;
					
				}
				
			}
			
			Elementos.add(Actual);
			Veces.add(NumVeces);
			
			String Formula = "";
			
			for(int j = 0; j < Elementos.size(); j++) {
				
				if(Veces.get(j) > 1) {
					
					Formula += Elementos.get(j);
					Formula += Veces.get(j);
					
				} else {
					
					Formula += Elementos.get(j);
					
				}
				
			}
			
			Formulas.add(Formula);
			
		}
		
	}

}
