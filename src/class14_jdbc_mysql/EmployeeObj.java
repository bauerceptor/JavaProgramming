package class14_jdbc_mysql;

public class EmployeeObj {

	private int id;
	private String name;
	private String email;
	private int age;
	private double salary;
	private String department;
	
	public EmployeeObj() {
		// TODO Auto-generated constructor stub
	}
	
	public EmployeeObj(String name, String email, int age, double salary, String department) {
		super();
		this.name = name;
		this.email = email;
		this.age = age;
		this.salary = salary;
		this.department = department;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "EmployeeObj [id=" + id + ", name=" + name + ", email=" + email + ", age=" + age + ", salary=" + salary
				+ ", department=" + department + "]";
	}
	
}
