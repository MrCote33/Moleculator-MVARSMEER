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

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import xyz.mvarsmeer.moleculator.windows.ErrorMessage;

public class ExportOptions {
	
	ErrorMessage Mensaje = new ErrorMessage();

	public void GuardadoPNG(Canvas panel,Frame MainFrame) throws AWTException {

		JFileChooser VisualGuardado = new JFileChooser();
		VisualGuardado.setFileFilter(new FileNameExtensionFilter("PNG Images(.png)", "png"));

		if(VisualGuardado.showSaveDialog(panel) == JFileChooser.APPROVE_OPTION){

			try {
				
				File RutaArchivo = VisualGuardado.getSelectedFile();
				
				if(!RutaArchivo.getAbsolutePath().endsWith(".png")){
					
					String Ruta = RutaArchivo.getAbsolutePath();
					RutaArchivo = new File(Ruta.substring(0, Ruta.length()-4) + ".png");

				}
				
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
				
				ImageIO.write(image, "png", RutaArchivo);
				MainFrame.setAlwaysOnTop(false);
				Mensaje.NewMessage("Archive");
	
			} catch (IOException e) {
	
				Mensaje.NewMessage("");
				e.printStackTrace();

			}

		}

	}

	public void GuardadoPDF(Canvas panel, Frame MainFrame) throws AWTException {

		JFileChooser VisualGuardadoPDF = new JFileChooser();
		VisualGuardadoPDF.setFileFilter(new FileNameExtensionFilter("PDF Files(.pdf)", "pdf"));

		if(VisualGuardadoPDF.showSaveDialog(panel) == JFileChooser.APPROVE_OPTION){

			try {
				
				File RutaArchivo = VisualGuardadoPDF.getSelectedFile();
				
				if(!VisualGuardadoPDF.getSelectedFile().getAbsolutePath().endsWith(".png")){
					
					if(VisualGuardadoPDF.getSelectedFile().getAbsolutePath().endsWith(".pdf")) {
						
						String Ruta = VisualGuardadoPDF.getSelectedFile().getAbsolutePath();
						RutaArchivo = new File(Ruta.substring(0, Ruta.length()-4) + ".png");
						
					} else {
						
						RutaArchivo = new File(VisualGuardadoPDF.getSelectedFile() + ".png");
						
					}
					
				}
				
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
				
				ImageIO.write(image, "png", RutaArchivo);
				
				try {
					
					Thread.sleep(250);
					
				} catch (InterruptedException e) {
					
					e.printStackTrace();
					
				}
				
				try (PDDocument Doc = new PDDocument()) {
					
					PDPage pagina = new PDPage(PDRectangle.A2);
					Doc.addPage(pagina);
					PDImageXObject pdImage = PDImageXObject.createFromFile(RutaArchivo.getAbsolutePath(), Doc);
					
					try (PDPageContentStream cont = new PDPageContentStream(Doc, pagina)) {
						
						cont.drawImage(pdImage, 10,1015);
						cont.close();
						
					}
					
					RutaArchivo.delete();
					
					if(!RutaArchivo.getAbsolutePath().endsWith(".pdf")){
						
						String Ruta = RutaArchivo.getAbsolutePath();
						RutaArchivo = new File(Ruta.substring(0, Ruta.length()-4) + ".pdf");
						
					}
					
					Doc.save(RutaArchivo);
					Doc.close();
					
				}
				
				MainFrame.setAlwaysOnTop(false);
				Mensaje.NewMessage("Archive");
	
			} catch (IOException e) {
				
				Mensaje.NewMessage("");
				e.printStackTrace();

			}

		}

	}

}
