package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Document;
import model.StrategiesFactory;
import view.TextPanel;

public class LineToSpeech implements ActionListener{

	public static final int ENCRYPTION_AT_BASH = 0;
	public static final int ENCRYPTION_ROT13 = 1;
	public static final int ENCRYPTION_NONE = 2;
	public static final int ENCRYPTION_IN_REVERSE = 3;
	private TextPanel txtPanel;
	private String line;
	private String txtLines[];
	private StrategiesFactory stratFactory;
	private Document document;
	private int lineNumber;
	private String encodingStrategy;
	private String docLine;
	private JTextField txtField;
	
	public LineToSpeech(TextPanel txtPanel, JTextField txtField, Document doc) {
		this.txtPanel = txtPanel;
		this.txtField = txtField;
		this.document = doc;
	}
	public LineToSpeech(Document doc) {
		this.document = doc;
		this.lineNumber = 1;
	}

	public void actionPerformed(ActionEvent e) {
		this.line = txtField.getText();
		String txt = txtPanel.getText();
		this.txtLines = txt.split("\n");
		try {
			this.lineNumber = Integer.parseInt(line);
			Object options[] = {"AtBash", "Rot13", "None", "In Reverse"};
			int x = JOptionPane.showOptionDialog(null, "Choose an Encryption Method", "Encryption", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
			if (wrongLineNumber()) {
				JOptionPane.showMessageDialog(null, "Your document doesnt contain line" + lineNumber, "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			switch (x) {
				case ENCRYPTION_AT_BASH:
					TransformLineToSpeechAtBash(txtLines);
				case ENCRYPTION_ROT13:
					TransformLineToSpeechRot13(txtLines);
				case ENCRYPTION_NONE:
					TransformLineToSpeech(txtLines);
				case ENCRYPTION_IN_REVERSE:
					TransformLineToSpeechReverse(txtLines);
			}
		}catch(Exception exc) {
			JOptionPane.showMessageDialog(null, "You didn't give an integer line number", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private boolean wrongLineNumber() {
		return lineNumber <= 0 || lineNumber > txtLines.length;
	}

	public void TransformLineToSpeech(String docLine[]) {
		this.txtLines = docLine;
		document.playLine(txtLines[lineNumber - 1]);
	}
	public void TransformLineToSpeechReverse(String docLine[]) {
		this.txtLines = docLine;
		document.playLineReverse(txtLines[lineNumber - 1]);
	}
	public void TransformLineToSpeechAtBash(String docLine[]) {
		this.txtLines = docLine;
		this.encodingStrategy = "atbash";
		stratFactory = new StrategiesFactory(encodingStrategy, txtLines, lineNumber, document);
	}
	public void TransformLineToSpeechRot13(String docLine[]) {
		this.txtLines = docLine;
		this.encodingStrategy = "rot13";
		stratFactory = new StrategiesFactory(encodingStrategy, txtLines, lineNumber, document);
	}

}
