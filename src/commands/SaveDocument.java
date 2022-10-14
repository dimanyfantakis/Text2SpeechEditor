package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import model.Document;
import view.AppFrame;
import view.TextPanel;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class SaveDocument implements ActionListener{
	
	private AppFrame frame;
	private TextPanel txtPanel;
	private JFileChooser fchooser;
	private String dateSaved;
	private String lines[];
	private Document document;
	
	public SaveDocument(AppFrame frame, TextPanel txtPanel, JFileChooser fchooser, Document doc) {
		this.frame = frame;
		this.txtPanel = txtPanel;
		this.fchooser = fchooser;
		this.document = doc;
	}
	public SaveDocument(Document doc) {
		this.document = doc;
	}
	
	public void actionPerformed(ActionEvent e) {
		if (isDocumentEmptyOrisDocumentTitleEmpty()) {
			JOptionPane.showMessageDialog(null, "You didn't create a document or open an existing one", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if (fchooser.showSaveDialog(frame) == fchooser.APPROVE_OPTION) {
			File selectedFile = fchooser.getSelectedFile();
			String txt = txtPanel.getText();
			SaveDoc(selectedFile, txt);
		}
	}

	private boolean isDocumentEmptyOrisDocumentTitleEmpty() {
		return document.getDocumentLines() == null || document.getTitle() == null;
	}

	public void SaveDoc(File selectedFile, String txt) {
		try {
			this.lines = txt.split("\n");
			FileWriter fw = new FileWriter(selectedFile+".txt");
			fw.write(txt.toString());
			fw.flush();
			fw.close();
		}catch(IOException exc) {
			exc.printStackTrace();
		}
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		dateSaved = dateFormat.format(date);
		document.setDateSaved(dateSaved);
		document.setDocumentLines(lines);
	}
}
