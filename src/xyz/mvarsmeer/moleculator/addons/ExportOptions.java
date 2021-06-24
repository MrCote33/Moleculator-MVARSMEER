package xyz.mvarsmeer.moleculator.addons;

import java.awt.Canvas;
import java.awt.Frame;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.AWTException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

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

				String Dest = "HOLA.pdf"; 
				File file = new File(Dest);

				createPdf(Dest);

				System.out.println("Se ha guardado correctamente");
				
				MainFrame.setAlwaysOnTop(false);
	
			} catch (IOException e) {
	
				System.out.println("No se ha puesto ningun nombre");

			}

		}else{

			System.out.println("No se ha guardado ningun archivo");

		}

	}

	public void createPdf(String dest) throws IOException {
		//Initialize PDF writer
		PdfWriter writer = new PdfWriter(dest);

		//Initialize PDF document
		PdfDocument pdf = new PdfDocument(writer);
		
		pdf.addNewPage();
		// Initialize document
		Document document = new Document(pdf);

		//Add paragraph to the document
		document.add(new Paragraph("Hello World!"));

		//Close document
		document.close();
	}

}
