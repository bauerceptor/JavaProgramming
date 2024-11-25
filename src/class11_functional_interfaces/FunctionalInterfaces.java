package class11_functional_interfaces;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FunctionalInterfaces {

	public static void main(String args[]) {

		// using a predicate, which is a simple true/false condition

		Predicate<String> strLength = str -> str.length() > 5;

		boolean result = strLength.test("hello world");
		System.out.println(result);

		// using custom predicate to work with Streams API
		Predicate<Integer> isEven = n -> n % 2 == 0; // returns true if number is even
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		List<Integer> evenNums = nums.stream().filter(isEven).collect(Collectors.toList());
		System.out.println(evenNums);

		// using a function
		Function<String, Integer> strLength2 = str -> str.length(); // returns the length of a string
		Integer i = strLength2.apply("work done");
		System.out.println(i);

		// a function that takes a string and returns it in upper case
		Function<String, String> toUpper = str -> str.toUpperCase(); // converts a string to upper-case
		List<String> distros = Arrays.asList("ubuntu", "rhel", "fedora", "opensuse");
		List<String> upperCaseDistros = distros.stream().map(toUpper).collect(Collectors.toList());
		System.out.println(upperCaseDistros);

		// using a consumer interface
		Consumer<String> addPrefix = str -> System.out.println("Prefix: " + str); // adds string "Prefix: " to every
																					// input string
		addPrefix.accept("Java");

		// we have a string list and want to print length of all string items when we
		// print that list
		Consumer<String> printLenOfString = str -> System.out.println(str + ": " + str.length());
		distros.stream().forEach(printLenOfString);

		// using a supplier interface
		Supplier<Double> randomNumber = () -> Math.random(); // generates a random number
		System.out.println(randomNumber.get());

		// a supplier interface that generates a list with 10 random numbers
		Supplier<Integer> randomInteger = () -> new Random().nextInt(100); // generates a random integer between [0,
																			// 100) or [0, 99]
		List<Integer> randomNums = Stream.generate(randomInteger).limit(10).collect(Collectors.toList());
		System.out.println(randomNums);

		// using a binary operator
		BinaryOperator<Integer> sum = (x, y) -> x + y; // returns sum of two integers x and y
		System.out.println(sum.apply(12, 13));

		// a binary operator that takes two strings as input and concatenates them
		BinaryOperator<String> concat = (x, y) -> x.concat(" ").concat(y); // using concat method of String instead of
																			// +. because concat method is more
																			// efficient when it comes to dealing with
																			// string concaternation then + which is
																			// more expensive computationally
		System.out.println(concat.apply("This", "night"));

		// a binary operator return minimum of two integers
		BinaryOperator<Integer> getMinValue = (x, y) -> {
			if (x < y)
				return x;
			else
				return y;
		};

		// or
		BinaryOperator<Integer> getMinValue2 = (x, y) -> x < y ? x : y; // ternary operator: (condition)? true : false;
		int result2 = nums.stream().reduce(Integer.MAX_VALUE, getMinValue2);
		System.out.println(result2);

		// concatenating a list of integers to return a single string using binary
		// operator
		BinaryOperator<String> concat2 = (x, y) -> x.concat(" ").concat(y);
		String result3 = distros.stream().reduce("", concat2);
		System.out.println(result3);

		// using a BiPredicate to check if the given string is greater than 5 and if it
		// is, then that string is a valid string
		BiPredicate<String, Integer> checkStrings = (str, length) -> str.length() > length;
		List<String> validStrings = distros.stream().filter(str -> checkStrings.test(str, 5))
				.collect(Collectors.toList());
		System.out.println(validStrings);

		// using a bifunction to print length of both person's first and last name
		BiFunction<String, String, Integer> combineLength = (firstName, lastName) -> firstName.length()
				+ lastName.length();
		List<Person> persons = Arrays.asList(new Person("Ali", "Khan"), new Person("Asif", "Abid"),
				new Person("Kashif", "Shah"));

		List<Integer> personNameLength = persons.stream()
				.map(person -> combineLength.apply(person.getFirstName(), person.getLastName()))
				.collect(Collectors.toList());
		System.out.println(personNameLength);

		// ************************** BiConsumer<T, U> *********************************
		// Performs an operation on two inputs of types T and U, returning nothing

		BiConsumer<String, Integer> printKeyValue = (key, value) -> System.out.println(key + ": " + value);
		printKeyValue.accept("Age", 30); // Age: 30

		BiConsumer<String, String> printFormatted = (first, last) -> System.out
				.println("First Name: " + first + ", Last Name: " + last);
		printFormatted.accept("Salman", "Khan"); // First Name: Salman, Last Name: Khan

		// We can also use printf like:
		BiConsumer<String, String> printFormatted2 = (first, last) -> System.out
				.printf("First Name: %s Last Name: %s %n", first, last);
		printFormatted2.accept("Salman", "Khan"); // First Name: Salman, Last Name: Khan

		// Using with List and Streams API
		// Often used in cases where you need to perform an operation on each element of
		// the list while involving an additional parameter

		List<String> names = Arrays.asList("Ali", "Ahmed", "Salman");

		// BiConsumer to print name with suffix
		BiConsumer<String, String> printWithSuffix = (name, suffix) -> System.out.println(name + suffix);
		String suffix = " Jr.";

		// Use forEach to apply the BiConsumer with the suffix
		names.forEach(name -> printWithSuffix.accept(name, suffix));

		// Exercise: Use BiConsumer, count similar values and display count of each
		// value as suffix.
		// Expected output should be: Item counts: {Apple=2, Banana=2, Orange=1}

		List<String> items = Arrays.asList("Apple", "Banana", "Orange", "Apple", "Banana");

		// Without BiConsumer we can count values like:
		// Map<String, Long> fruitsMap = items.stream().collect(
		// Collectors.groupingBy(item -> item, Collectors.counting()) );
		// System.out.println( fruitsMap );

		Map<String, Integer> itemCountMap = new HashMap<>();

		BiConsumer<Map<String, Integer>, String> countedValues = (fruitsMap, fruit) -> fruitsMap.put(fruit,
				fruitsMap.getOrDefault(fruit, 0) + 1);
		items.stream().forEach(fruit -> countedValues.accept(itemCountMap, fruit));
		System.out.println(itemCountMap);

	}

}
