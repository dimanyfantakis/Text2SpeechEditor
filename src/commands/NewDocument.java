package commands;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.Document;
import view.TextPanel;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class NewDocument implements ActionListener{
	
	private TextPanel txtPanel;
	private JTextField authorField;
	private JTextField titleField;
	private String author;
	private String title;
	private String dateCreated;
	private Document document;
	
	public NewDocument(JTextField titleField, JTextField authorField, TextPanel txtPanel, Document doc) {
		this.txtPanel = txtPanel;
		this.titleField = titleField;
		this.authorField = authorField;
		this.document = doc;
		txtPanel.clearText();
		txtPanel.setEditable();
	}
	public NewDocument(String title, String author, Document doc) {
		this.title = title;
		this.author = author;
		this.document = doc;
	}

	public void actionPerformed(ActionEvent e) {
		this.author = authorField.getText();
		this.title = titleField.getText();
		createDoc();
	}
	
	public void createDoc() {
		if (author.isEmpty() && title.isEmpty()) {
			JOptionPane.showMessageDialog(null, "You didn't give a title and an author name for your document", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}else if (author.isEmpty()) {
			JOptionPane.showMessageDialog(null, "You didn't give an author name for your document", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}else if (title.isEmpty()) {
			JOptionPane.showMessageDialog(null, "You didn't give a title for your document", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		this.dateCreated = dateFormat.format(date);
		document.setAuthor(author);
		document.setTitle(title);
		document.setDateCreated(dateCreated);
		document.setDocumentLines(null);
	}
}
