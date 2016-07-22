package com.technoglitz.io;

import java.io.FileOutputStream;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfCopy;
import com.lowagie.text.pdf.PdfReader;

public class MergePDF {
	public static void main(String[] args) {
        try {
			String[] files = { "C:\\merger\\varun_be-cnsld2.pdf", "C:\\merger\\varun_be-cnsld1.pdf" };
			Document PDFCombineUsingJava = new Document();
			PdfCopy copy = new PdfCopy(PDFCombineUsingJava, new FileOutputStream("C:\\merger\\cnsld.pdf"));
			PDFCombineUsingJava.open();
			PdfReader ReadInputPDF;
			int number_of_pages;
			for (int i = 0; i < files.length; i++) {
				ReadInputPDF = new PdfReader(files[i]);
				number_of_pages = ReadInputPDF.getNumberOfPages();
				for (int page = 0; page < number_of_pages;) {
					copy.addPage(copy.getImportedPage(ReadInputPDF, ++page));
				}
			}
			PDFCombineUsingJava.close();
        }
 catch (Exception i) {
			System.out.println(i);
        }
    }
}
