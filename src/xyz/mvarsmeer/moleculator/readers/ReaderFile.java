package xyz.mvarsmeer.moleculator.readers;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ReaderFile {

	public ArrayList<Atom> LeerArchivo(String Path) {

		FileReader Archivo;

		ArrayList<Atom> ListaDeAtomos = new ArrayList<Atom>();

		try {

			Archivo = new FileReader(Path);
			BufferedReader Lector = new BufferedReader(Archivo);

			Atom Atomo = null;

			String Tipo = "";
			String Actual = "";

			while ((Actual = Lector.readLine()) != null) {

			if (!Actual.contains(",")) {

				Tipo = Actual;

			} else {

				String Datos[] = Actual.split(",", 3);

				String Nombre = new String(Datos[0].getBytes("ISO-8859-1"),"UTF-8");
				String Simbolo = new String(Datos[1].getBytes("ISO-8859-1"),"UTF-8");
				int Enlaces = Integer.parseInt(Datos[2]);

				Atomo = new Atom(Tipo, Nombre, Simbolo, Enlaces);
				ListaDeAtomos.add(Atomo);

				}

			}

			Lector.close();
			return ListaDeAtomos;

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

	return ListaDeAtomos;

	}

}
