package commands;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.Document;

public class US9ATest {
	Document doc = new Document();
	@Test
	public void testTransformDocToSpeechAtBash() {
		DocumentToSpeech doc2Speech = new DocumentToSpeech(doc);
		String docContents[] = {"the doc contents i want to transform to using atbash encodement"};
		String docContentsEncodedAtBash[] = {"gsv wlx xlmgvmgh r dzmg gl gizmhulin gl fhrmt zgyzhs vmxlwvnvmg"};
		doc2Speech.TransformDocToSpeechAtBash(docContents);
		assertEquals(docContentsEncodedAtBash, doc.getFakeT2SContents());
	}

}
