package model;

public class Document {
	
	private String author;
	private String title;
	private String dateCreated;
	private String dateSaved;
	private String documentLines[];
	private String encodedDocumentLines[];
	private Text2SpeechAPI txt2Speech = new Text2SpeechAdapter();
	private Text2SpeechAPI fakeTxt2Speech = new FakeText2Speech();
	
	public Document(String author, String title, String dateCreated) {
		this.author = author;
		this.title = title;
		this.dateCreated = dateCreated;
	}
	public Document() {
		
	}
	public Document(Document doc) {
		this.documentLines = doc.documentLines;
		this.dateSaved = doc.dateSaved;
	}
	public void playDoc(String lines[]) {
		for(String l: lines) {
			txt2Speech.play(l);
			fakeTxt2Speech.play(l);
		}
	}
	public void playDocReverse(String lines[]) {
		for(String l: lines) {
			String s = "";
			String words[] = l.split(" ");
			for(int i = words.length-1; i>=0; i--) {
				s += words[i];
				if(i > 0) {
					s += " ";
				}
			}
			txt2Speech.play(s);
			fakeTxt2Speech.play(s);
		}
	}
	
	public void playLine(String line) {
		txt2Speech.play(line);
		fakeTxt2Speech.play(line);
	}
	
	public void playLineReverse(String line) {
		String s = "";
		String words[] = line.split(" ");
		for(int i = words.length-1; i>=0; i--) {
			s += words[i];
			if(i > 0) {
				s += " ";
			}
		}
		txt2Speech.play(s);
		fakeTxt2Speech.play(s);
	}
	
	public void tuneEncodingStrategy(EncodingStrategy encStrategy, String lines[], int line) {
		this.encodedDocumentLines = encStrategy.encode(lines);
		if(line == 0) {
			playDoc(encodedDocumentLines);
		}else {
			playLine(encodedDocumentLines[line - 1]);
		}
	}
	
	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getDateSaved() {
		return dateSaved;
	}

	public void setDateSaved(String dateSaved) {
		this.dateSaved = dateSaved;
	}

	public String[] getDocumentLines() {
		return documentLines;
	}

	public void setDocumentLines(String[] documentLines) {
		this.documentLines = documentLines;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public String getTitle() {
		return title;
	}

	public String[] getFakeT2SContents() {
		return fakeTxt2Speech.getLines();
	}
}
