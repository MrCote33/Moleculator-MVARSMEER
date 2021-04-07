package xyz.mvarsmeer.moleculator;

public class Atom {

  private String Tipo;
  private String Nombre;
  private String Simbolo;
  private int Enlaces_Libres;
  private int Enlaces_Totales;

  public Atom(String Tipo, String Nombre, String Simbolo, int Enlaces_Libres, int Enlaces_Totales) {
    this.Tipo = Tipo;
    this.Nombre = Nombre;
    this.Simbolo = Simbolo;
    this.Enlaces_Libres = Enlaces_Libres;
    this.Enlaces_Totales = Enlaces_Totales;

  }

  public String getTipo() {
    return this.Tipo;
  }

  public String getNombre() {
    return this.Nombre;
  }

  public String getSimbolo() {
    return this.Simbolo;
  }

  public int getEnlLibres() {
    return this.Enlaces_Libres;
  }

  public int getEnlTotales() {
    return this.Enlaces_Totales;
  }

}
