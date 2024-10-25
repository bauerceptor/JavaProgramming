package collections_class07;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {
	public static void main(String args[]) {
		
//		String[] names1 = {"Zahid", "Bilal", "Ali"};
//		someMethod(names1);
		
		
		List<String> names = Arrays.asList("Ali", "Salman", "Asif", "Khalid");
		names.stream().forEach( System.out::println );		// forEach method can take a method as argument which will call that argument method as many times as the loop runs
		// or (both are same)
		for (String n : names) {
			System.out.println(n);
		}
		
		// warning: method chaining below
		names.stream().filter( (n) -> n.equals("Ali") ).collect(Collectors.toList());
		
		
		
		// exercise: filter odd numbers out and return only even numbers
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		List<Integer> evens = numbers.stream().filter( (n) -> n % 2 == 0 ).collect(Collectors.toList());
		List<Integer> odds = numbers.stream().filter( (n) -> n % 2 != 0 ).collect(Collectors.toList());
		
		System.out.println(evens);
		System.out.println(odds);
		
		
		
	}
	
	public static void someMethod(String[] arr) {
		
	}
	
	public static void setNames(String... arr) {		// use ... to tell that this argument takes several values independently and then this method itself treats those arguments as an array of name "arr" specified in the argument
		
	}
	
	public static void numberMethod(int... arr) {		// there can be only one variable argument
//		numberMethod(int... arr1, int... arr2)		// this is incorrect
	}
	
	public static void numberMethod2(int i , int... arr) {	// variable argument is always the last argument
		// numberMethod2(int... arr, int i)		// this is incorrect
	}
}