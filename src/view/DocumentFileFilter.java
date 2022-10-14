package view;
import java.io.File;
import javax.swing.filechooser.FileFilter;
import view.Utils;

public class DocumentFileFilter extends FileFilter {
	public boolean accept(File file) {
		
		//Browses folders
		if(file.isDirectory()) {
			return true;
		}
		
		String name = file.getName();
		
		String extension = Utils.getFileExtension(name);
		
		if(extension == null) {
			return false;
		}
		if(extension.equals("txt")) {
			return true;
		}
		return false;
	}

	public String getDescription() {
		return "Document files (*.txt)";
	}
}
