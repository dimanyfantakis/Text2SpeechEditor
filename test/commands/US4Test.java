package commands;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

import org.junit.Test;

import model.Document;

public class US4Test {
	Document doc = new Document();
	@Test
	public void testOpenDoc() {
		OpenDocument openDoc = new OpenDocument(doc);
		String temp = "";
		try {
			File f = new File("testFile.txt");
			FileWriter fw = new FileWriter(f+".txt");
			fw.write("content of the file in the disk");
			fw.flush();
			fw.close();
			openDoc.OpenDoc(f);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			FileReader fr = new FileReader("testFile.txt");
			Scanner scan = new Scanner(fr);
			while(scan.hasNextLine()) {
				String tmp = scan.nextLine()+"\n";
				temp += tmp;
			}
			scan.close();
			String expectedContents[] = temp.split("\n");
			assertEquals(expectedContents, doc.getDocumentLines());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
