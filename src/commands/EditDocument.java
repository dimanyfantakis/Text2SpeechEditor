package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Document;
import view.TextPanel;

public class EditDocument implements ActionListener{
	
	private TextPanel txtPanel;
	private String lines[];
	private Document document;
	
	public EditDocument(TextPanel txtPanel, Document doc) {
		this.txtPanel = txtPanel;
		this.document = doc;
	}
	public EditDocument(Document doc) {
		this.document = doc;
		
	}

	public void actionPerformed(ActionEvent e) {
		txtPanel.setEditable();
		String txt = txtPanel.getText();
		EditDoc(txt);
	}
	
	public void EditDoc(String txt) {
		this.lines = txt.split("\n");
		document.setDocumentLines(lines);
	}
	
}
