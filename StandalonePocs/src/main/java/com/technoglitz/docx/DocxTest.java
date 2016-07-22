package com.technoglitz.docx;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBException;

import org.docx4j.openpackaging.exceptions.Docx4JException;

public class DocxTest {

	static DocxWordService docxWordService = new DocxWordService();

	public static void main(String[] args) throws Docx4JException, JAXBException, IOException {
		List<Map<String, String>> asList = new ArrayList<Map<String, String>>(3);
		Map<String, String> repl1 = new HashMap<String, String>();
		repl1.put("SJ_FUNCTION", "function1");
		repl1.put("SJ_DESC", "desc1");
		repl1.put("SJ_PERIOD", "period1");
		asList.add(repl1);
		Map<String, String> repl2 = new HashMap<String, String>();
		repl2.put("SJ_FUNCTION", "function2");
		repl2.put("SJ_DESC", "desc2");
		repl2.put("SJ_PERIOD", "period2");
		asList.add(repl2);

		Map<String, String> repl3 = new HashMap<String, String>();
		repl3.put("SJ_FUNCTION", "function3");
		repl3.put("SJ_DESC", "desc3");
		repl3.put("SJ_PERIOD", "period3");
		asList.add(repl3);
		docxWordService
				.replaceTable(
						new String[] { "SJ_FUNCTION", "SJ_DESC", "SJ_PERIOD" },
						asList,
						docxWordService
								.getTemplate("C:\\Documents and Settings\\db2admin\\My Documents\\Dev\\workspace\\dva\\Test\\src\\main\\java\\com\\technoglitz\\template.docx"));
		docxWordService.writeDocxToStream(docxWordService.getTemplate(new String(
				"C:\\Documents and Settings\\db2admin\\My Documents\\Dev\\workspace\\dva\\Test\\src\\main\\java\\com\\technoglitz\\template.docx")),
				"new.docx");

	}
}
