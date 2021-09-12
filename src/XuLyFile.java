import java.io.File;

public class XuLyFile {

	public File docFile(String fileName) {
		File currentFolder = new File("");
		String currentPath = currentFolder.getAbsolutePath();
		File file = new File(currentPath + "\\" + fileName);
		
		return file; 
	}
	
}
