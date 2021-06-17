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
		ArrayList<DrawAtom> Atomos = new ArrayList<DrawAtom>();
		
		for(int i = 0; i < Enlaces.size(); i++) {
				
			boolean uno = false;
			boolean dos = false;
			
			for(int j = 0; j < Grupos.size(); j++) {
				
				ArrayList<DrawAtom> Grupo = Grupos.get(j);
				
				for(int k = 0; k < Grupo.size(); k++) {
					
					if(Grupo.get(k) == Enlaces.get(i).Primero) {
						uno = true;
					}
					
					if(Grupo.get(k) == Enlaces.get(i).Segundo) {
						dos = true;
					}
					
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
		
		if(Grupos != null) {
			
			int LargoGrupos = Grupos.size();
			
			for(int i = 0; i < LargoGrupos; i++) {
				
				ArrayList<DrawAtom> Grupo = Grupos.get(i);
				
				for(int j = 0; j < LargoGrupos; j++) {
					
					ArrayList<DrawAtom> GrupoAux = Grupos.get(j);
					
					for(int k = 0; k < Grupo.size(); k++) {
						
						for(int l = 0; l < GrupoAux.size(); l++) {
							
							if(i != j) {
								
								if(Grupo.get(k) == GrupoAux.get(l)) {
									
									GrupoAux.remove(l);
									Grupo.addAll(GrupoAux);
									
									if(GrupoAux.size() == 0) {
										
										Grupos.remove(j);
										LargoGrupos--;
										
									}
									
								}
								
							}
							
						}
						
					}
					
				}
				
			}
			
		}
		
	}

}
