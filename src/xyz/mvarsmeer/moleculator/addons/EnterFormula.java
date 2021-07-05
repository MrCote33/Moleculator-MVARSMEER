package xyz.mvarsmeer.moleculator.addons;

import java.awt.Color;
import java.awt.TextField;
import java.util.ArrayList;

import xyz.mvarsmeer.moleculator.draw.DrawAtom;
import xyz.mvarsmeer.moleculator.draw.DrawLine;
import xyz.mvarsmeer.moleculator.information.Atom;

public class EnterFormula {
	
	String[] Colores = {"#FFC8B0","#FFE6CC","#FFF2CC","#D0E882","#D1E8A2","#B8E8B3","#D5E8D4","#E1D5E7","#D8A4DE","#DAE8FC"};
	
	public void insertFormula(ArrayList<DrawAtom> Elementos,ArrayList<DrawLine> Enlaces,ArrayList<ArrayList<Atom>> Atomos,TextField Formula) {
		
		String Texto = Formula.getText();
		ArrayList<Integer> ListElementos = new ArrayList<Integer>();
		int NumElementos = Elementos.size();
		
		int CoordX = 30;
		int CoordY = 30;
		
		if(Formula.getText().length() != 0) {
			
			for(int i = 0; i < Texto.length(); i++) {
				
				int Repetir = 0;
				String Simbolo = "";
				String LetraActual = Character.toString(Texto.charAt(i));
				
				if(LetraActual.matches("[A-Z]+")) {
					
					if(i+1 < Texto.length()) {
						
						String LetraSiguente = Character.toString(Texto.charAt(i+1));
						
						if(LetraSiguente.matches("[a-z]+")) {
							
							Simbolo += LetraActual;
							Simbolo += LetraSiguente;
							i += 1;
							
						} else {
							
							if(LetraSiguente.matches("[0-9]+")) {
								
								Repetir = Integer.parseInt(LetraSiguente);
								
							}
							
						}
						
					}
					
					if(Simbolo == "") {
						Simbolo += LetraActual;
					}
					
					if(Repetir == 0) {
						Repetir = 1;
					}
					
				} else {
					
					if(LetraActual.matches("[a-z]+")) {
						
						if(i+1 < Texto.length()) {
							
							String LetraSiguente = Character.toString(Texto.charAt(i+1));
							
							if(LetraSiguente.matches("[a-z]+")) {
								
								Simbolo += LetraActual;
								Simbolo += LetraSiguente;
								i += 1;
								
							} else {
								
								if(LetraSiguente.matches("[0-9]+")) {
									
									Repetir = Integer.parseInt(LetraSiguente);
									
								}
								
							}
							
						}
						
						if(Simbolo == "") {
							Simbolo += LetraActual;
						}
						
						if(Repetir == 0) {
							Repetir = 1;
						}
						
					}
					
				}
				
				if(Repetir != 0) {
					
					boolean Encontrado = false;
					
					for(int j = 0; j < Atomos.size(); j++) {
						
						ArrayList<Atom> GrupoActual = Atomos.get(j);
						
						for(int k = 0; k < GrupoActual.size(); k++) {
							
							Atom Atomo = GrupoActual.get(k);
							int Veces = 0;
							
							if(Atomo.getSimbolo().equals(Simbolo)) {
								
								Encontrado = true;
								
								while(Veces < Repetir) {
									
									DrawAtom Elemento = new DrawAtom(CoordX, CoordY, 60,Color.decode(Colores[j]), Atomo);
									Elemento.ID = NumElementos;
									ListElementos.add(Elemento.ID);
									Elemento.Active = false;
									Elementos.add(Elemento);
									NumElementos += 1;
									Veces += 1;
									
									if(CoordX < 500) {
										CoordX += 90;
									} else {
										CoordY += 90;
										CoordX = 30;
									}
									
								}
								
							}
							
						}
						
					}
					
					if(Encontrado == false) {
						
						Atom Atomo = new Atom("Custom",Simbolo,Simbolo,16);
						DrawAtom Elemento = new DrawAtom(CoordX, CoordY, 60, Color.decode("#E9E4E3"), Atomo);
						Elemento.ID = NumElementos;
						ListElementos.add(Elemento.ID);
						Elemento.Active = false;
						Elementos.add(Elemento);
						NumElementos += 1;
						
						if(CoordX < 500) {
							CoordX += 90;
						} else {
							CoordY += 90;
							CoordX = 30;
						}
						
					}
					
				}
				
			}
			
			int MaxNumEnlaces = Elementos.get(ListElementos.get(0)).Enlaces;
			int Mayor = ListElementos.get(0);
			
			for(int i = 1; i < ListElementos.size(); i++) {
				
				if(MaxNumEnlaces < Elementos.get(ListElementos.get(i)).Enlaces) {
					Mayor = ListElementos.get(i);
				}
				
			}
			
			for(int i = 0; i < ListElementos.size(); i++) {
				
				if(i != Mayor) {
					
					DrawLine Linea = new DrawLine();
					
					Linea.setFirst(Elementos.get(ListElementos.get(i)));
					Linea.setSecond(Elementos.get(Mayor));
					Linea.EnlEfectivos = 1;
					
					Elementos.get(ListElementos.get(i)).Enlaces -= 1;
					Elementos.get(Mayor).Enlaces -= 1;
					
					Enlaces.add(Linea);
					
				}
				
			}
			
			DrawAtom Grande = Elementos.get(Mayor);
			Grande.Repaint = true;
			
			if(Grande.Enlaces < 0) {
				
				Atom Nuevo = new Atom("Custom",Grande.Atomo.getNombre(),Grande.Atomo.getSimbolo(),Grande.Atomo.getTotalEnl()-Grande.Enlaces);
				Grande.Atomo = Nuevo;
				Grande.Enlaces = 0;
				
			}
			
			Formula.setText("");
			
		}
		
	}

}
