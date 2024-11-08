package io_nio_class09;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileTest {
	public static void main(String[] args) throws Exception{
		// to write file we need file writer
//		FileWriter fw = new FileWriter("test.txt") ; // test.txt is its name  File Writer constructor also throws error so we need to handle it
		
//		FileWriter fw = null ;		// see notes 
		
//		so we do it this way
		try ( FileWriter fw = new FileWriter("test.txt") ) {  // if we initialize it this way then we don't have to close it will know it self taht it has to close 
//			FileWriter fw = new FileWriter("test.txt") ; // see notes
			fw.write("Hello World");                     // to write we use fw.write
			fw.write( System.lineSeparator());  // we should always use lineseperator() to go to next line rather then using this \n.
			fw.write("Its Line 2");
			fw.write( System.lineSeparator());
			fw.close();   // we need to close the stream only then the input data will be stored in the file.
			System.out.println("done");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
//			fw.close();		// we initialized it with try so we don't have to close it now here.
		}
		
		readFile() ;
	}
	
	private static void readFile() {
		
		try (FileReader fr = new FileReader("test.txt")){  // we also need to close this stream to after reading that's why we are initil
			// It will read text by char by char.
			int c ;
			while( ( c = fr.read() ) != -1 ) {  // Here we use -1 because the read() will read the file even after reaching the end but by !=-1, read() will return -1 when it reaches that will end the while loop and the reading process will end
				
				System.out.print( (char)c ) ; // it will read in binary so we will type cast in char   ALSO ensure that you DONOT use printLN as it will NOT print in one line. 
			
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}
