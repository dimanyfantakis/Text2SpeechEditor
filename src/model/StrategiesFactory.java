package model;

public class StrategiesFactory {
	
	private String encodingStrategy;
	private String lines[];
	private int line;
	private Document document;
	private EncodingStrategy encStrategy;
	
	public StrategiesFactory(String encodingStrategy, String lines[], Document doc) {
		this.encodingStrategy = encodingStrategy;
		this.lines = lines;
		this.line = 0;
		this.document = doc;
		createStrategy(encodingStrategy, lines);
	}
	public StrategiesFactory(String encodingStrategy, String lines[], int line, Document doc) {
		this.encodingStrategy = encodingStrategy;
		this.lines = lines;
		this.line = line;
		this.document = doc;
		createStrategy(encodingStrategy, lines);
	}
	
	public void createStrategy(String encodingStrategy, String lines[]) {
		switch (encodingStrategy) {
			case "atbash":
				document.tuneEncodingStrategy(new AtBashEncoding(), lines, line);
				break;
			case "rot13":
				document.tuneEncodingStrategy(new Rot13Encoding(), lines, line);
				break;
			default:
				return;
		}
	}
}
