package view;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextPanel extends JPanel {
	
	private JTextArea textArea;
	
	public TextPanel() {
		textArea = new JTextArea();
		textArea.setEditable(false);
		
		setLayout(new BorderLayout());
		add(new JScrollPane(textArea), BorderLayout.CENTER);
	}
	
	public void setText(String text) {
		textArea.setText(text);
	}
	
	public String getText() {
		return textArea.getText();
	}
	
	public void setEditable() {
		textArea.setEditable(true);
	}
	
	public void setUnEditable() {
		textArea.setEditable(false);
	}
	
	public void clearText() {
		textArea.setText(null);
	}
}
