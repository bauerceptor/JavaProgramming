package class05_error_handling;

import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileOutputStream;

public class ExceptionTest {
	public static void main(String args[]) {
		
		try {
			int x = 10;
			int y = x / 0;		// buggy code
			System.out.println(y);
			
		} catch (ArithmeticException exp) {
			System.out.println("Dividing by zero is not allowed.");
			System.out.println(exp.getMessage());
			
		} catch (Exception exp) {
			System.out.println( exp.getMessage());
		
		}
		
		
		
		try {
			FileOutputStream fos = new FileOutputStream( new File("./home/myfile.txt"));
			fos.open();
		
		} catch(FileNotFoundException fnfex) {
			System.out.println("file does not exist");
			fnfex.printStackTrace();    // gives complete info about stack trace of error
		
		} finally {
			fos.close();
		
		}
	
	
	}
	
}
