package exercise_class04;

public class HRManager extends Employee implements Tax {

	public HRManager() {
		String name = "hr";
		String designation = "manager";
		double salary = 50000.0d;
		String department = "human resource";
	}
	
	
	@Override
	public void doWork() {
		System.out.println("manage hr");
	}
	
	@Override
	public void deductTax() {
		System.out.println("10% tax deducted.");
	}

}
