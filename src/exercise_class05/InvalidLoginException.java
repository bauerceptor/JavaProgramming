package exercise_class05;

public class InvalidLoginException extends Exception {

	public InvalidLoginException(String msg) {
		super(msg);
		System.out.println(msg + "\n\tRetry again.");
	}

}
