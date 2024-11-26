package exercise_class05;

public class LoginClass {

	public static boolean login(String name, String password) throws InvalidLoginException {
		
		if(name != "admin" || password != "admin")
			throw new InvalidLoginException("-- Invalid username or password --");
		else
			return true;
		
	}
	
	public static void main(String args[]) {
		try {
			login("admin", "admin");
			System.out.println("You have successfully logged in as administrator");

		} catch (InvalidLoginException e) {
			e.printStackTrace();
			e.getMessage();
		}
		
		
		try {
			login("user", "user");
			System.out.println("You have successfully logged in as administrator");
			
		} catch (InvalidLoginException e) {
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}
	
}
