package xyz.mvarsmeer.moleculator.addons;

import java.awt.Canvas;
import java.awt.Frame;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.awt.AWTException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class ExportOptions {
	
	public void GuardadoPNG(Canvas panel,Frame MainFrame) throws AWTException {

		JFileChooser VisualGuardado = new JFileChooser();
		
		VisualGuardado.setFileFilter(new FileNameExtensionFilter("Png images(.png)", "png"));

		if(VisualGuardado.showSaveDialog(panel) == JFileChooser.APPROVE_OPTION){

			try {
				
				MainFrame.setAlwaysOnTop(true);
				
				try {
					
					Thread.sleep(250);
					
				} catch (InterruptedException e) {
					
					e.printStackTrace();
					
				}
				
				Point CoordsFrame = MainFrame.getLocationOnScreen();
				Rectangle SizeCaptura = new Rectangle(CoordsFrame.x+226,CoordsFrame.y+55,panel.getSize().width,panel.getSize().height);
				
				Robot Captura = new Robot();
				BufferedImage image = Captura.createScreenCapture(SizeCaptura);
				
				ImageIO.write(image, "png", VisualGuardado.getSelectedFile());
				System.out.println("Se ha guardado correctamente");
				
				MainFrame.setAlwaysOnTop(false);
	
			} catch (IOException e) {
	
				System.out.println("No se ha puesto ningun nombre");

			}

		}else{

			System.out.println("No se ha guardado ningun archivo");

		}

	}

	public void GuardadoPDF(Canvas panel, Frame MainFrame) throws AWTException {

		JFileChooser VisualGuardadoPDF = new JFileChooser();
		
		VisualGuardadoPDF.setFileFilter(new FileNameExtensionFilter("PDF files(.pdf)", "pdf"));

		if(VisualGuardadoPDF.showSaveDialog(panel) == JFileChooser.APPROVE_OPTION){

			try {
				
				MainFrame.setAlwaysOnTop(true);
				
				try {
					
					Thread.sleep(250);
					
				} catch (InterruptedException e) {
					
					e.printStackTrace();
					
				}
				
				Point CoordsFrame = MainFrame.getLocationOnScreen();
				Rectangle SizeCaptura = new Rectangle(CoordsFrame.x+226,CoordsFrame.y+55,panel.getSize().width,panel.getSize().height);
				
				Robot Captura = new Robot();
				BufferedImage image = Captura.createScreenCapture(SizeCaptura);
				
				ImageIO.write(image, "png", VisualGuardadoPDF.getSelectedFile());
				
				try {
					
					Thread.sleep(250);
					
				} catch (InterruptedException e) {
					
					e.printStackTrace();
					
				}
				
				try (PDDocument Doc = new PDDocument()) {
					
					PDPage pagina = new PDPage(PDRectangle.A2);
					Doc.addPage(pagina);
					PDImageXObject pdImage = PDImageXObject.createFromFile(VisualGuardadoPDF.getSelectedFile().getAbsolutePath(), Doc);
					
					try (PDPageContentStream cont = new PDPageContentStream(Doc, pagina)) {
						
						cont.drawImage(pdImage, 10,1015);
						cont.close();
						
					}
					
					Doc.save(VisualGuardadoPDF.getSelectedFile());
					Doc.close();
					
				}
				
				System.out.println("Se ha guardado correctamente");
				
				MainFrame.setAlwaysOnTop(false);
	
			} catch (IOException e) {
	
				System.out.println("No se ha puesto ningun nombre");

			}

		}else{

			System.out.println("No se ha guardado ningun archivo");

		}

	}

}
