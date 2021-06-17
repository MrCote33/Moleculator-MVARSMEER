package xyz.mvarsmeer.moleculator.addons;

import java.awt.Canvas;
import java.awt.Graphics2D;
import java.awt.AWTException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ExportOptions {
	
	public void GuardadoPNG(Canvas panel) throws AWTException {

		JFileChooser VisualGuardado = new JFileChooser();
		
		VisualGuardado.setCurrentDirectory(new File("src\\xyz\\mvarsmeer\\moleculator\\Screenshots"));
		VisualGuardado.setFileFilter(new FileNameExtensionFilter("Png images(.png)", "png"));

		if(VisualGuardado.showSaveDialog(panel) == JFileChooser.APPROVE_OPTION){

			try {

				BufferedImage image = new BufferedImage(panel.getWidth(),panel.getHeight(),BufferedImage.TYPE_INT_RGB);
				Graphics2D g = image.createGraphics();
				g.drawImage(image, null, 0, 0);

				ImageIO.write(image, "png", VisualGuardado.getSelectedFile());
				System.out.println("Se ha guardado correctamente");
				g.dispose();
	
			} catch (IOException e) {
	
				System.out.println("No se ha puesto ningun nombre");

			}

		}else{

			System.out.println("No se ha guardado ningun archivo");

		}

	}

	public void GuardadoPDF(Canvas panel) throws AWTException {

		JFileChooser VisualGuardadoPDF = new JFileChooser();
		
		VisualGuardadoPDF.setCurrentDirectory(new File("src\\xyz\\mvarsmeer\\moleculator\\Screenshots"));
		VisualGuardadoPDF.setFileFilter(new FileNameExtensionFilter("PDF files(.pdf)", "pdf"));

		if(VisualGuardadoPDF.showSaveDialog(panel) == JFileChooser.APPROVE_OPTION){

			try {

				BufferedImage image = new BufferedImage(panel.getWidth(),panel.getHeight(),BufferedImage.TYPE_INT_RGB);
				Graphics2D g = image.createGraphics();
				panel.paintAll(g);
				ImageIO.write(image, "pdf", VisualGuardadoPDF.getSelectedFile());
				System.out.println("Se ha guardado correctamente");
				g.dispose();
	
			} catch (IOException e) {
	
				System.out.println("No se ha puesto ningun nombre");

			}

		}else{

			System.out.println("No se ha guardado ningun archivo");

		}

	}

}
