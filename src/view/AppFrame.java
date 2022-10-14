package view;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import commands.CommandsFactory;

public class AppFrame extends JFrame{
	
	private TextPanel textPanel;
	private JFileChooser fileChooser;
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenuItem open, save, exit, edit;
	private CommandsFactory cmdFactory;
	private JPanel panel, createPanel;
	private JButton txt2Speech, line2Speech, createBtn;
	private JLabel titleLabel, authorLabel, lineLabel;
	private JTextField titleField, authorField, lineField;
	
	public AppFrame() {
		
		super("Text2SpeechEditor");
		setLayout(new BorderLayout());
		
		cmdFactory = new CommandsFactory();
		
		textPanel = new TextPanel();
		add(textPanel, BorderLayout.CENTER);
		
		fileChooser = new JFileChooser();
		fileChooser.addChoosableFileFilter(new DocumentFileFilter());
		
		setJMenuBar(createMenuBar());
		
		panel = new JPanel();
		txt2Speech = new JButton("Doc2Speech");
		line2Speech = new JButton("Line2Speech");
		lineLabel = new JLabel("Line: ");
		lineField = new JTextField(3);
		Border innerBorderT2S = BorderFactory.createTitledBorder(null, "Transform To Speech", TitledBorder.CENTER, TitledBorder.TOP);
		Border outerBorderT2S = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		panel.setBorder(BorderFactory.createCompoundBorder(outerBorderT2S, innerBorderT2S));
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel.add(txt2Speech);
		panel.add(line2Speech);
		panel.add(lineLabel);
		panel.add(lineField);
		add(panel, BorderLayout.PAGE_END);
		
		createPanel = new JPanel();
		createBtn = new JButton("Create Document");
		titleLabel = new JLabel("Title: ");
		authorLabel = new JLabel("Author: ");
		titleField = new JTextField(10);
		authorField = new JTextField(10);
		Border innerBorder = BorderFactory.createTitledBorder("Create Document");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		createPanel.setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		createPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		createPanel.add(titleLabel);
		createPanel.add(titleField);
		createPanel.add(authorLabel);
		createPanel.add(authorField);
		createPanel.add(createBtn);
		add(createPanel, BorderLayout.PAGE_START);
		
		txt2Speech.addActionListener(cmdFactory.documentToSpeech(textPanel));
		line2Speech.addActionListener(cmdFactory.lineToSpeech(textPanel, this.lineField));
		createBtn.addActionListener(cmdFactory.createDocument(this.titleField, this.authorField, textPanel ));
		
		setLocationRelativeTo(null);
		setSize(800, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private JMenuBar createMenuBar() {
		menuBar = new JMenuBar();
		
		fileMenu = new JMenu("File");
		
		open = new JMenuItem("Open");
		save = new JMenuItem("Save");
		edit = new JMenuItem("Edit");
		exit = new JMenuItem("Exit");
		
		fileMenu.add(open);
		fileMenu.add(save);
		fileMenu.add(edit);
		fileMenu.add(exit);

		menuBar.add(fileMenu);

		open.addActionListener(cmdFactory.openDocument(AppFrame.this, textPanel, fileChooser));
		save.addActionListener(cmdFactory.saveDocument(AppFrame.this, textPanel, fileChooser));
		edit.addActionListener(cmdFactory.editDocument(textPanel, AppFrame.this));
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		return menuBar;
	}
}
