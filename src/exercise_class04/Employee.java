package exercise_class04;

public abstract class Employee {
	String name;
	String designation;
	double salary;
	String department;
	
//	public Employee(String name, double salary) {
//		this.name = name;
//		this.salary = salary;
//	}
	
	public Employee() {
		
	}
	
	
	public abstract void doWork();
}
