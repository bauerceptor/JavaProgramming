package exercise_class11;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class TestClass {
	public static void main(String args[]) {
		// using a consumer to get the squares of a list of numbers
		Consumer<Integer> getSquare = num -> System.out.println("Square of " + num + ": " + (num * num));
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		nums.stream().forEach(getSquare);

		// using bipredicate to filter a list of names to return only those strings that
		// start with "a"
		List<String> names = Arrays.asList("Ali", "Ahmad", "Zameer", "Munir", "Asif");
		BiPredicate<String, String> startWithChar = (str, c) -> str.startsWith(c); // case-sensitive
		BiPredicate<String, String> startWithChar2 = (str, c) -> str.toLowerCase().startsWith(c.toLowerCase()); // case-insensitive
																												// matching
		List<String> validNames = names.stream().filter(str -> startWithChar.test(str, "A"))
				.collect(Collectors.toList());
		System.out.println(validNames);

		// Exercise: use BiConsumer to store item and its prince into a map
		// List<String> items = Arrays.asList("Apple", "Banana", "Orange");
		// List<Double> prices = Arrays.asList(0.99, 0.59, 1.29);

		List<String> items = Arrays.asList("Apple", "Banana", "Orange");
		List<Double> prices = Arrays.asList(0.99, 0.59, 1.29);

		// Map to store item-price pairs
		Map<String, Double> itemPriceMap = new HashMap<>();

		// BiConsumer to add each item-price pair to the map
		BiConsumer<String, Double> addItemToMap = (item, price) -> itemPriceMap.put(item, price);

		// Use a loop to go through each item and its corresponding price, then apply
		// BiConsumer
		for (int i = 0; i < items.size(); i++) {
			addItemToMap.accept(items.get(i), prices.get(i));
		}

		// Display the populated map
		System.out.println("Item-Price Map: " + itemPriceMap);

	}
}
