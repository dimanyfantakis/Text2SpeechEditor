package commands;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.Document;

public class US5 {
	Document doc = new Document();

	@Test
	public void testTransformDocToSpeech() {
		DocumentToSpeech doc2Speech = new DocumentToSpeech(doc);
		String docContents[] = {"doc's content to be transformed to audio"};
		doc2Speech.TransformDocToSpeech(docContents);
		assertEquals(docContents, doc.getFakeT2SContents());
	}

}
