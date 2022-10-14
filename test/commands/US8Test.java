package commands;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.Document;

public class US8Test {
	Document doc = new Document();
	@Test
	public void testTransformLineToSpeechReverse() {
		LineToSpeech l2s = new LineToSpeech(doc);
		String docContents[] = {"the line of the doc i want to transform to audio in reverse"};
		String docContentsReverse[] = {"reverse in audio to transform to want i doc the of line the"};
		l2s.TransformLineToSpeechReverse(docContents);
		assertEquals(docContentsReverse, doc.getFakeT2SContents());
		
	}

}
