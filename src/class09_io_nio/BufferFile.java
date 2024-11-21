package class09_io_nio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferFile {
	public static void main(String[] args) throws Exception{
		
		// we will wrap filewriter in bufferwriter
		try (BufferedWriter fw = new BufferedWriter(new FileWriter("test.txt"))){  // if we initialize it this way then we don't have to close it will know it self taht it has to close 
//			FileWriter fw = new FileWriter("test.txt") ; // see notes
			fw.write("Hello World");                     // to write we use fw.write
			fw.write( System.lineSeparator());  // we should always use lineseperator() to go to next line rather then using this \n.
			fw.write("Its Line 2");
			fw.write( System.lineSeparator());
			fw.close();   // we need to close the stream only then the input data will be stored in the file.
			System.out.println("done") ;
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
//			fw.close();		// we initialized it with try so we don't have to close it now here.
		}
		
//		readFile();
	}
	
	private static void readFile() {
		
		try (BufferedReader fr = new BufferedReader(new FileReader("test.txt"))) { // we also need to close this stream to after reading that's why we are initil
			// It will read text by char by char.
			String line = null ;
			while( ( line = fr.readLine() ) != null ) {  // Here we use null because the read() will read the file even after reaching the end but by !=null, read() will return null when it reaches end that will end the while loop and the reading process will end
				System.out.println( line ) ;  
			}
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
