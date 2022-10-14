package commands;

import model.Document;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class US10A {

	Document doc = new Document();
	@Test
	public void testTransformLineToSpeechAtBash() {
		LineToSpeech l2s = new LineToSpeech(doc);
		String docContents[] = {"the line of the doc i want to transform to audio using atbash encodement"};
		String docContentsEncodedAtBash[] = {"gsv ormv lu gsv wlx r dzmg gl gizmhulin gl zfwrl fhrmt zgyzhs vmxlwvnvmg"};
		l2s.TransformLineToSpeechAtBash(docContents);
		assertEquals(docContentsEncodedAtBash, doc.getFakeT2SContents());
	}

}
