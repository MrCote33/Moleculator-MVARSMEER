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

}
