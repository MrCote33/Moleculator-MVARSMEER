package xyz.mvarsmeer.moleculator.addons;

import java.util.ArrayList;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.awt.Color;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import xyz.mvarsmeer.moleculator.draw.DrawAtom;
import xyz.mvarsmeer.moleculator.draw.DrawLine;
import xyz.mvarsmeer.moleculator.information.Atom;
import xyz.mvarsmeer.moleculator.windows.ErrorMessage;

public class ArchiveOptions {

	ErrorMessage Mensaje = new ErrorMessage();
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
				
				File RutaArchivo = Save.getSelectedFile();
				
				if(!Save.getSelectedFile().getAbsolutePath().endsWith(".mvarsmeer")){
					RutaArchivo = new File(Save.getSelectedFile() + ".mvarsmeer");
				}

				FileWriter myWriter = new FileWriter(RutaArchivo);
			
				for(int i = 0; i < ListaElemento.size(); i++){

					String datos = "";

					datos += ListaElemento.get(i).Atomo.getTipo() + ",";
					datos += ListaElemento.get(i).Atomo.getNombre() + ",";
					datos += ListaElemento.get(i).Atomo.getSimbolo() + ",";
					datos += ListaElemento.get(i).Atomo.getTotalEnl()+ ",";
					datos += ListaElemento.get(i).Diametro + ",";
					datos += ListaElemento.get(i).Paint.getRed()+ ",";
					datos += ListaElemento.get(i).Paint.getGreen()+ ",";
					datos += ListaElemento.get(i).Paint.getBlue()+ ",";
					datos += ListaElemento.get(i).x + ",";
					datos += ListaElemento.get(i).y + "\n";

					ListaElemento.get(i).ID = i;
					myWriter.write(datos);

				}

				myWriter.write("END\n");
				
				for(int j = 0; j<ListaLineas.size(); j++) {

					String datos ="";
					
					datos += ListaLineas.get(j).Primero.ID + ",";
					datos += ListaLineas.get(j).Segundo.ID + ",";
					datos += ListaLineas.get(j).EnlEfectivos + "\n";
					myWriter.write(datos);

				}

				Mensaje.NewMessage("Archive");
				myWriter.close();
				
			} catch(IOException e) {

				Mensaje.NewMessage("");
				e.printStackTrace();

			}

		}	

	}

	public void CargarCanvas() {

		JFileChooser Path = new JFileChooser();
		int resultado = Path.showOpenDialog(Path);
		File Archivo = Path.getSelectedFile();
		
		if(resultado == JFileChooser.APPROVE_OPTION){

			try {

				ListaElemento.clear();
				ListaLineas.clear();

				FileReader LectorArchivo = new FileReader(Archivo);
				BufferedReader Lector = new BufferedReader(LectorArchivo);

				String Actual = "";
				boolean Categoria = false;

				while ((Actual = Lector.readLine()) != null) {
					
					Atom Atomo = null;
					DrawAtom Elemento = null;
					String Datos[] = {};

					if (Actual.equals("END")) {

						Categoria = true;

					} else {

						if(Categoria == true){

							Datos = Actual.split(",", 3);

							int Primero = Integer.parseInt(Datos[0]);
							int Segundo = Integer.parseInt(Datos[1]);
							int EnlEfectivos = Integer.parseInt(Datos[2]);

							DrawLine Linea = new DrawLine();

							Linea.setFirst(ListaElemento.get(Primero));
							Linea.setSecond(ListaElemento.get(Segundo));
							Linea.EnlEfectivos = EnlEfectivos;
							ListaElemento.get(Primero).Enlaces-=EnlEfectivos;
							ListaElemento.get(Segundo).Enlaces-=EnlEfectivos;
							ListaLineas.add(Linea);

						}

						if(Categoria == false){

							Datos = Actual.split(",", 10);
							
							String Tipo = new String(Datos[0].getBytes("ISO-8859-1"),"UTF-8");
							String Nombre = new String(Datos[1].getBytes("ISO-8859-1"),"UTF-8");
							String Simbolo = new String(Datos[2].getBytes("ISO-8859-1"),"UTF-8");
							int Enlaces = Integer.parseInt(Datos[3]);
							int Diametro = Integer.parseInt(Datos[4]);
							int R = Integer.parseInt(Datos[5]);
							int G = Integer.parseInt(Datos[6]);
							int B = Integer.parseInt(Datos[7]);
							int X = Integer.parseInt(Datos[8]);
							int Y = Integer.parseInt(Datos[9]);

							Color Paint = Color.decode("#"+Integer.toHexString(R)+Integer.toHexString(G)+Integer.toHexString(B));

							Atomo = new Atom(Tipo, Nombre, Simbolo, Enlaces);
							Elemento = new DrawAtom(X, Y, Diametro, Paint, Atomo);
							Elemento.Active=false;

							ListaElemento.add(Elemento);

						}

					}

				}

			ListaElemento.get(0).Repaint = true;
			Lector.close();

			} catch(IOException e) {

				Mensaje.NewMessage("");
				e.printStackTrace();

			}

		}

	}
	
}
