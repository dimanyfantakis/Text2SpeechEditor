package commands;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import model.Document;

public class US1Test {
	Document doc = new Document();
	@Test
	public void testCreateDoc() {
		NewDocument newDoc = new NewDocument("titleTest", "authorTest", doc);
		newDoc.createDoc();
		assertEquals(null , doc.getDocumentLines());
		
	}

}
