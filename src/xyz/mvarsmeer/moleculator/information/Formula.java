package xyz.mvarsmeer.moleculator.information;

import java.util.ArrayList;
import java.util.Collections;

public class Formula {
	
	ArrayList<String> Formulas = null;
	
	public Formula(ArrayList<String> Formulas) {
		
		this.Formulas = Formulas;
		
	}
	
	public void getFormula(ArrayList<ArrayList<DrawAtom>> Grupos) {
		
		Formulas.clear();
		
		for(int i = 0; i < Grupos.size(); i++) {
			
			ArrayList<DrawAtom> Grupo = Grupos.get(i);
			ArrayList<String> Elementos = new ArrayList<String>();
			
			for(int j = 0; j < Grupo.size(); j++) {
				
				Elementos.add(Grupo.get(j).Atomo.getSimbolo());
				
			}
			
			Collections.sort(Elementos); 
			
			String Formula = "";
			int Largo = Elementos.size();
			
			for(int j = 0; j < Largo; j++) {
				
				int Numero = 1;
				
				for(int k = 0; k < Largo; k++) {
					
					if(j != k) {
						
						if(Elementos.get(j) == Elementos.get(k)) {
							
							Elementos.remove(k);
							Numero++;
							Largo--;
							
						}
						
					}
					
				}
				
				if(Numero == 1) {

					Formula += Elementos.get(j);

				} else {

					Formula += Elementos.get(j)+Numero;
					
				}
				
			}
			
			Formulas.add(Formula);
			
		}
		
	}

}
