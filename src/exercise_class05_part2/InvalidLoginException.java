package exercise_class05_part2;

public class InvalidLoginException extends Exception {

	public InvalidLoginException(String msg) {
		super(msg);
		System.out.println(msg + "\n\tRetry again.");
	}

}
