package class13_jdbc_mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BatchProcessing 
{

	public BatchProcessing() {
		
	}
	
	// simple way
	public void insertBatchSimple()
	{
		Random random = new Random();
		
		Supplier<Integer> ageSupplier = () -> 20 + random.nextInt( 61 - 20 );
		Supplier<Double> salarySupplier = () -> Math.floor(new Random().nextDouble( 5000 ));
		
		try (Connection conn = DBUtils.getConnection().get()) 
		{
		    String sql = "INSERT INTO employees (name, email, department, age, salary) VALUES (?, ?, ?, ?, ?)";
		    
		    try (PreparedStatement pst = conn.prepareStatement(sql)) 
		    {
		        conn.setAutoCommit(false); // Disable auto-commit for batch processing
		        
		        for (int i = 0; i < 20; i++) 
		        {
		            pst.setString(1, "Employee" + i);
		            pst.setString(2, "employee" + i + "@example.com");
		            pst.setString(3, "Department-" + i % 5);
		            pst.setInt(4, ageSupplier.get() );
		            pst.setDouble(5, salarySupplier.get() );
		            
		            pst.addBatch(); // Add the statement to the batch
		        }
		        
		        pst.executeBatch(); // Execute all statements in the batch
		        conn.commit(); // Commit the transaction
		        
		        System.out.println( "Batch executed successfully!!!");
		    }
		} 
		catch (SQLException ex) 
		{
		    ex.printStackTrace();
		}
	}
	
	// simple way
	public void insertBatchWithStreams() 
	{
	    Random random = new Random();
	    
	    Supplier<Integer> ageSupplier = () -> 20 + random.nextInt(61 - 20);
	    Supplier<Double> salarySupplier = () -> Math.floor(1000 + random.nextDouble(5000 - 1000) );

	    try (Connection conn = DBUtils.getConnection().get()) 
	    {
	        String sql = "INSERT INTO employees (name, email, department, age, salary) VALUES (?, ?, ?, ?, ?)";
	        
	        try (PreparedStatement pst = conn.prepareStatement(sql)) {
	            conn.setAutoCommit(false); // Disable auto-commit for batch processing
	            
	            // Use IntStream to iterate and process batch using Streams
	            IntStream.range(0, 20).forEach(i -> {
	                try {
	                    pst.setString(1, "Employee" + i);
	                    pst.setString(2, "employee" + i + "@example.com");
	                    pst.setString(3, "Department-" + i % 5);
	                    pst.setInt(4, ageSupplier.get());
	                    pst.setDouble(5, salarySupplier.get());
	                    
	                    pst.addBatch(); // Add the statement to the batch
	                } 
	                catch (SQLException e) 
	                {
	                    throw new RuntimeException(e); // Handle SQL exception inside lambda
	                }
	            });
	            
	            pst.executeBatch(); // Execute all statements in the batch
	            conn.commit(); // Commit the transaction
	            
	            System.out.println("Batch executed successfully!!!");
	        }
	    } 
	    catch (SQLException ex) 
	    {
	        ex.printStackTrace();
	    }
	}

	public void insertBatchWithStreams( int batchSize ) 
	{
	    Random random = new Random();
	    
	    Supplier<Integer> ageSupplier = () -> 20 + random.nextInt(61 - 20);
	    Supplier<Double> salarySupplier = () -> Math.floor(1000 + random.nextDouble(5000 - 1000) );

	    try (Connection conn = DBUtils.getConnection().get()) 
	    {
	        String sql = "INSERT INTO employees (name, email, department, age, salary) VALUES (?, ?, ?, ?, ?)";
	        
	        try (PreparedStatement pst = conn.prepareStatement(sql)) 
	        {
	            conn.setAutoCommit(false); // Disable auto-commit for batch processing
	            
	            // Process in batches of given batchSize
	            IntStream.range(0, 20)
	                .boxed()
	                .collect(Collectors.groupingBy(i -> i / batchSize)) // Group into batches of given batchSize
	                .values()
	                .forEach(batch -> 
	                {
	                    batch.forEach(i -> 
	                    {
	                        try {
	                            pst.setString(1, "Employee" + i);
	                            pst.setString(2, "employee" + i + "@example.com");
	                            pst.setString(3, "Department-" + i % 5);
	                            pst.setInt(4, ageSupplier.get());
	                            pst.setDouble(5, salarySupplier.get());
	                            
	                            pst.addBatch(); // Add to batch
	                        } 
	                        catch (SQLException e) 
	                        {
	                            throw new RuntimeException(e); // Handle SQL exception inside lambda
	                        }
	                    });
	                    
	                    try 
	                    {
	                        pst.executeBatch(); // Execute current batch
	                    } 
	                    catch (SQLException e) 
	                    {
	                        throw new RuntimeException(e); // Handle SQL exception inside lambda
	                    }
	                });

	            conn.commit(); // Commit the transaction
	            System.out.println("Batch executed successfully!!!");
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	}

}
