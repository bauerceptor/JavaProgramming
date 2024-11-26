# 11 BuiltIn Functional Interfaces of Java

- Java has some built-in functional interfaces that can be directly used in the program without declaring a new interface file.

| **Functional Interface**  | **Input(s)**   | **Output(s)** | **Used By (with Streams)** | **Direct Use (without Streams)** | **Additional Info** |
|---------------------------|----------------|---------------|-------------|----------------|---------------------|
| `Predicate<T>`             | T              | `true` / `false`   | `filter`, `removeIf` | `interface.test(T)` | A `Predicate` is used when you need to evaluate a condition on a single object. It returns a boolean value (either `true` or `false`) depending on whether the condition holds. Predicates are commonly used for filtering or testing elements in collections or streams. |
| `Function<T, R>`           | T              | R             | `map`, `flatMap`         | `interface.apply(T)` | A `Function` represents a transformation from one type (`T`) to another type (`R`). It’s often used to map or transform elements, such as in the `map()` operation on `Streams`, where an element of type `T` is transformed into another type `R`. |
| `UnaryOperator<T>`         | T              | T             | `map`, `replaceAll`      | `interface.apply(T)` | A special case of `Function<T, T>`, the `UnaryOperator` is used when you want to apply an operation that transforms an element and returns the result of the same type. It's used for operations that don't change the element's type but modify it in place. |
| `Consumer<T>`              | T              | -             | `forEach`, `accept`      | `interface.accept(T)` | A `Consumer` takes a single input of type `T` and performs some operation on it but does not return a result. It is often used in scenarios where you want to iterate over a collection and perform side effects, like printing, updating, or logging. |
| `Supplier<T>`              | -              | T             | `Stream.generate`, `ThreadFactory`  | `interface.get()` | A `Supplier` is the inverse of a `Consumer`. It doesn't take any input but returns a result of type `T`. It's typically used in scenarios where you need to generate or supply new data, such as generating stream elements or creating objects dynamically (e.g., in factory patterns). |
| `BinaryOperator<T>`        | T, T           | T             | `reduce`, `accumulate`   | `interface.apply(T, T)` | A `BinaryOperator` takes two operands of the same type (`T`) and returns a result of the same type (`T`). It's commonly used in `reduce()` operations in streams to combine elements, such as summing values or concatenating strings. It is essentially a specialized version of `BiFunction` where both input and output types are the same. |
| `BiPredicate<T, U>`        | T, U           | `true` / `false` | `filter`, `removeIf`    | `interface.test(T, U)` | A `BiPredicate` works like a `Predicate` but takes two arguments (`T` and `U`) instead of just one. It's used when you need to test a condition between two objects. For example, it could be used to check whether two values meet certain criteria (e.g., checking if two strings match or if an element of a list satisfies multiple conditions). |
| `BiFunction<T, U, R>`      | T, U           | R             | `map`, `flatMap`         | `interface.apply(T, U)` | A `BiFunction` allows you to apply a function that takes two inputs (`T` and `U`) and returns a result of type `R`. It's used in scenarios where you need to combine or transform two elements into another form, like in the `map()` operation when dealing with a `Map<K, V>` or when processing pairs of values. |
| `BiConsumer<T, U>`         | T, U           | -             | `forEach`, `accept`      | `interface.accept(T, U)` | A `BiConsumer` is similar to `Consumer` but takes two arguments (`T` and `U`) and performs an operation with them. It doesn't return a result. It is useful when you need to process pairs of objects, such as iterating over a map's entry set (`Map.entrySet()`) and performing an operation on both the key and value. |
| `BiSupplier<T, U>`         | U              | T             | Custom (if needed)        | `interface.get()` | A `BiSupplier` is not part of the standard Java API, but you can create a custom functional interface that returns a result based on two inputs (`T`, `U`). It can be useful when you need to supply a value that depends on two variables. It mimics the pattern of `BiFunction` but without taking inputs for transformation. |

---

## Additional Context and Examples

1. **`Predicate<T>`**:  
   - **Example**:

     ```java
     Predicate<String> isLongerThan3 = s -> s.length() > 3;
     List<String> list = Arrays.asList("apple", "bat", "car");
     list.stream().filter(isLongerThan3).forEach(System.out::println);  // Outputs: apple
     ```

2. **`Function<T, R>`**:  
   - **Example**:  

     ```java
     Function<Integer, String> intToString = (Integer i) -> "Number " + i;
     System.out.println(intToString.apply(5));  // Outputs: Number 5
     ```

3. **`UnaryOperator<T>`**:  
   - **Example**:  

     ```java
     UnaryOperator<Integer> increment = n -> n + 1;
     System.out.println(increment.apply(5));  // Outputs: 6
     ```

   - **Context**: A `UnaryOperator` is a specialized form of `Function` where both the input and output types are the same. It's ideal when you need to modify an element without changing its type. For instance, the `replaceAll()` method in a list uses `UnaryOperator` to modify the elements in-place.

4. **`Consumer<T>`**:  
   - **Example**:  

     ```java
     Consumer<String> printUpperCase = s -> System.out.println(s.toUpperCase());
     printUpperCase.accept("hello");  // Outputs: HELLO
     ```

   - **Context**: `Consumer` is useful when you want to perform some operation on an element, such as printing, updating, or logging, without returning any value.

5. **`Supplier<T>`**:  
   - **Example**:  

     ```java
     Supplier<Double> randomValue = () -> Math.random();
     System.out.println(randomValue.get());  // Outputs a random value between 0.0 and 1.0
     ```

   - **Context**: `Supplier` is used when you need to generate or supply values on demand. It's commonly used in factory methods or `Stream.generate()` to provide an endless stream of data.

6. **`BinaryOperator<T>`**:  
   - **Example**:  

     ```java
     BinaryOperator<Integer> sum = (a, b) -> a + b;
     System.out.println(sum.apply(5, 10));  // Outputs: 15
     ```

   - **Context**: `BinaryOperator` is often used with the `reduce()` method to accumulate elements in a collection, like summing, multiplying, or finding a maximum.

7. **`BiPredicate<T, U>`**:  
   - **Example**:  

     ```java

     BiPredicate<String, Integer> isLongerThan = (str, len) -> str.length() > len;
     System.out.println(isLongerThan.test("apple", 3));  // Outputs: true
     ```

   - **Context**: A `BiPredicate` is used when you need to evaluate a condition on two inputs. This is often used in filtering operations where both arguments influence the decision.

8. **`BiFunction<T, U, R>`**:  
   - **Example**:  

     ```java
     BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b;
     System.out.println(multiply.apply(5, 6));  // Outputs: 30
     ```

   - **Context**: `BiFunction` is used when you need to process two inputs of different types and return a result. For instance, combining two different data sources to produce a transformed value.

9. **`BiConsumer<T, U>`**:  
   - **Example**:  

     ```java
     BiConsumer<String, Integer> printDetails = (name, age) -> System.out.println(name + " is " + age + " years old");
     printDetails.accept("John", 30);  // Outputs: John is 30 years old
     ```

   - **Context**: `BiConsumer` is useful when you need to perform an operation with two inputs and don’t need a return value. It can be used for logging, updating, or printing out pairs of values.

10. **`BiSupplier<T, U>`** (Custom Interface Example):  
    - **Example** (Custom Interface):

      ```java
      @FunctionalInterface
      public interface BiSupplier<T, U> {
          T get(U u);  // Returns a result of type T based on input U
      }
      
      BiSupplier<String, Integer> supplier = i -> "Number: " + i;
      System.out.println(supplier.get(5));  // Outputs: Number: 5
      ```

    - **Context**: While `BiSupplier` doesn't come with Java by default, it can be implemented if needed.

## Key Takeaways

- **Predicates** are used for testing conditions, typically with methods like `filter()`.
- **Functions** and **BiFunctions** are used for transformations, mapping values from one type to another.
- **Consumers** and **BiConsumers** are for performing operations with no return value, often used in iteration or side-effect operations.
- **Suppliers** are used to generate or provide values, and **BinaryOperators** are specifically for combining two elements of the same type.
- **BiPredicates** and **BiFunctions** extend the regular `Predicate` and `Function` to take two inputs, providing more flexibility in operations that involve pairs of values.

[Go back to title page](./../../README.md) or [go back to top.](#11-builtin-functional-interfaces-of-java)
