package commands;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.Document;

public class US2Test {
	Document doc = new Document();
	
	@Test
	public void testEditDoc() {
		EditDocument editDoc = new EditDocument(doc);
		editDoc.EditDoc("new edited document lines1");
		String expectedOutput[] = {"new edited document lines1"};
		assertEquals(expectedOutput, doc.getDocumentLines());
		editDoc.EditDoc("new edited document lines2");
		String expectedOutput2[] = {"new edited document lines2"};
		assertEquals(expectedOutput2, doc.getDocumentLines());
	}

}
