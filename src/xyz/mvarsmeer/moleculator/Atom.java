package xyz.mvarsmeer.moleculator;

public class Atom {

  private String Tipo;
  private String Nombre;
  private String Simbolo;
  private int Enlaces;

  public Atom(String Tipo, String Nombre, String Simbolo, int Enlaces) {

    this.Tipo = Tipo;
    this.Nombre = Nombre;
    this.Simbolo = Simbolo;
    this.Enlaces = Enlaces;

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

  public int getEnlaces() {

    return this.Enlaces;

  }

  public void Imprimir() {

    System.out.print("Tipo: ");
    System.out.println(getTipo());
    System.out.print("Nombre: ");
    System.out.println(getNombre());
    System.out.print("Simbolo: ");
    System.out.println(getSimbolo());
    System.out.print("Enlaces Libres: ");
    System.out.println(getEnlaces() + "\n");

  }

}
