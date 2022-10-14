package commands;

import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JTextField;

import model.Document;
import view.AppFrame;
import view.TextPanel;

public class CommandsFactory {
	
	private Document document = new Document();
	
	public ActionListener createDocument(JTextField titleField, JTextField authorField, TextPanel txtPanel) {
		return new NewDocument(titleField, authorField, txtPanel, document);
	}
	public ActionListener openDocument(AppFrame frame, TextPanel txtPanel, JFileChooser fchooser) {
		return new OpenDocument(frame, txtPanel, fchooser, document);
	}
	public ActionListener saveDocument(AppFrame frame, TextPanel txtPanel, JFileChooser fchooser) {
		return new SaveDocument(frame, txtPanel, fchooser, document);
	}
	public ActionListener editDocument(TextPanel txtPanel, AppFrame frame) {
		return new EditDocument(txtPanel, document);
	}
	public ActionListener documentToSpeech(TextPanel txtPanel) {
		return new DocumentToSpeech(txtPanel, document);
	}
	public ActionListener lineToSpeech(TextPanel txtPanel, JTextField txtField) {
		return new LineToSpeech(txtPanel, txtField, document);
	}
}
