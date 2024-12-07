package edu.riphah.optional;

import java.util.Optional;

public class OptionalTests {

	public static void main(String[] args) 
	{
		 // Creating an Optional (Non-empty)
        Optional<String> optionalString = Optional.of("Hello, World!");
             
        // Check if value is present
        System.out.println(optionalString.isPresent());  // true
        System.out.println(optionalString.get());  // "Hello, World!"
        
        // ===========================================================================
        
        // Creating an empty Optional
        Optional<String> emptyOptional = Optional.empty();
        System.out.println(emptyOptional.isPresent());  // false
        
        // Create an Optional of an integer. If the integer is greater than 10, print "Number is large", otherwise print "Number is small"
        Optional<Integer> number = Optional.of(12);
        
        number.ifPresentOrElse(
        						n -> System.out.println( n > 10 ? "Number is large" : "Number is small"), 
        						()-> System.out.println("Number is not present") );
        
        // ===============================================================================
        // Optional from a nullable object
        String value = null;
        Optional<String> nullable = Optional.ofNullable(value);
        System.out.println(nullable.isPresent());  // false
        
        // ================================================================================
        
        // Create an Optional with a nullable String and print the value if present, or print "No value" if absent.
        String name = null;
        Optional<String> optionalName = Optional.ofNullable(name);
        
        optionalName.ifPresentOrElse(
            System.out::println, 
            () -> System.out.println("No value")
        );
        
        // ==================================================================================
        
        // ifPresent() executes a lambda expression if the value is present.
        Optional<String> greeting = Optional.of("Hello");
        
        greeting.ifPresent(g -> System.out.println(g));  // Hello
        
        Optional<String> emptyGreeting = Optional.empty();
        emptyGreeting.ifPresent(g -> System.out.println(g));  // No output
        
        // ==================================================================================
        
        // ifPresentOrElse() executes one action if the value is present and another if absent.
        emptyGreeting.ifPresentOrElse(
            g -> System.out.println(g),
            () -> System.out.println("No greeting available")  // No greeting available
        );
        
        // ===================================================================================
        
        // Exercise: Create an Optional of a String. If the value is present, print it in uppercase; if absent, print "Empty".
               
        // ====================================================================================
        
        // orElse() returns the value if present, otherwise returns the provided default value.
        Optional<String> message = Optional.empty();        
        System.out.println( message.orElse("Default Message") );  // Default Message
        
        // orElseGet() allows providing a default value using a supplier (lazy evaluation).
        Optional<String> anotherMessage = Optional.of("Hello, Java!");
        System.out.println(anotherMessage.orElse("Default Message"));  // Hello, Java!
        
        Optional<String> lazyValue = Optional.empty();
        String result = lazyValue.orElseGet(() -> "Computed Default Value");  // The Supplier is invoked lazily
        
        // =====================================================================================
        
        // Create an Optional of Integer. If it's empty, return the default value 100.
        
        // =====================================================================================
        
        // map() transforms the value inside the Optional if present. map takes Function
        Optional<String> greets = Optional.of("hello");
        Optional<String> upperCaseGreeting = greets.map(String::toUpperCase);
        
        // ======================================================================================
        
        // Exercise: Create an Optional of an integer, double it using map() and print the result.
        
        // =======================================================================================
        
        Optional<Integer> num = Optional.of(25);
        
        // Filter the Optional: Keep the value if it is greater than 10
        Optional<Integer> res = num.filter(n -> n > 10);
        System.out.println( res.orElse(-1) );  // Output: 25

        // Filter the Optional: Keep the value if it is less than 10
        Optional<Integer> res2 = num.filter(n -> n < 10);
        System.out.println(res2.orElse(-1));  // Output: -1 (empty Optional)
        
        Optional<String> nameCheck = Optional.of("Ahmed");

        // Keep the value if its length is greater than 3
        Optional<String> res3 = nameCheck.filter(s -> s.length() > 3);
        System.out.println(res3.orElse("Invalid"));  // Output: Ahmed

        // Keep the value if its length is less than 3
        Optional<String> res4 = nameCheck.filter(s -> s.length() < 3);
        System.out.println(res4.orElse("Invalid"));  // Output: Invalid
        
        // Chaining >> Filter and then map the value
        Optional<String> res5 = nameCheck.filter(n -> n.startsWith("A"))
                                      .map(String::toUpperCase);
        
        System.out.println(res5.orElse("No valid name"));  // Output: Ahmed
        
        // ========================================================================================
        
        // Combine two Optional<String> objects for a full name by concatenating them with a space in between. (we can use map() )
        
        Optional<String> firstName = Optional.of("Arshad");
        Optional<String> lastName = Optional.of("Ali");
        
        Optional<String> fullName = firstName.flatMap(f -> lastName.map(l -> f + " " + l));
        
        System.out.println(fullName.get());  // Arshad Ali
        
        // ========================================================================================

	}

}
