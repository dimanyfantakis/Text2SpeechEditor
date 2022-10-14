package commands;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.Document;

public class US6 {
	Document doc = new Document();
	@Test
	public void testTransformLineToSpeech() {
		LineToSpeech l2s = new LineToSpeech(doc);
		String l[] = {"the line of the doc i want to transform to audio"};
		l2s.TransformLineToSpeech(l);
		assertEquals(l, doc.getFakeT2SContents());
	}

}
