package xyz.mvarsmeer.moleculator;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class File {

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

          String Nombre = Datos[0];
          String Simbolo = Datos[1];
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
