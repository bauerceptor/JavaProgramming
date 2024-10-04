package class_2;

public class SoftwareEngineer extends Employee implements Tax {

	public SoftwareEngineer() {
		String name = "developer";
		String designation = "engineer";
		double salary = 60000.0d;
		String department = "technology";
	}
	
	
	@Override
	public void doWork() {
		System.out.println("develop software");
	}
	
	@Override
	public void deductTax() {
		System.out.println("20% high tax deducted.");
	}

}
