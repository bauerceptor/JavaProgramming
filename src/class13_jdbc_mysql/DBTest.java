package class13_jdbc_mysql;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class DBTest {

	public DBTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) 
	{
		
//		Optional<Connection> optConn =  DBUtils.getConnection();
//		System.out.println( optConn );
//		
//		Connection conn = optConn.orElseThrow();
		
//		EmployeeObj emp = new EmployeeObj( "Arshad", "s.arshad@gmail.com", 50, 1000, "IT" );
		
		// insert employee
		 EmployeeRecord record = new EmployeeRecord(0, "Arshad 1", "s.arshad@gmail.com", "IT", 50, 2000);
		 DBUtils.saveEmployee( record );
		
		// get employee by id
//		EmployeeRecord emp = DBUtils.getEmployeeById( 1 ).get();
//		System.out.println( emp );
		
		// get all employees
//		List<EmployeeRecord> employees = DBUtils.getAllEmployees();
//		System.out.println( employees );
//		
//		boolean isUpdate = DBUtils.updateEmployee( EmployeeRecord.createWithNameAndEmail("Arshad", "newemail@email.com") );
//		System.out.println( isUpdate );
		
		// insertion as batch
//		BatchProcessing batch = new BatchProcessing();
//		batch.insertBatchWithStreams( 5 );
				
	}

}
