package class14_jdbc_mysql;

public record EmployeeRecord(int id, String name, String email, String department, int age, double salary) 
{
	public static EmployeeRecord createWithNameAndEmail( String name, String email )
	{
		return new EmployeeRecord(0, name, email, null, 0, 0);
	}
	
	public static EmployeeRecord createWithNameAndSalary( String name, int salary )
	{
		return new EmployeeRecord(0, name, null, null, 0, salary);
	}

//	public String name() {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
