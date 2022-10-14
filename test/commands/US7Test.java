package commands;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.Document;

public class US7Test {
	Document doc = new Document();
	@Test
	public void testTransformDocToSpeechReverse() {
		DocumentToSpeech doc2Speech = new DocumentToSpeech(doc);
		String docContents[] = {"the doc contents i want to transform to audio in reverse"};
		String docContentsReverse[] = {"reverse in audio to transform to want i contents doc the"};
		doc2Speech.TransformDocToSpeechReverse(docContents);
		assertEquals(docContentsReverse, doc.getFakeT2SContents());
	}

}
