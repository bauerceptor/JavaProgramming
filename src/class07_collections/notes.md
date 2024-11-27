# 7 Collections, comparisons & `stream` API

- [7 Collections, comparisons \& `stream` API](#7-collections-comparisons--stream-api)
  - [Collections](#collections)
  - [Implementing comparisons in Java](#implementing-comparisons-in-java)
    - [Comparable Interface](#comparable-interface)
    - [Comparator Interface](#comparator-interface)
    - [Key Differences Between Comparable and Comparator](#key-differences-between-comparable-and-comparator)
    - [When to Use Which?](#when-to-use-which)
    - [Bonus Example with Comparator using Lambdas (Java 8+)](#bonus-example-with-comparator-using-lambdas-java-8)
  - [Streams API](#streams-api)

## Collections

- Arrays is a fixed time of collection whose size is known at compile time.

- Collections are dynamic, all of them. They are mainly of 3 types: list, set, map. List can have duplicate values and are sorted (where order is maintained and matters). Sets only store unique values (no duplicates) and it will not add duplicate values without raising error/exception. Also, order does not matter in sets. Map store data in key-value pairs, and they are like dictionaries (or objects in JavaScript). All contents of Collections (list, set, map) are interfaces. 

- Generic collections provide compile-time safety.

- Keys in maps are unique. Using the same key to add something new overwrites the previous entry (value) against that key.

- Iterators are used for looping because they give the ability to remove items as well as read items while reading an item during an iteration.

## Implementing comparisons in Java

### Comparable Interface

**Purpose**: The Comparable interface is used to define the natural order of objects. When a class implements Comparable, you specify how instances of that class should be compared to each other.

The **Comparable** interface defines the `compareTo` method used to compare objects. If a class implements the **Comparable** interface, objects created from that class can be sorted using Java's sorting algorithms.

**Implemented by**: The class whose objects you want to compare.

**Method to implement**: `compareTo(T o)`
    The `compareTo` method compares the current object (`this`) with the specified object (`o`).
    Returns:
        A negative integer if the current object is "less than" the specified object.
        Zero if both objects are equal.
        A positive integer if the current object is "greater than" the specified object.

The sorting resulting from the `compareTo` method is called *natural ordering*.

As returning a negative number from `compareTo()` is enough if the this object is smaller than the parameter object, and returning zero is sufficient when the lengths are the same, the compareTo method described above can also be implemented as follows.

  ```java
  @Override
  public int compareTo(Member member) {
    return this.height - member.getHeight();
  }
  ```

**Usage**: Used when you want to define a single, natural ordering for the objects of a class.

If a class implements the Comparable interface, it is possible to sort the list by using the `sorted` method. In fact, objects of any class that implement the Comparable interface can be sorted using the `sorted` method. Be aware, however, that **a stream does not sort the original list** - only the items in the stream are sorted.

If a programmer wants to organize the original list, the `sort` method of the Collections class should be used. This, of course, assumes that the objects on the list implement the Comparable interface.

```java
class Person implements Comparable<Person> {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person other) {
        return Integer.compare(this.age, other.age); // comparing by age
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 25));
        people.add(new Person("Charlie", 35));

        Collections.sort(people);  // sorts by age because of compareTo
        System.out.println(people);
    }
}
```

**Explanation**: Here, Person implements Comparable and sorts people based on their age using compareTo. The Collections.sort() method can now be used to sort a list of Person objects automatically.

### Comparator Interface

**Purpose**: The Comparator interface is used to define multiple sorting orders or to compare objects in ways other than their natural order. Unlike Comparable, which imposes a single natural order, Comparator provides more flexibility.

**Implemented by**: A separate comparator class or lambda expression to compare objects of another class.

**Method to implement**: `compare(T o1, T o2)`
    The compare method compares two objects (`o1` and `o2`) and returns:
        A negative integer if o1 is "less than" o2.
        Zero if o1 and o2 are equal.
        A positive integer if o1 is "greater than" o2.

**Usage**: Used when you want to define multiple sorting orders for the objects or when you cannot modify the class to implement Comparable.

```java
import java.util.*;

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}

class AgeComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return Integer.compare(p1.age, p2.age); // comparing by age
    }
}

class NameComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return p1.name.compareTo(p2.name); // comparing by name
    }
}

public class ComparatorExample {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 25));
        people.add(new Person("Charlie", 35));

        // sorting by age using AgeComparator
        Collections.sort(people, new AgeComparator());
        System.out.println("Sorted by age: " + people);

        // sorting by name using NameComparator
        Collections.sort(people, new NameComparator());
        System.out.println("Sorted by name: " + people);
    }
}
```

**Explanation**: Here, AgeComparator sorts the list of Person objects by age, and NameComparator sorts them by name. You can use different comparators for different sorting criteria without modifying the Person class itself.

The Comparator class provides two essential methods for sorting: `comparing` (seen already) and `thenComparing`. The comparing method is passed the value to be compared first, and the `thenComparing` method is the next value to be compared. The `thenComparing` method can be used many times by chaining methods, which allows virtually unlimited values ​​to be used for comparison.

When we sort objects, the `comparing` and `thenComparing` methods are given a reference to the object's type - the method is called in order and the values ​​returned by the method are compared. The method reference is given as `Class::method`. In the example below, we print movies by year and title in order.

```java
List<Film> films = new ArrayList<>();
films.add(new Film("A", 2000));
films.add(new Film("B", 1999));
films.add(new Film("C", 2001));
films.add(new Film("D", 2000));

for (Film e: films) {
    System.out.println(e);
}

Comparator<Film> comparator = Comparator
              .comparing(Film::getReleaseYear)
              .thenComparing(Film::getName);

Collections.sort(films, comparator);

for (Film e: films) {
    System.out.println(e);
}
```

### Key Differences Between Comparable and Comparator

- `compareTo` (in Comparable interface) is used for in-place sorting and `comparator` (in Comparator interface) is user to return a new sorted object.

| **Aspect**             | **`Comparable`**                                         | **`Comparator`**                                    |
|------------------------|----------------------------------------------------------|------------------------------------------------------|
| **Purpose**            | Defines the natural order of objects.                   | Defines custom, multiple sorting orders.             |
| **Implemented by**     | The class whose objects need to be compared.             | A separate class or a lambda expression for comparison. |
| **Method**             | `compareTo(T o)`                                          | `compare(T o1, T o2)`                                |
| **Sorting Logic**      | Provides a **single sorting sequence** (natural order).  | Provides **multiple sorting sequences** (multiple criteria). |
| **Modification**       | **Affects** the original class; the actual class is modified. | **Doesn’t affect** the original class; the actual class is not modified. |
| **Usage**              | Use when a **single, natural ordering** is needed for the objects. | Use when you need **multiple sorting orders** or when modifying the class is not an option. |
| **Implementation Detail** | Doesn't require a new separate class; `compareTo()` is implemented within the class itself. | Requires a separate comparator class or lambda expression to implement the `compare()` method. |
| **Package**            | Present in the **`java.lang`** package.                   | Present in the **`java.util`** package.             |
| **Sorting Mechanism**  | Can sort the list elements using **`Collections.sort(List)`** method. Example: `Collections.sort(yourList);` | Can sort the list elements using **`Collections.sort(List, Comparator)`** method. Example: `Collections.sort(myList ,new NameComparator());` |
| **Return Value**       | Returns a negative integer, zero, or positive integer in `compareTo()` based on comparison. | Returns a negative integer, zero, or positive integer in `compare()` based on comparison. |
| **Common Use Cases**   | When the class is designed to have a natural ordering (e.g., `Integer`, `String`, `Date`). | When sorting by multiple criteria or when you don't control the class being compared. |
| **Multiple Sorting**   | Cannot be used for **multiple sorting sequences** (one natural ordering only). | Can be used for **multiple sorting sequences** (you can define various comparators for different sorting orders). |

### When to Use Which?

Use Comparable when:

- You can define a single natural ordering for objects of a class.
- You control the class and can modify it to implement the compareTo method.
- You want to simplify the sorting logic by embedding it within the class itself.

Use Comparator when:

- You need multiple sorting orders (e.g., sorting by name and age).
- You don't have access to modify the class you want to sort (e.g., sorting a third-party class).
- You want to use lambda expressions to provide a custom sorting order inline.

### Bonus Example with Comparator using Lambdas (Java 8+)

```java
import java.util.*;

public class LambdaComparatorExample {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 25));
        people.add(new Person("Charlie", 35));

        // using a lambda expression for sorting by age
        Collections.sort(people, (p1, p2) -> Integer.compare(p1.age, p2.age));
        System.out.println("Sorted by age: " + people);

        // using a lambda expression for sorting by name
        Collections.sort(people, (p1, p2) -> p1.name.compareTo(p2.name));
        System.out.println("Sorted by name: " + people);
    }
}
```

Here, you can see that lambda expressions can be used to quickly create comparators, making code more concise and flexible.

## Streams API

![image-representation-of-stream](https://java-programming.mooc.fi/static/017e053fafe4c80050c350af52fbef31/c1a89/part10.1-stream.webp)

The figure above illustrates how a stream works. The starting point (1) is a list with values. When the stream() method is called on a list, (2) a stream of list values ​​is created. The values ​​are then dealt with individually. The stream values ​​can be (3) filtered by the filter method, which removes values ​​that fail to meet the condition from the stream. The stream's map method (4) can be used to map values ​​in a stream from one form to another. The collect method (5) collects the values ​​in a stream into a collection provided to it, such as a list.

- Streams API work only on Collections.

- Stream methods can be roughly divided into two categories:

  1. **Intermediate operations** intended for processing elements. These are methods that return a stream. Since the value returned is a stream, we can call intermediate operations sequentially.
   The `distinct`, `sorted`, `filter`, `map` and `mapToInt` methods shown in the previous example are intermediate operations.

    ```java
    // intermediate operations
    persons.stream()
      .map(person -> person.getFirstName())
      .distinct()
      .sorted()
      .forEach(name -> System.out.println(name));
    ```

    The `distinct` method described above uses the `equals`method that is in all objects for comparing whether two strings are the same. The `sorted` method on the other hand is able to sort objects that contain some kind of order — examples of this kind of objects are for example numbers and strings.

  2. **Terminal operations** that end the processing of elements.
   The `average` returns a OptionalDouble-type object that has a method getAsDouble() that returns a value of type double, the `count` method for counting the number of values on a list, the `forEach` method for going a through list values, the `collect` method for gathering the list values ​​into a data structure, and the `reduce` method for combining the list items.

- Stream API has a `forEach` method that can take ``Consumer`` type Functional Interface. This simply means that ``forEach`` method can take another method as reference and calls it during each iteration. It should be noted that `forEach` will simply take a method, and this method should not be called inside `forEach`. For example, if we wish to pass SysOut then it will be passed as follows:  `System.out::println`

- `filter` method in Stream API takes a `Predicate` type Functional Interface as argument. This simply means that it will take as argument, a method, that returns `true` or `false`. If the result of that method call is `true`, then `filter` will filter that element (meaning removes it).

- `filter` is used in combination with `collect` method of Stream API. Firstly, `filter` will complete its running (it will complete all its iterations), and filter the array. Then `collect` will return a new Collection (e.g. a list) with filtered content without modifying the original list. The **new list will contain** those entries which returned `true` in the `filter`'s reference method (argument).

- `map` takes in a functional interface. `map` takes in **Function** class type arguments which are actually built upon Java's Functional Interfaces. So instead, we can directly declare lambda expressions inside `map`.

- `mapToInt` transforms the stream into one containing integers. A stream containing strings can be converted using, for instance, the valueOf method of the Integer class. Something is done with the stream containing integers. 

- `sorted` can be used to sort. While sorting custom classes, `Comparator` is used inside `sorted`. Sorted items can be reverse-sorted as well by calling the `reversed()` method after `comparing()`.

- We can compare multiple times by first using the `comparing` method of `Comparator` and then using `thenComparing` method immediately after that.

- `reduce` is used when we wish to perform some aggregation on a list. `reduce`also saves and stores the result of previous iterations. It is useful when you want to combine stream elements to some other form. The parameters accepted by the method have the following format:
  <p align="center"> reduce(*initialState*, (*previous*, *object*) -> *actions on the object*) </p>

  ```java
  // reduce sample code
  // 1. finding the sum of a list of integer values
  int sum = values.stream()
    .reduce(0, (previousSum, value) -> previousSum + value);
    System.out.println(sum);
  // 2. joining a list of strings into a single string
  String combined = words.stream()
    .reduce("", (previousString, word) -> previousString + word + "\n");
    System.out.println(combined);
  ```

- `.collect(Collectors.groupingBy(ClassName::getAttribute))` collects to a Map data structure with Attribute as the Map's key.

- `.collect(Collectors.toCollection(ArrayList::new))` collects to an ArrayList data structure whereas `.collect(Collectors.toList())` collects to a List data structure which is infact an interface.

- Calculating the average is possible from a stream that has the mapToInt method called on it. A stream of integers has an average method that returns an OptionalDouble-type object. The object has getAsDouble() method that returns the average of the list values as a double type variable.

  ```java
  // working out the average
  double average = inputs.stream()
    .mapToInt(s -> Integer.valueOf(s))
    .average()
    .getAsDouble();
  ```

[Go back to title page](./../../README.md) or [go back to top.](#7-collections)
