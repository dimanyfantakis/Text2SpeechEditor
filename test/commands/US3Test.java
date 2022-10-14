package commands;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

import org.junit.Test;

import model.Document;

public class US3Test {
	Document doc = new Document();
	@Test
	public void test() {
		SaveDocument saveDoc = new SaveDocument(doc);
		File testFile = new File("testFile");
		String savedContents = "the saved contents of the file";
		saveDoc.SaveDoc(testFile, savedContents);
		String temp = "";
		try {
			FileReader fr = new FileReader("testFile.txt");
			Scanner scan = new Scanner(fr);
			while(scan.hasNextLine()) {
				String tmp = scan.nextLine()+"\n";
				temp += tmp;
			}
			scan.close();
			
		}catch(Exception exc) {
			exc.printStackTrace();
		}
		String expectedContents[] = temp.split("\n");
		assertEquals(expectedContents, doc.getDocumentLines());
	}

}
