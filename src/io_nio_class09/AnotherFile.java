package io_nio_class09;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class AnotherFile {
	// this topic is related to java.nio.file.Files 
	public static void main(String[] args) {
		
		Path path = Paths.get("test.txt");		// we store file path in path that we will pass in .write() later.
 		String content = "This is File content" ;
		
		try {
	
			Files.write(path, content.getBytes() , StandardOpenOption.APPEND); // we have to pass it bytes so we call getbytes()  on the string ALSO StandardOpenOption.APPEND will look that if the file is already created then it will append in it rather then creating a new one
			List<String> lines = Files.readAllLines(path) ;  // then we fh it in List
			lines.stream().forEach( str -> System.out.println(str));  //We read it by using streamApi
		
		} catch(IOException e) {
			
			e.printStackTrace() ;
		
		}
		// The above method is the efficient way 
	}
}
