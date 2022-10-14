package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Document;
import model.StrategiesFactory;
import view.TextPanel;

public class DocumentToSpeech implements ActionListener{

	public static final int ENCRYPTION_OPTION_NONE = 2;
	public static final int ENCRYPTION_OPTION_ATBASH = 0;
	public static final int ENCRYPTION_OPTION_ROT13 = 1;
	public static final int ENCRYPTION_OPTION_IN_REVERSE = 3;
	private TextPanel txtPanel;
	private String lines[];
	private StrategiesFactory stratFactory;
	private Document document;
	private String encodingStrategy;
	
	public DocumentToSpeech(TextPanel txtPanel, Document doc) {
		this.txtPanel = txtPanel;
		this.document = doc;
	}
	public DocumentToSpeech(Document doc) {
		this.document = doc;
	}

	public void actionPerformed(ActionEvent e) {
		
		String txt = txtPanel.getText();
		String linesTmp[] = txt.split("\n");
		
		Object options[] = {"AtBash", "Rot13", "None", "In Reverse"};
		int x = JOptionPane.showOptionDialog(null, "Choose an Encryption Method", "Encryption", JOptionPane.DEFAULT_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, options[ENCRYPTION_OPTION_NONE]);
		switch (x) {
			case ENCRYPTION_OPTION_ATBASH:
				TransformDocToSpeechAtBash(linesTmp);
				break;
			case ENCRYPTION_OPTION_ROT13:
				TransformDocToSpeechRot13(linesTmp);
				break;
			case ENCRYPTION_OPTION_NONE:
				TransformDocToSpeech(linesTmp);
				break;
			case ENCRYPTION_OPTION_IN_REVERSE:
				TransformDocToSpeechReverse(linesTmp);
		}
	}
	
	public void TransformDocToSpeech(String docLines[]) {
		this.lines = docLines;
		document.playDoc(lines);
	}
	
	public void TransformDocToSpeechReverse(String docLines[]) {
		this.lines = docLines;
		document.playDocReverse(lines);
	}
	
	public void TransformDocToSpeechAtBash(String docLines[]) {
		this.lines = docLines;
		this.encodingStrategy = "atbash";
		stratFactory = new StrategiesFactory(encodingStrategy, lines, document);
	}
	public void TransformDocToSpeechRot13(String docLines[]) {
		this.lines = docLines;
		this.encodingStrategy = "rot13";
		stratFactory = new StrategiesFactory(encodingStrategy, lines, document);
	}
	
}
