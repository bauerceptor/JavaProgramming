package class11_functional_interfaces;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Sample {

	
	public static void main(String[] args) {
		
		/*
		// ************ Predicate<T> ********************
		// Tests a condition on a given input, returning true or false.
		
		// Tests if String is longer than 5 char long
		Predicate<String> isLongerThan5 = str -> str.length() > 5;
		System.out.println( isLongerThan5.test("Hello") );
		System.out.println( isLongerThan5.test("Hello World") );
		
		// Test if given number is odd or even
		Predicate<Integer> isEven = n -> n % 2 == 0;
		System.out.println( isEven.test(10) );
		
		// Using with List and Streams API
		List<Integer> nums = Arrays.asList( 3,4,6,7,10,11 );
		List<Integer> evenNumbers = nums.stream().filter( isEven ).collect( Collectors.toList() );
		System.out.println( evenNumbers );
		
		// ******************* Function<T, R> *****************************
		//Takes an input of type T and produces a result of type R.
		
		// Check String length
		Function<String, Integer> lengthOfString = str -> str.length();
		System.out.println( lengthOfString.apply("Hello" ) );
		
		// Create a Function<Integer, Integer> to calculate the square of a number
		Function<Integer, Integer> square = num -> num * num;
		System.out.println( square.apply(10) );
		
		//Using with List and Streams
		List<Integer> nums = Arrays.asList( 3,4,6,7,10,11 );
		List<Integer> squares = nums.stream().map( square ).collect(Collectors.toList() );
		System.out.println( squares );
				
		// ************************* Consumer<T> ****************************
		// Performs an operation on a given input of type T, returning nothing.
		Consumer<String> print = str -> System.out.println("Hello, " + str + "!");
		print.accept("Ali");  // Hello, Ali!
		
		// Write a Consumer<Integer> to print a number squared.
		Consumer<Integer> printSquare = num -> System.out.println(num * num);
		printSquare.accept(4);  // 16
		
		// Using with List and Streams
		Arrays.asList( "Ali", "Salman" ).forEach( print );		
		
		// ********************** Supplier<T> **************************
		// Takes no input and produces a result of type T.
		Supplier<Double> randomNumber = () -> Math.random();
		System.out.println( randomNumber.get() );
		
		Supplier<String> greetSupplier = () -> "Hello, World!";
		System.out.println(greetSupplier.get());  // Hello, World!
		
		// Using with Streams
		// Generate List of 10 random numbers
		List<Double> randomNumbers = Stream.generate( randomNumber ).limit( 10 ).collect( Collectors.toList() );
		System.out.println( randomNumbers );
		
		//Generate random numbers from 0 to 100
		Supplier<Integer> numbersTill100 = () -> new Random().nextInt( 100 );
		List<Integer> randomInts = Stream.generate( numbersTill100 ).limit(10).collect( Collectors.toList() );
		System.out.println( randomInts );
				
		// ******************* BinaryOperator<T> ************************
		// A BiFunction where both input types and the output type are the same
		BinaryOperator<Integer> sum = (x,y) -> x + y;
		System.out.println( sum.apply(20, 40) );
		
		// Write a BinaryOperator<String> that concatenates two strings with a space between them.
		BinaryOperator<String> concatStrs = (firstName, lastName) -> firstName + " " + lastName;
		System.out.println( concatStrs.apply("Ali", "Khan") );
		
		// Using with List and Streams. 
		// With Stream, BinaryOperator is often used with the reduce method, 
		// which applies the operator across all elements in the stream to produce a single result.
		 
		// Calculate sum of all numbers of List of Integers
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		BinaryOperator<Integer> sumOperator = (x,y) -> x + y;
		Integer res = numbers.stream().reduce( 0, sumOperator );
		System.out.println( res );
		
		// Get maximum number from the List of Integers
		BinaryOperator<Integer> maxNum = (x,y) -> x > y ? x : y;
		System.out.println( numbers.stream().reduce( Integer.MIN_VALUE, maxNum ) );
				
		// ************************** BiPredicate<T, U> ***********************************
		// Tests a condition on two inputs, returning true or false
		
		// Test String with provided length
		BiPredicate<String, Integer> isValidStr = ( str, length ) -> str.length() >= length;
		List<String> names = Arrays.asList( "Ali", "Khan", "Af" );
		List<String> validNames = names.stream().filter( (str) -> isValidStr.test(str, 3) ).collect(Collectors.toList() );
		System.out.println( validNames );
				
		// ************************* BiFunction<T, U, R> **********************************
		// Takes two inputs of types T and U and returns a result of type R
		
		// Combine two strings and return length
		BiFunction<String, String, Integer> combinedLength = (firstName, lastName) -> firstName.concat(lastName).length();
		System.out.println( combinedLength.apply("Hello", "World") );
		
		// Exercise: Write a BiFunction<Integer, Integer, String> to return "Equal" if the numbers are equal and "Not Equal" otherwise.
		
		// Using with List and Streams
		List<Person> persons = Arrays.asList(
				new Person("Salman", "Khan", "male"),
				new Person("Arshad", "Ali", "male"),
				new Person("Hassan", "Ijaz", "male"),
				new Person("Sana", "Khan", "female"));
		
		//calculate length for each person's full name
		List<Integer> namesLength = persons.stream().map(person -> combinedLength.apply(person.getFirstName(), person.getLastName()) ).collect( Collectors.toList() );
		System.out.println( namesLength );
		
		//Exercise: Check in Persons' list, if gender is Male, Append Mr. or Mrs with the name
		Function<Person, Person> changeName = p -> { 
			String prefix = p.getGender().equals("male") ? "Mr." : "Mrs";
			p.setFirstName( prefix + p.getFirstName() );
			return p; 
		};
		
		List<Person> newPersonsList = persons.stream().map( changeName ).collect( Collectors.toList() );
		System.out.println( newPersonsList );
		
		// ************************** BiConsumer<T, U> *********************************
		// Performs an operation on two inputs of types T and U, returning nothing
		
		BiConsumer<String, Integer> printKeyValue = (key, value) -> System.out.println(key + ": " + value);
		printKeyValue.accept("Age", 30);  // Age: 30
				
		BiConsumer<String, String> printFormatted = (first, last) -> System.out.println("First Name: " + first + ", Last Name: " + last);
		printFormatted.accept("Salman", "Khan");  // First Name: Salman, Last Name: Khan
		
		//We can also use printf like:
		BiConsumer<String, String> printFormatted2 = (first, last) -> System.out.printf("First Name: %s Last Name: %s %n", first, last);
		printFormatted2.accept("Salman", "Khan");  // First Name: Salman, Last Name: Khan
		
		
		// Using with List and Streams API
		// Often used in cases where you need to perform an operation on each element of the list while involving an additional parameter
		
		List<String> names = Arrays.asList("Ali", "Ahmed", "Salman");

        // BiConsumer to print name with suffix
        BiConsumer<String, String> printWithSuffix = (name, suffix) -> System.out.println(name + suffix);
        String suffix = " Jr.";

        // Use forEach to apply the BiConsumer with the suffix
        names.forEach(name -> printWithSuffix.accept(name, suffix));
        
        // Exercise: Use BiConsumer, count similar values and display count of each value as suffix. 
        // Expected output should be: Item counts: {Apple=2, Banana=2, Orange=1}
        
        List<String> items = Arrays.asList("Apple", "Banana", "Orange", "Apple", "Banana");
      
        // Without BiConsumer we can count values like:
        // Map<String, Long> fruitsMap = items.stream().collect( Collectors.groupingBy(item -> item, Collectors.counting()) );
        // System.out.println( fruitsMap );
        
        Map<String, Integer> itemCountMap = new HashMap<>();
        
        BiConsumer<Map<String, Integer>, String> countedValues = (fruitsMap, fruit) -> fruitsMap.put(fruit, fruitsMap.getOrDefault(fruit, 0) + 1 );        
        items.stream().forEach( fruit -> countedValues.accept(itemCountMap, fruit) );
        System.out.println( itemCountMap );		
		*/
		
		// Exercise:  use BiConsumer to store item and its prince into a map
		// List<String> items = Arrays.asList("Apple", "Banana", "Orange");
        // List<Double> prices = Arrays.asList(0.99, 0.59, 1.29);
		
		List<String> items = Arrays.asList("Apple", "Banana", "Orange");
        List<Double> prices = Arrays.asList(0.99, 0.59, 1.29);

        // Map to store item-price pairs
        Map<String, Double> itemPriceMap = new HashMap<>();

        // BiConsumer to add each item-price pair to the map
        BiConsumer<String, Double> addItemToMap = (item, price) -> itemPriceMap.put(item, price);

        // Use a loop to go through each item and its corresponding price, then apply BiConsumer
        for (int i = 0; i < items.size(); i++) {
            addItemToMap.accept(items.get(i), prices.get(i));
        }

        // Display the populated map
        System.out.println("Item-Price Map: " + itemPriceMap);
		
	}

}