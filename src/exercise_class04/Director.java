package exercise_class04;

public class Director extends Employee implements Tax, Allowance{

	public Director() {
		String name = "dir";
		String designation = "director";
		double salary = 90000.0d;
		String department = "board";
	}
	
	
	@Override
	public void doWork() {
		System.out.println("direct company");
	}
	
	@Override
	public void deductTax() {
		System.out.println("30% highest tax deducted.");
	}
	
	@Override
	public void carAllowance() {
		System.out.println("get car allowance");
	}

}
