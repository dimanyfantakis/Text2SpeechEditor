package model;

import java.util.ArrayList;
import java.util.List;

//import com.sun.speech.freetts.*;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class Text2SpeechAdapter implements Text2SpeechAPI{
	
	private List<String> lines;
	Voice voice;
	
	public Text2SpeechAdapter() {
		System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
		this.voice = VoiceManager.getInstance().getVoice("kevin16");
		if(voice != null) {
			voice.allocate();
		}
		this.lines = new ArrayList<String>();
	}
	
	public void play(String line) {
		lines.add(line);
		try {
			voice.speak(line);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public String[] getLines() {
		String linesArray[] = new String[lines.size()];
		lines.toArray(linesArray);
		return linesArray;
	}
}
