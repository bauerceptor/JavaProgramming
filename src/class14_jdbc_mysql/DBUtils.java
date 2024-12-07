package class14_jdbc_mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class DBUtils {
	
	private static final String jdbcURL = "jdbc:mysql://localhost:3306/test_db";
//    private static final String username = "root";
//    private static final String password = "";

    private static final String username = "flamingo";
    private static final String password = "Riphah@00";
    
	public DBUtils() {
		// TODO Auto-generated constructor stub
	}
	
	public static Optional<Connection> getConnection()
	{
		try  
		{
			Connection connection = DriverManager.getConnection(jdbcURL, username, password);
			Optional<Connection> conn = Optional.ofNullable( connection );
            return conn;
        } 
		catch (Exception e) 
		{
            e.printStackTrace();
        }
		
		return Optional.empty();
	}
	
	public static boolean saveEmployee( EmployeeObj emp )
	{
		String insertSQL = "INSERT INTO employees (name, email, age, department, salary) VALUES (?, ?, ?, ?, ?)";
		
		try(
				Connection conn = getConnection().get(); 
				PreparedStatement preparedStatement = conn.prepareStatement(insertSQL)) 
		{
		
            preparedStatement.setString(1, emp.getName());
            preparedStatement.setString(2, emp.getEmail());
            preparedStatement.setInt(3, emp.getAge());
            preparedStatement.setString(4, emp.getDepartment());
            preparedStatement.setDouble(5, emp.getSalary());
            
            preparedStatement.executeUpdate();

            System.out.println("Record inserted successfully!");
            return true;			
        } 
		catch (Exception e) 
		{
            e.printStackTrace();
        }		
		
		return false;
	}
	
	public static boolean saveEmployee( EmployeeRecord emp )
	{
		String insertSQL = "INSERT INTO employees (name, email, age, department, salary) VALUES (?, ?, ?, ?, ?)";
		
		try(
				Connection conn = getConnection().get(); 
				PreparedStatement preparedStatement = conn.prepareStatement(insertSQL)) 
		{
		
            preparedStatement.setString(1, emp.name());
            preparedStatement.setString(2, emp.email());
            preparedStatement.setInt(3, emp.age());
            preparedStatement.setString(4, emp.department());
            preparedStatement.setDouble(5, emp.salary());
            
            preparedStatement.executeUpdate();

            System.out.println("Record inserted successfully!");
            return true;			
        } 
		catch (Exception e) 
		{
            e.printStackTrace();
        }		
		
		return false;
	}

	public static Optional<EmployeeRecord> getEmployeeById( int id )
	{
		String sql = "select * from employees where id = ?";
		
		try(
				Connection conn = getConnection().get();
				PreparedStatement pst = conn.prepareStatement( sql )
				)
		{
			
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
			//int id, String name, String email, String department, int age, double salary) 
			
			if( rs.next() )
			{
				EmployeeRecord rec = new EmployeeRecord( 
											rs.getInt("id"), 
											rs.getString("name"), 
											rs.getString("email"), 
											rs.getString("department"), 
											rs.getInt("age"),
											rs.getDouble("Salary"));
				
				return Optional.ofNullable( rec );
			}
			
			
		}catch(Exception ex )
		{
			ex.printStackTrace();
		}
		
		return Optional.empty();
	}
	
	public static List<EmployeeRecord> getAllEmployees()
	{
		String sql = "select * from employees";
		
		List<EmployeeRecord> employees = new ArrayList<>();
		
		try(
				Connection conn = getConnection().get();
				PreparedStatement pst = conn.prepareStatement( sql )
				)
		{
			
			ResultSet rs = pst.executeQuery();
			
			while( rs.next() )
			{
				EmployeeRecord rec = new EmployeeRecord( 
											rs.getInt("id"), 
											rs.getString("name"), 
											rs.getString("email"), 
											rs.getString("department"), 
											rs.getInt("age"),
											rs.getDouble("Salary"));
				
				employees.add( rec );
			}
			
			
		}
		catch(Exception ex )
		{
			ex.printStackTrace();
		}
		
		return employees;
	}
	
	public static boolean updateEmployee( EmployeeRecord employee )
	{
		 String updateSQL = "UPDATE employees SET email = ? WHERE name = ?";

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(updateSQL)) 
        {

            preparedStatement.setString(1, employee.email());
            preparedStatement.setString(2, employee.name());
            int rowsUpdated = preparedStatement.executeUpdate();

            System.out.println(rowsUpdated + " record(s) updated!");
            
            return true;

        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        
        return false;
	}
	
}
