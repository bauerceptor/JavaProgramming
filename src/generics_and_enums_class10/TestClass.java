package generics_and_enums_class10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestClass {

	
	public static void main(String args[]) {
//		ArrayList<E> list = new ArrayList();	// generic list of objects
//		list.add("string");
//		list.add(123);
//		list.get(0);	// list.get returns an object (so it is generic)
		
		// using generic classes below
		Printer<String> stringPrinter = new Printer("hello");
		stringPrinter.print();
		
		Printer<Integer> ip = new Printer(10);
		ip.print();
		
		Printer2<String, Integer> p = new Printer2("Some String", 2200);
		p.print();
		
		// using generic arrays through a generic method (declared below this main method)
		Integer[] nums = {1, 2, 3, 4};
		printArray(nums);
		
		String[] shells = {"fish", "bash", "zsh"};
		printArray(shells);
		
		
//		Person p1 = new Person("Khan", 12);
//		Person p2 = new Person("Ali", 20);
//		System.out.println( p1.compareTo(p2) );
		
		genMethod(12);
		genMethod(3.14156);
//		genMethod("ships and seas");	// error
//		genMethod2(90.4);	// error
//		genMethod2(832);	// error
//		genMethod2("some random string");	// error
		
		
		List<Employee> emps1 = Arrays.asList( new Employee(), new Admin() );			// when we know this list will contain Employee type data
		printList(emps1);
		
		// here, ? is a wild card
		List<?> emps2 = Arrays.asList( new Employee(), new Admin(), "abcd"  );	// when we don't know which type of data this list2 will contian
//		emps2.add( "abcd");		// error: type unknown. We cannot write to a generic list type because we don't know the actual type of data
		
		
		List<? super Admin> emps3 = Arrays.asList( new Admin() );	// lower bound (more generalized)
//		emps3.add( new Admin() );	// here we can add items to emps3 because we are more sure of its item types than before because we are using lower bound here
		
		List<? extends Employee> emps4 = Arrays.asList( new Employee() );	// upper bound
//		emps4.add( new Admin() );	// error: type unknown because upper bound is less generalized
		
		
//		List<? extends Employee & GenericInterface<String>> emps5 = new ArrayList();	// a list that contains objects/items that are both Employee type and implement GenericInterface
		
		
		
		
		// ------------- enums --------------
		Shirt s = new Shirt();
		s.setColor(ShirtColor.WHITE);
		
		ShirtColor color = s.getColor();
		System.out.println( color.name() );		// enum has a .name() method
		String c = color.toLowerCase();			// method defined in enum
		System.out.println(c);
		
		System.out.println(color.getColorCode());	// abstract method defined and implemented in enum
		System.out.println(color.getRate());
	
	
	}
	
	
	public static <T> void printArray( T[] t ) {
		System.out.println( Arrays.toString(t) );
	}
	
	public static <T extends Number> void genMethod(T t) {		// upper bound : Number or its child classes only
		System.out.println(t);		// t is bounded to represent Number types only
	}
	
//	public static <T super Number> void genMethod2(T t) {		// lower bound : Number or its super (parent) classes only
//		System.out.println(t);		// t is bounded to represent Number types only
//	}
	
	
	// wild card methods below
	public static void printList( List<Employee> emps ) {
		System.out.println(emps);
	}
	
	public static void printListWildCard( List<?> list ) {
		System.out.println(list);
	}
	
}
