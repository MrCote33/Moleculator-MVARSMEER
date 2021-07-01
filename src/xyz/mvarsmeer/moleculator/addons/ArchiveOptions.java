package xyz.mvarsmeer.moleculator.addons;

import java.util.ArrayList;
import java.io.IOException;
import java.io.FileWriter;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

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
		JFileChooser Save = new JFileChooser();
		
		Save.setFileFilter(new FileNameExtensionFilter("MVARSMEER File", "mvarsmeer"));
		
		if(Save.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
			
			try {
			      FileWriter myWriter = new FileWriter(Save.getSelectedFile());
			      System.out.println("Successfully wrote to the file.");
			
				for(int i = 0; i<ListaElemento.size(); i++){
					String datos = "";
					datos += ListaElemento.get(i).Atomo.getNombre() + ",";
					datos += ListaElemento.get(i).Atomo.getSimbolo() + ",";
					datos += ListaElemento.get(i).Atomo.getTotalEnl()+ ",";
					datos += ListaElemento.get(i).Paint.getRed()+ ",";
					datos += ListaElemento.get(i).Paint.getGreen()+ ",";
					datos += ListaElemento.get(i).Paint.getBlue()+ ",";
					datos += ListaElemento.get(i).x + ",";
					datos += ListaElemento.get(i).y + "\n";
					ListaElemento.get(i).ID = i;
				    myWriter.write(datos);
				}
				myWriter.write("\n");
				
				for(int j = 0; j<ListaLineas.size(); j++) {
					String datos ="";
					
					datos += ListaLineas.get(j).Primero.ID + ",";
					datos += ListaLineas.get(j).Segundo.ID + ",";
					datos += ListaLineas.get(j).EnlEfectivos + "\n";
				    myWriter.write(datos);
				}
				myWriter.close();
				
			} catch(IOException e) {
				e.printStackTrace();
		    }
		}	
	}

	public void CargarCanvas() {
		
	}
}
