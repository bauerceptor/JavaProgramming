package class05_error_handling;

import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileOutputStream;

public class ExceptionTest2 {
	
//	public class ExceptionTest {
//		public ExceptionTest() {
//			testMethod();		
//		}
//	}
	
	public class ExceptionTest {
		public ExceptionTest() {
			try {
				fos.openFile("./");
				
			} catch(FileNotFoundException e) {
				e.printStackTrace();
				
			}	
		}
	}
	
	
	public void testMethod() throws FileNotFoundException {
		FileOutputStream fos = new FileOutputStream(new File("../home/file.txt"));
		
	}
	
	
	
	public static void main(String args[]) {
			
	
}
