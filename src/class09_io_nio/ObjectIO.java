package class09_io_nio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectIO {
	public static void main(String[] args) {
		Person p = new Person("Ali", 34); 
		
		try {
			
		BufferedOutputStream bos = new BufferedOutputStream( new FileOutputStream("person.ser")) ;  // we use ser extenstion BTW we can use any extenstion.
		ObjectOutputStream os = new ObjectOutputStream( bos ) ;
		os.writeObject(p) ;
		os.close();
		
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("person.ser")) ; 
		ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream( bis )) ;
		
		Person p1 = (Person)ois.readObject() ;		// remember we should have Person class to read it OR Person class should be present on the computer on which we 
		System.out.println(p1) ;
		
		} catch(IOException e) {
			e.printStackTrace() ;
		} catch(ClassNotFoundException e) {
			e.printStackTrace() ;
		} 
	}
}
