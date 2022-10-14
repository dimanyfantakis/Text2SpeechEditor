package model;

public abstract class TemplateEncoding implements EncodingStrategy{
	
	private String encodedLines[];
	private char alphabet[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
			's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

	public String[] encode(String[] lines) {
		String lineTemp[] = new String[lines.length];
		for (int z = 0; z < lines.length; z++) {
			String wordTemp = "";
			String wTemp = lines[z].toLowerCase();
			char charTemp[] = new char[lines[z].length()];
			for (int i = 0; i < lines[z].length(); i++) {
				charTemp[i] = wTemp.charAt(i);
			}
			for (char c: charTemp) {
				if(Character.isLetter(c)) {
					for(int j = 0; j < alphabet.length; j++) {
						if(c  == alphabet[j]) {
							wordTemp += alphabet[getEncodedValue(j, alphabet.length)];
						}
					}
				}else {
					wordTemp += c;
				}
			}
			lineTemp[z] = wordTemp;
		}
		encodedLines = lineTemp;
		return encodedLines;
	}
	public abstract int getEncodedValue(int x, int l); 
}
