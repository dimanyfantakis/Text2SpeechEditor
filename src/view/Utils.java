package view;

public class Utils {
	public static String getFileExtension(String name) {
		
		int pointIndex = name.lastIndexOf(".");
		
		if (pointIndex == -1) {
			//no dot in the file name
			return null;
		}else if (pointIndex == name.length() -1) {
			//file has no extension
			return null;
		}else {
			//return 1st char after dot to end of filename
			return name.substring(pointIndex+1, name.length());
		}
	}
}
