package class10_generics_and_enums;


public class Admin extends Employee {

	public Admin() {
		String name = "person";
		String designation = "admin";
		double salary = 20000.0d;
		String department = "administration";
	}
	
	
	@Override
	public void doWork() {
		System.out.println("perform administration");

	}

}
