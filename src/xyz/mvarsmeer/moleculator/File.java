package xyz.mvarsmeer.moleculator;

import java.io.*;

public class File {

  public void LeerArchivo(String Path) {

    FileReader Archivo;

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
          Atomo.Imprimir();

        }

      }

      Lector.close();

    } catch (FileNotFoundException e) {
      e.printStackTrace();

    } catch (IOException e) {
      e.printStackTrace();

    }

  }

}
