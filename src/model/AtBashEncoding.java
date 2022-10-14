package model;

public class AtBashEncoding extends TemplateEncoding{

	public int getEncodedValue(int x, int l) {
		return ((l-1) - x);
	}
}
