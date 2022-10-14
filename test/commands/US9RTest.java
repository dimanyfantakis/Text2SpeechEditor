package commands;

import model.Document;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class US9RTest {
	Document doc = new Document();
	@Test
	public void testTransformDocToSpeechRot13() {
		DocumentToSpeech doc2Speech = new DocumentToSpeech(doc);
		String docContents[] = {"the doc contents i want to transform to using rot13 encodement"};
		String docContentsEncodedRot13[] = {"gur qbp pbagragf v jnag gb genafsbez gb hfvat ebg13 rapbqrzrag"};
		doc2Speech.TransformDocToSpeechRot13(docContents);
		assertEquals(docContentsEncodedRot13, doc.getFakeT2SContents());
	}

}
