package class09_io_nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String args[]) {
		
//		Difference between Byte Streams and Character Streams
//		---------------------------------------------------------------------------------------------------------------------------

//		Scanner class
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter your name: ");
		String name = scanner.nextLine();
		System.out.printf("Hello, %s! Welcome to Java I/O.%n", name);
		
//		System.out.printf("The number you entered is: %d", input);

//		Study the topics below from JavaDocs 
//		FileWrite
//		FileWriter with append mode
//		FileReader
//		BufferedWriter
//		BufferedReader
//		System.lineSeparator()
//		Exception Handling
//		Closable Objects
		
//		NIO
//		---------------------------------------------------------------------------------------------------------------------------
		Path path = Paths.get("nio_example.txt");
        try {
            Files.write(path, "Hello, NIO!".getBytes());
            String content = Files.readString(path);
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
//        -------------------------------------------------------------------------------------------------------------------------------
//        List<String> lines = Files.readAllLines(filePath); // memory efficient 
//        -------------------------------------------------------------------------------------------------------------------------------
        // Read the entire file content as a String 
//        String content = Files.readString(filePath);
//
//        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
//        	String line;
//            while ((line = reader.readLine()) != null) {
//            	System.out.println(line); // Print each line
//            }
//        } catch (IOException e) {
//        	e.printStackTrace(); // Handle the IOException
//        }
//        Files.write with append mode
//        -------------------------------------------------------------------------------------------------------------------------------
//        Files.write(filePath, lines, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
//        -------------------------------------------------------------------------------------------------------------------------------
//        Serialization and Deserialization
		
        
        
        
        
		
	}
	
	
	
}
