package error_handling_class05;

import java.io.FileNotFoundException;

public class ExceptionTest3 {
	
	public ExceptionTest() {
		FileUtils fu = new FileUtils();
		
		try {
			fu.openFile("./");
			
//			fu.checkName(null);
		
			try {
				fu.checkName(null);
				
				
			} catch (MyException e) {
				e.printStackTrace();
				
			}
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
			
		} catch(ArithmeticException e) {
			e.getMessage();
			
		}
	}
}
