package seleniumWebdriver;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.testng.Assert;
import org.testng.annotations.Test;



public class S27_PdfReader {

	@Test
	public void readPDFFile() throws IOException {
		URL url = new URL("file:///C:/Users/Bijaya%20Chhetri/eclipse-workspace/Maven_Seleniums/Include/test_text1.pdf");
		InputStream is = url.openStream();
		BufferedInputStream fileParser = new BufferedInputStream(is);
		PDDocument document = null;
		
		document = PDDocument.load(fileParser);
		String pdfContent = new PDFTextStripper().getText(document);
		System.out.println(pdfContent);
		
		Assert.assertTrue(pdfContent.contains("Introduction"));		
		
	}
}
