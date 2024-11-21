//package class13_jdbc_mongo;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.bson.Document;
//
//import com.mongodb.client.FindIterable;
//import com.mongodb.client.MongoClient;
//import com.mongodb.client.MongoClients;
//import com.mongodb.client.MongoCollection;
//import com.mongodb.client.MongoDatabase;
//import com.mongodb.client.model.Filters;
//import com.mongodb.client.model.Updates;
//import com.mongodb.client.result.DeleteResult;
//import com.mongodb.client.result.InsertManyResult;
//import com.mongodb.client.result.UpdateResult;
//
//import class13_jdbc_mysql.EmployeeRecord;
//
//import com.google.gson.Gson;
//
//
//public class MongoDBUtils 
//{
//	
//	public static MongoDatabase connect() 
//	{
//        String connectionString = "mongodb://localhost:27017";
//        MongoClient mongoClient = MongoClients.create(connectionString);
//        
//        return mongoClient.getDatabase("employees_db");
//    }
//	
//	public static boolean insertEmployee( EmployeeRecord employee )
//	{
//		MongoDatabase database = connect();
//		
//        MongoCollection<Document> collection = database.getCollection("employees");
//
//        /*
//        Document document = new Document("name", employee.name())
//                .append("email",  employee.email())
//                .append("department",  employee.department())
//                .append("age",  employee.age())
//                .append("salary",  employee.salary());
//
//        collection.insertOne(document);
//        System.out.println("Document inserted successfully!");
//        */
//        
//        collection.insertOne(Document.parse(new Gson().toJson(employee)) );
//        
//        return true;
//	}
//	
//	public static List<EmployeeRecord> getAllEmployees()
//	{
//		List<EmployeeRecord> employees = new ArrayList<>();
//		
//		Gson gson = new Gson();
//	    
//		MongoDatabase database = connect();
//		MongoCollection<Document> collection = database.getCollection("employees");
//		
//		FindIterable<Document> documents = collection.find();
//		for( Document doc : documents )
//		{
//			EmployeeRecord employee = gson.fromJson( doc.toJson(), EmployeeRecord.class );
//			employees.add( employee );
//			
//		}
//		
//		return employees;
//	}
//	
//	public static EmployeeRecord getEmployeeByName( String name )
//	{
//		MongoDatabase database = connect();
//        MongoCollection<Document> collection = database.getCollection("employees"); // Access the collection
//
//        // Find a single document by name
//        Document document = collection.find(Filters.eq("name", name)).first();
//
//        if (document != null) 
//        {
//            // Convert the BSON document to a JSON string
//			String json = document.toJson();
//			
//			// Use Gson to map the JSON string to the Employee object
//			Gson gson = new Gson();
//			EmployeeRecord employee = gson.fromJson(json, EmployeeRecord.class);
//			
//			return employee;
//        } 
//        else 
//        {
//            System.out.println("No record found with the specified name.");
//        }
//        
//        return null;
//	}
//	
//	public static boolean updateEmplpoyeeSalary( EmployeeRecord employee )
//	{
//		MongoDatabase database = connect();
//        MongoCollection<Document> collection = database.getCollection("employees");
//
//        // Perform the update
//        UpdateResult result = collection.updateMany (
//            Filters.eq("name", employee.name()),
//            Updates.set("salary", employee.salary())
//        );
//
//        return result.getMatchedCount() > 0 && result.getModifiedCount() > 0;
//        
//        // Check if the update was successful (matched and modified at least one document)
////        if (result.getMatchedCount() > 0 && result.getModifiedCount() > 0) 
////        {
////            System.out.println("Document updated successfully!");
////            return true;
////        } 
////        else 
////        {
////            System.out.println("No document found or no changes made.");
////            return false;
////        }
//	}
//	
//	public static boolean deleteEmplpoyeeByName( String name )
//	{
//		MongoDatabase database = connect();
//        MongoCollection<Document> collection = database.getCollection("employees");
//
//        // Perform the update
//        DeleteResult result = collection.deleteMany(Filters.eq("name", name));
//        
////        collection.drop(); // to delete all document in collection
//
//        return result.getDeletedCount() > 0;
//	}
//	
//	public static boolean batchInsertion()
//	{
//		MongoDatabase database = connect();
//        MongoCollection<Document> collection = database.getCollection("employees");
//
//        // Create a list of documents to insert
//        List<Document> employeeList = new ArrayList<>();
//        
//        for (int i = 0; i < 10; i++) 
//        {
//            Document employee = new Document("name", "Employee" + i)
//                    .append("email", "employee" + i + "@example.com")
//                    .append("department", "Department" + (i % 5))
//                    .append("age", 20 + (i % 40))
//                    .append("salary", 5000 + (i % 5000));
//            
//            employeeList.add(employee);
//        }
//
//        // Insert documents in batch
//        InsertManyResult result = collection.insertMany(employeeList);
//
//        // Check if insertion was successful
//        return result.getInsertedIds().size() == employeeList.size();
//	}
//
//	public static boolean batchInsertionGson()
//	{
//		MongoDatabase database = connect();
//        MongoCollection<Document> collection = database.getCollection("employees");
//
//        // Create a list of employee POJOs
//        List<EmployeeRecord> employeeList = new ArrayList<>();
//        Gson gson = new Gson();
//
//        for (int i = 0; i < 10; i++) 
//        {
//           EmployeeRecord emp = new EmployeeRecord(0, 
//            										"Employee" + i , 
//            										"employee" + i + "@example.com",
//            										"Department" + (i % 5),
//            										20 + (i % 40), 
//            										5000 + (i % 5000));
//            
//            employeeList.add( emp );
//        }
//
//        // Convert POJOs to Documents
//        List<Document> documents = new ArrayList<>();
//        
//        for (EmployeeRecord emp : employeeList) 
//        {
//            String json = gson.toJson(emp);
//            Document doc = Document.parse(json);
//            documents.add(doc);
//        }
//
//        // Insert documents in batch
//        InsertManyResult result = collection.insertMany(documents);
//
//        // Check if insertion was successful by comparing the number of inserted documents
//        return result.getInsertedIds().size() == employeeList.size();
//    
//	}
//}
