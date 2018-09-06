package docxToPdf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class DocToPDF {
	public static void ConvertToPDF(String src, String des) {
		try {
			InputStream doc = new FileInputStream(new File(src));
			XWPFDocument document = new XWPFDocument(doc);
			PdfOptions options = PdfOptions.create();
			OutputStream out = new FileOutputStream(new File(des));
			PdfConverter.getInstance().convert(document, out, options);
		} catch (FileNotFoundException ex) {
			new FileNotFoundException(ex.getMessage());
		} catch (IOException ex) {
			new IOException(ex.getMessage());
		}
	}

}
