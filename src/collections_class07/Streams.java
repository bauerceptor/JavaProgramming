package collections_class07;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Streams {
	public static void main(String args[]) {
		
//		String[] names1 = {"Zahid", "Bilal", "Ali"};
//		someMethod(names1);
		
		
		List<String> names = Arrays.asList("Ali", "Salman", "Asif", "Khalid");
		// we cannot change list items using forEach, we can just iterate through it or print it
		names.stream().forEach( System.out::println );		// forEach method can take a method as argument which will call that argument method as many times as the loop runs
		// or (both are same)
		for (String n : names) {
			System.out.println(n);
		}
		
		// warning: method chaining below
		names.stream().filter( (n) -> n.equals("Ali") ).collect(Collectors.toList());
		names.stream().filter( n -> n.length() > 3 ).forEach(System.out::println);		// :a1: filtering strings of length greater than 3
		
		
		// exercise: filter odd numbers out and return only even numbers
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		List<Integer> evens = numbers.stream().filter( (n) -> n % 2 == 0 ).collect(Collectors.toList());
		List<Integer> odds = numbers.stream().filter( (n) -> n % 2 != 0 ).collect(Collectors.toList());
		
		System.out.println(evens);
		System.out.println(odds);
		
		
		// map is used to perform some operation on List elements and transform them through that operation
		names.stream().map(String::toUpperCase).forEach(System.out::println);;	// String class passed as reference and we are calling the toUpperCase function of String class
		// ^ function passed as reference syntax is:	Class::function, function is written without brackets ()
		numbers.stream().map( n -> n*n );	// square of numbers
		
		
		
		// sorting through streams
		names.stream().sorted().forEach(System.out::println);
		names.stream().sorted( Comparator.comparingInt(String::length) );		// sorting strings based on their length
		
		
		// but sorting custom Classes requires comparators
		List<Person> persons = Arrays.asList( new Person("Michaelangelo", 20), new Person("James", 10), new Person("Alex", 30), new Person("Bill", 20));
		persons.stream().sorted( Comparator.comparingInt( person -> person.getAge() ));		// sorting persons based on their age (custom class sorting)
//		persons.stream().sorted( Comparator.comparingInt( person -> person.getName().length() ) ).forEach(System.out::println);		// sorting persons based on the length of their name
		persons.stream()
						.sorted( Comparator.comparing(person -> ((Person) person).getName()).reversed() )		// sorting names in reverse order, reversed() is used after comparing()
						.forEach(System.out::println);
		
		// comparing twice, first by age and then if two persons have same age then we sort them by name
		persons.stream()
				.sorted( Comparator.comparing( (Person person) -> person.getAge() ).thenComparing( person -> person.getName() ))
				.forEach(System.out::println);
		
		
		// :a2:	collecting a list of squares of integers that are less than 5
		List<Integer> nums = numbers.stream().filter( n -> n < 5).map( n -> n*n ).collect(Collectors.toList());
		System.out.println(nums);
		
		
		
		// reduce
		int result = numbers.stream().reduce(0, (x, y) -> x + y);
		// or
		int result2 = numbers.stream().reduce(0, Integer::sum);
		Optional<Integer> minValue = numbers.stream().reduce( (x, y) -> (x<y) ? x : y );
		System.out.println(result);
		System.out.println(minValue);
		
		
		// same thing done in 3 different ways
		int totalAge = persons.stream().map(person -> person.getAge()).reduce(0, (x,y) -> x+=y);
		int totalAge2 = persons.stream().map(Person::getAge).reduce(0, Integer::sum);
		int totalAge3 = persons.stream().mapToInt(Person::getAge).sum();
		System.out.println(totalAge);
		
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