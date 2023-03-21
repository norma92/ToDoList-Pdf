package it.softwareInside.NoteAppLezione22.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.springframework.beans.factory.annotation.Autowired;

import it.softwareInside.NoteAppLezione22.services.PdfService;

public class GeneratePdf {

//	@Autowired
//	PdfService pdfS;
//	
//	public ByteArrayInputStream generaPdf(Integer id) {
//		ByteArrayOutputStream output = new ByteArrayOutputStream();
//		
//		try {
//			pdfS.save();
//			pdfS.addPage();
//			pdfS.insertText(id);
//			pdfS.save();
//			pdfS.close();
//			
//			return new ByteArrayInputStream(output.toByteArray());
//			
//		} catch (Exception e) {
//			System.out.println(	"errore: "	+	e	+	"\n"	+
//								"non è stato possibile creare un pdf");
//			return null;
//		}
//	}
}

//public void generaPdf(Integer id) {
//	
//	try {
//		pdfS.save();
//		pdfS.addPage();
//		pdfS.insertText(id);
//		pdfS.save();
//		pdfS.close();
//		
//	} catch (Exception e) {
//		System.out.println(	"errore: "	+	e	+	"\n"	+
//							"non è stato possibile creare un pdf");
//	}
//}