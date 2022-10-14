package commands;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Document;

public class US10R {
	Document doc = new Document();
	@Test
	public void testTransformLineToSpeechRot13() {
		LineToSpeech l2s = new LineToSpeech(doc);
		String docContents[] = {"the line of the doc i want to transform to audio using rot13 encodement"};
		String docContentsEncodedRot13[] = {"gur yvar bs gur qbp v jnag gb genafsbez gb nhqvb hfvat ebg13 rapbqrzrag"};
		l2s.TransformLineToSpeechRot13(docContents);
		assertEquals(docContentsEncodedRot13, doc.getFakeT2SContents());
	}

}
