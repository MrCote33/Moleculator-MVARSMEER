package xyz.mvarsmeer.moleculator.addons;

import java.awt.Color;
import java.awt.TextField;
import java.util.ArrayList;

import xyz.mvarsmeer.moleculator.draw.DrawAtom;
import xyz.mvarsmeer.moleculator.draw.DrawLine;
import xyz.mvarsmeer.moleculator.information.Atom;

public class EnterFormula {
	
	public void insertFormula(ArrayList<DrawAtom> Elementos,ArrayList<DrawLine> Enlaces,ArrayList<ArrayList<Atom>> Atomos,TextField Formula) {
		
		String Texto = Formula.getText();
		int NumElementos = Elementos.size();
		
		int CoordX = 30;
		int CoordY = 30;
		
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
								
								DrawAtom Elemento = new DrawAtom(CoordX, CoordY, 60, Color.decode("#FFD1F8"), Atomo);
								NumElementos += 1;
								Elemento.ID = NumElementos;
								Elemento.Active = false;
								Elemento.Repaint = true;
								Elementos.add(Elemento);
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
					DrawAtom Elemento = new DrawAtom(CoordX, CoordY, 60, Color.decode("#FFD1F8"), Atomo);
					NumElementos += 1;
					Elemento.ID = NumElementos;
					Elemento.Active = false;
					Elemento.Repaint = true;
					Elementos.add(Elemento);
					
					if(CoordX < 500) {
						CoordX += 90;
					} else {
						CoordY += 90;
						CoordX = 30;
					}
					
				}
				
			}
			
		}
		
		Formula.setText("");
		
	}

}
