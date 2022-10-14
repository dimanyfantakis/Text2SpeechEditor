package model;

import java.util.ArrayList;
import java.util.List;

public class FakeText2Speech implements Text2SpeechAPI{
	
	private List<String> lines;
	
	public FakeText2Speech() {
		this.lines = new ArrayList<String>();
	}
	
	public void play(String line) {
		lines.add(line);
	}

	public String[] getLines() {
		String linesArray[] = new String[lines.size()];
		lines.toArray(linesArray);
		return linesArray;
	}
}
