package class05_error_handling;

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
