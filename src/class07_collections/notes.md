# 7 Collections

- Arrays is a fixed time of collection whose size is known at compile time.

- Collections are dynamic, all of them. They are mainly of 3 types: list, set, map. List can have duplicate values and are sorted (where order is maintained and matters). Sets only store unique values (no duplicates) and it will not add duplicate values without raising error/exception. Also, order does not matter in sets. Map store data in key-value pairs, and they are like dictionaries (or objects in JavaScript). All contents of Collections (list, set, map) are interfaces. 

- Generic collections provide compile-time safety.

- Keys in maps are unique. Using the same key to add something new overwrites the previous entry (value) against that key.

- Iterators are used for looping because they give the ability to remove items as well as read items while reading an item during an iteration.

- String class is already comparable because it implements the Comparable interface.

- ``compareTo`` (in Comparable interface) is used for in-place sorting and ``comparator`` (in Comparator interface) is user to return a new sorted object.

| Comparable  | Comparator  |
|---|---|
| Comparable provides a **single sorting sequence**. In other words, we can sort the collection on the basis of a single element such as id, name, and price.  | The Comparator provides **multiple sorting sequences**. In other words, we can sort the collection on the basis of multiple elements such as id, name, and price etc.  |
| Comparable **affects** the original class, i.e., the actual class is modified. | Comparator **doesn't affect** the original class, i.e., the actual class is not modified. |
| Comparable provides **compareTo()** method to sort elements. | Comparator provides **compare()** method to sort elements. |
| Doesn't require a new separate class. The comparison functionality can be implement inside the over-ridden `compareTo()` method in the implementing class. | Requires a separate comparator class which implements the Comprator interface. This class can have only one over-ridden `compare()` method. In this way, we can make as many comparator classes as we want which can sort based on different criteria and these classes implement the Comprator interface. The `compare()` method of Comparator interface takes two arguments of the same type as the class for which we are implementing the comparison functionality. |
| Comparable is present in **java.lang** package. | A Comparator is present in the **java.util** package. |
| We can sort the list elements of Comparable type by **Collections.sort(List)** method. For example: `Collections.sort(yourList);`  | We can sort the list elements of Comparator type by **Collections.sort(List, Comparator)** method. For example: `Collections.sort(myList ,new NameComparator());` |

## Stream API

- Streams API work only on Collections.

- Stream API has a `forEach` method that can take ``Consumer`` type Functional Interface. This simply means that ``forEach`` method can take another method as reference and calls it during each iteration. It should be noted that `forEach` will simply take a method, and this method should not be called inside `forEach`. For example, if we wish to pass SysOut then it will be passed as follows:  `System.out::println`

- `filter` method in Stream API takes a `Predicate` type Functional Interface as argument. This simply means that it will take as argument, a method, that returns `true` or `false`. If the result of that method call is `true`, then `filter` will filter that element (meaning removes it).

- `filter` is used in combination with `collect` method of Stream API. Firstly, `filter` will complete its running (it will complete all its iterations), and filter the array. Then `collect` will return a new Collection (e.g. a list) with filtered content without modifying the original list. The **new list will contain** those entries which returned `true` in the `filter`'s reference method (argument).

- `map` takes in a functional interface. `map` takes in **Function** class type arguments which are actually built upon Java's Functional Interfaces. So instead, we can directly declare lambda expressions inside `map`.

- `sorted` can be used to sort. While sorting custom classes, `Comparator` is used inside `sorted`. Sorted items can be reverse-sorted as well by calling the `reversed()` method after `comparing()`.

- We can compare multiple times by first using the `comparing` method of `Comparator` and then using `thenComparing` method immediately after that.

- `reduce` is used when we wish to perform some aggregation on a list. `reduce`also saves and stores the result of previous iterations.

- `.collect(Collectors.groupingBy(ClassName::getAttribute))` collects to a Map data structure with Attribute as the Map's key.

[Go back to title page](./../../README.md) or [go back to top.](#7-collections)
