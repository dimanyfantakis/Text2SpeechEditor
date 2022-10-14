package commands;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import javax.swing.JFileChooser;
import model.Document;
import view.AppFrame;
import view.TextPanel;

public class OpenDocument implements ActionListener{
	
	private AppFrame frame;
	private TextPanel txtPanel;
	private JFileChooser fchooser;
	private Document document;
	private String documentLines[];
	private String textTemp;
	
	public OpenDocument(AppFrame frame, TextPanel txtPanel, JFileChooser fchooser, Document doc) {
		this.frame = frame;
		this.txtPanel = txtPanel;
		this.fchooser = fchooser;
		this.document = doc;
	}
	public OpenDocument(Document doc) {
		this.document = doc;
	}
	
	public void actionPerformed(ActionEvent e) {
		if (fchooser.showOpenDialog(frame) == fchooser.APPROVE_OPTION) {
			File selectedFile = fchooser.getSelectedFile();
			OpenDoc(selectedFile);
			txtPanel.setText(textTemp);
			
		}
	}
	
	public void OpenDoc(File selectedFile) {
		this.textTemp = "";
		try {
			FileReader reader = new FileReader(selectedFile.getAbsoluteFile());
			Scanner scan = new Scanner(reader);
			while(scan.hasNextLine()) {
				String tmp = scan.nextLine()+"\n";
				textTemp += tmp;
			}
			scan.close();
			this.documentLines = textTemp.split("\n");
			document.setDocumentLines(documentLines);
		}catch(Exception exc) {
			exc.printStackTrace();
		}
	}
	
	public void setTextPanel() {
		txtPanel.setText(textTemp);
	}
}
