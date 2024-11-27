package class05_errors_and_exceptions;

public class MyException extends Exception {		// compile-time exception

	public MyException(String message) {
		super(message);			// we are calling the constructor of the super class (Exception class)
								// and passing it the message
		
	}
	
}
