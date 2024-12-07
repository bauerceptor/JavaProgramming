# 7 Collections, comparisons & `stream` API

- [7 Collections, comparisons \& `stream` API](#7-collections-comparisons--stream-api)
  - [Collections](#collections)
  - [Implementing comparisons in Java](#implementing-comparisons-in-java)
    - [Comparable Interface](#comparable-interface)
    - [Comparator Interface](#comparator-interface)
    - [Comparable \& Comparator - Side-by-side](#comparable--comparator---side-by-side)
  - [Streams API](#streams-api)


## Collections

- Arrays is a fixed time of collection whose size is known at compile time.

- Collections are dynamic, all of them. They are mainly of 3 types: list, set, map. List can have duplicate values and are sorted (where order is maintained and matters). Sets only store unique values (no duplicates) and it will not add duplicate values without raising error/exception. Also, order does not matter in sets. Map store data in key-value pairs, and they are like dictionaries (or objects in JavaScript). All contents of Collections (list, set, map) are interfaces. 

- Generic collections provide compile-time safety.

- Keys in maps are unique. Using the same key to add something new overwrites the previous entry (value) against that key.

- Iterators are used for looping because they give the ability to remove items as well as read items while reading an item during an iteration.

## Implementing comparisons in Java

### Comparable Interface

The **Comparable** interface defines the `compareTo` method used to compare objects. If a class implements the **Comparable** interface, objects created from that class can be sorted using Java's sorting algorithms.

The `compareTo` method required by the Comparable interface, returns and integer and receives as its parameter the object to which the "this" object is compared. If the "this" object comes before the object received as a parameter in terms of sorting order, the method should return a negative number. If, on the other hand, the "this" object comes after the object received as a parameter, the method should return a positive number. Otherwise, 0 is returned. The sorting resulting from the compareTo method is called natural ordering.

As returning a negative number from compareTo() is enough if the this object is smaller than the parameter object, and returning zero is sufficient when the lengths are the same, the compareTo method described above can also be implemented as follows.

  ```java
  @Override
  public int compareTo(Member member) {
    return this.height - member.getHeight();
  }
  ```

String class is already comparable because it implements the Comparable interface.

### Comparator Interface

adasd

### Comparable & Comparator - Side-by-side

- `compareTo` (in Comparable interface) is used for in-place sorting and `comparator` (in Comparator interface) is user to return a new sorted object.

| Comparable  | Comparator  |
|---|---|
| Comparable provides a **single sorting sequence**. In other words, we can sort the collection on the basis of a single element such as id, name, and price.  | The Comparator provides **multiple sorting sequences**. In other words, we can sort the collection on the basis of multiple elements such as id, name, and price etc.  |
| Comparable **affects** the original class, i.e., the actual class is modified. | Comparator **doesn't affect** the original class, i.e., the actual class is not modified. |
| Comparable provides **compareTo()** method to sort elements. | Comparator provides **compare()** method to sort elements. |
| Doesn't require a new separate class. The comparison functionality can be implement inside the over-ridden `compareTo()` method in the implementing class. | Requires a separate comparator class which implements the Comprator interface. This class can have only one over-ridden `compare()` method. In this way, we can make as many comparator classes as we want which can sort based on different criteria and these classes implement the Comprator interface. The `compare()` method of Comparator interface takes two arguments of the same type as the class for which we are implementing the comparison functionality. |
| Comparable is present in **java.lang** package. | A Comparator is present in the **java.util** package. |
| We can sort the list elements of Comparable type by **Collections.sort(List)** method. For example: `Collections.sort(yourList);`  | We can sort the list elements of Comparator type by **Collections.sort(List, Comparator)** method. For example: `Collections.sort(myList ,new NameComparator());` |

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

- `.collect(Collectors.groupingBy(ClassName::getAttribute))` collects to a Map data structure with Attribute as the Map's key but it's values are a **List** data structure.

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
