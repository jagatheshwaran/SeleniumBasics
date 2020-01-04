package pdfToImage;

import net.sourceforge.tess4j.*;
import java.io.*;

public class TextFromImage {

	public String getImgText(String imageLocation) {
		ITesseract instance = new Tesseract();
		try {
			String imgText = instance.doOCR(new File(imageLocation));
			return imgText;
		} catch (TesseractException e) {
			e.getMessage();
			return "Error while reading image";
		}
	}

	public static void main(String[] args) {
		TextFromImage app = new TextFromImage();
		System.out.println(app.getImgText("C:\\Users\\Jagatheshwaran N\\Downloads\\Converted_Image.jpg"));
	}
}
