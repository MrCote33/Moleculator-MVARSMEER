package xyz.mvarsmeer.moleculator.information;

import java.util.ArrayList;

import xyz.mvarsmeer.moleculator.draw.DrawAtom;
import xyz.mvarsmeer.moleculator.draw.DrawLine;

public class Grupos {
	
	ArrayList<ArrayList<DrawAtom>> Grupos;
	
	public Grupos(ArrayList<ArrayList<DrawAtom>> Groups) {
		
		this.Grupos = Groups;
		
	}
	
	public void getGrupo(ArrayList<DrawLine> Enlaces) {
		
		Grupos.clear();
		ArrayList<DrawAtom> Atomos;
		
		for(int i = 0; i < Enlaces.size(); i++) {
			
			boolean uno = false;
			boolean dos = false;
			
			for(int j = 0; j < Grupos.size(); j++) {
				
				ArrayList<DrawAtom> Grupo = Grupos.get(j);
				
				if(Grupo.contains(Enlaces.get(i).Primero)) {
					uno = true;
				}
				
				if(Grupo.contains(Enlaces.get(i).Segundo)) {
					dos = true;
				}
				
				if(uno && dos == false) {
					Grupo.add(Enlaces.get(i).Segundo);
					break;
				}
				
				if(dos && uno == false) {
					Grupo.add(Enlaces.get(i).Primero);
					break;
				}
				
			}
			
			if(uno == false && dos == false) {
				
				Atomos = new ArrayList<DrawAtom>();
				
				Atomos.add(Enlaces.get(i).Primero);
				Atomos.add(Enlaces.get(i).Segundo);
				
				Grupos.add(Atomos);
				
			}
			
		}
		
		boolean update = false;
		
		if(Grupos != null) {
			
			int LargoGrupos = Grupos.size();
			
			for(int i = 0; i < LargoGrupos; i++) {
				
				ArrayList<DrawAtom> Grupo1 = Grupos.get(i);
				
				for(int j = 0; j < LargoGrupos; j++) {
					
					ArrayList<DrawAtom> Grupo2 = Grupos.get(j);
					
					if(i != j) {
						
						for(int k = 0; k < Grupo2.size(); k++) {
							
							if(Grupo1.contains(Grupo2.get(k))) {
								
								Grupo2.remove(k);
								update = true;
								
							}
							
						}
						
					}
					
					if(update) {
						
						Grupo1.addAll(Grupo2);
						Grupos.remove(j);
						LargoGrupos = Grupos.size();
						update = false;
						
					}
					
				}
				
			}
			
		}
		
	}

}
