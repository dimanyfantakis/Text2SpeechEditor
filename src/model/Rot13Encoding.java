package model;

public class Rot13Encoding extends TemplateEncoding{
	
	public int getEncodedValue(int x, int l) {
		return ((x + 13) % l);
	}
}