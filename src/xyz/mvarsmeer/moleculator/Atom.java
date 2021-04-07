package xyz.mvarsmeer.moleculator;

public class Atom {

  private String Nombre;
  private String Tipo;
  private int Enlaces_Libres;
  private int Enlaces_Totales;

  public Atom(String Nombre, String Tipo, int Enlaces_Libres, int Enlaces_Totales) {

    this.Nombre = Nombre;
    this.Tipo = Tipo;
    this.Enlaces_Libres = Enlaces_Libres;
    this.Enlaces_Totales = Enlaces_Totales;

  }

  public String getNombre() {
    return this.Nombre;
  }

  public String getTipo() {
    return this.Tipo;
  }

  public int getEnlLibres() {
    return this.Enlaces_Libres;
  }

  public int getEnlTotales() {
    return this.Enlaces_Totales;

  }
}
