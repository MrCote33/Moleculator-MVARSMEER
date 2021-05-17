package xyz.mvarsmeer.moleculator;

import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.awt.FontFormatException;

public class FontReader {

	Font Fuente;
	
	public Font CreateFont(String FontPath, float FontSize){

		File Estilo = new File(FontPath);
		
		try {

			Fuente = Font.createFont(Font.TRUETYPE_FONT, Estilo).deriveFont(FontSize);

		} catch (FontFormatException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

		return Fuente;
	}

}
