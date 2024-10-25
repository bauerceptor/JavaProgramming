package error_handling_class05;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileUtils {
	
	public FileUtils() {
		
	}
	
//	public void openFile(String filePath) {
//		try {
//			FileOutputStream fos = new FileOutputStream(new File("../home/file.txt"));
//			
//		} catch (FileNotFoundException e) {
//			System.out.println("File not found...");
//		
//		}
//	}
	
//	public void openFile(String filePath) throws FileNotFoundException {
//			FileOutputStream fos = new FileOutputStream(new File("../home/file.txt"));
//
//	}
	
	public void openFile(String filePath) throws FileNotFoundException, ArithmeticException {
		FileOutputStream fos = new FileOutputStream(new File("../home/file.txt"));
		// the FileOutputStream constructor above (in blue) itself throw exception instance
		// like we did below for the MyException
		int x = 10;
		int y = x / 0;
	}
	
	public void checkName(String name) throws MyException {
		if (name == null || name.length() < 5 || name.length() > 15) {
			throw new MyException("Name length should be greater than 5");
		}
	}
}5
