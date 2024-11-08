# Topics Covered

 1. Class 01 - Introduction to Java & Its Ecosystem
 2. [Class 02 - Fundamentals of Object Oriented Programming](#oop-fundamentals)
 3. Class 03 - Revision
 4. [Class 04 - Interfaces, Anonymous Classes & Lambda Expressions](#interfaces-and-lambda-expressions)
 5. [Class 05 - Exception Handling & Throwing Exceptions](#exception-handling)
 6. Class 06 - String Class & Object class' `toString` and `equls` Method Overriding
 7. [Class 07 - Collections & `stream` API](#collections)
 8. Class 08 - Revision of Streams API
 9. [Class 09 - Java I/O & NIO](#java-io-and-nio)
 10. [Class 10 - Java Generics & Enumerations](#java-generics-and-enums)


---


## OOP Fundamentals

Java has only 8 primitive types of data (byte, short, int, long, float, double, boolean, char). Everything else in Java, is an object. Strings, however, are a special type of object which are created in a **String Pool** in the memory instead of Heap/Stack like other objects.

### Encapsulation

- Done to hide sensitive data items. For example, in a video game, if the attributes of a game character class are not encapsulated and if the user hacks/modifies the attributes of that class to have, for example super-high health points, then all the objects spawned from that class (player, enemy) and its child classes (non-playable characters) will all have super-high health points.

### Polymorphism

- Generalization = "is a" relation like Inheritance.

- Specialization = "has a" relation which is further enhanced through Association (weak) and Composition (strong).

- Instance variables stay together with that instance.

- Implicit type casting is auto-promotion of a type (byte -> short -> int -> long).

- Parent class (or object) can be used as a reference for a  child class object, e.g.:
```java
Parent object = new Child();    // this is valid
```

- But child class cannot be used as a reference to a parent class object, like:
```java
Child object = new Parent();    //! INVALID -> error
```

- References only occur at runtime, not compile time. So reference errors are not caught at compile type.

- **Lazy binding**: when program executes, then at that time, methods bind to their reference. This implements polymorphism.

- Since Lazy Binding occurs at runtime (binding methods to their reference), this is the reason due to which polymorphism also occurs at runtime.

- All methods follow Lazy Binding (runtime binding or dynamic binding). But all attributes/instance variables are bound to data-types (compile-time binding). This is called **compile-time binding** or **static binding**.

- Dynamic binding is achieved through method **over-riding** and static binding is achieved by means of method **overloading**.

- If the method call is decided at runtime; it is dynamic polymorphism. For example:

```java
public static void eat (Veg vegetable) {
    System.out.println("I am vegetarian");
}
public static void eat(Meat meat) {
    System.out.println("I am non-vegetarian");
}


public static void main(String args[]) {
    Veg v = new Meat();
    callEat(v);
}
```

It prints `"I am vegetarian"` . This is decided by compiler on runtime so it also called as method over-riding (dynamic binding).

- Likewise, if the method call is decided by compiler during compile time then it is called static polymorphism. For example:

```java
public int add (int a , int b) {
    return a+b;
}

public int add(int a, int b, int c) {
     return a+b+c;
}

public static void main (String args[]) {
   add(1,2);
   add(1,2,3);
}
```

Here the method is chosen depending on the parameter passed even when the name and return type of the method is the same. This is done at compile time and is static polymorphism. But it is also called as method over-loading.


> [!NOTE] Caution!!!
> 
> [_Dynamic binding_](https://en.wikipedia.org/wiki/Late_binding) is choosing which implementation of a method will be called at runtime, but this doesn't happen in Java. Rather you have [_dynamic dispatch_](https://en.wikipedia.org/wiki/Dynamic_dispatch) which is the ability to choose the correct polymorphic implementation of a method at compile time (which usually translates to choosing the **most specialized version of the method/function**).
> 
> But I wouldn't say that dynamic dispatch is polymorphism, I'd say that to support polymorphism you need a mechanism to choose the correct implementation of a method and this is dynamic dispatch.
> 
> Inheritance is a kind of polymorphism called [_subtyping_](https://en.wikipedia.org/wiki/Subtyping) (or _subtype polymorphism_) so, contrary to what you say, inheritance is always a form of polymorphism, but other kinds of polymorphism exist, think about:
> 
> - [_ad hoc polymorphism_](https://en.wikipedia.org/wiki/Ad_hoc_polymorphism) (implemented through overloading) where the same function has different meanings when applied to different arguments
> - [_parametric polymorphism_](https://en.wikipedia.org/wiki/Parametric_polymorphism) (implemented with Generics in Java) where you have types with type variables so that a single type can express infinite number of types by binding the variable to a specific type (or a class of types), think about `List<Integer>`


### Abstraction

- A class having even a single abstract method, is automatically abstract. But sometimes we need to add the abstract keyword to the class as well, like in Java.

- A child class extending abstract class MUST override the abstract methods of the parent class, otherwise that child class also needs to be declared abstract.

- Abstraction is done to design a generalized response to a generic problem.

- Abstract class cannot have an instance because it is unclear what this class can and cannot do. It can only be extended by a concrete class.

### Inheritance

- In Java, every class by default inherits from the **Object** class.

- `Object` class has three important methods: 
	- `public boolean equals(Object obj)`
	- `public String toString(Object obj)`
	- `public int hashCode()`

- These methods need to be over-ridden in all custom classes because they are extremely useful methods and cannot be used as is without overriding them first in our custom class.

- In Java, classes can inherit from another class as well as multiple interfaces.

### Drawbacks of Inheritance

- Inheritance is not recommended where requirements are changing constantly. In that case, we use **composition** (tight-coupling).
### Constructor Chaining

- `super` refers to parent class and `()` after super refers to parent class' constructor. 

- Constructor of parents are created when child is created because child will inherit from the parent at the end.

- If no constructor exists in the parent class, then compiler will itself generate a zero-argument constructor (default constructor) by itself.

- `super` is always called at first line and we can only call one `super` once per child class' constructor. 

- `this` keyword is used to call the constructor of  a class within that class itself. It could even be called in another constructor of that same class.


--- 


## Interfaces and Lambda Expressions

### Interfaces

- Java can only inherit from a single class. So interfaces allow us to implement multiple types. For example, a Speakable interfaces for all those animals that can speak (Cat, Dog,) can implement that Speakable interface as well as extend the Animal class. However, Snake class is designed not to implement the Speakable interface since a snake cannot speak. In this case, Snake class only needs to extend the Animal class because Snake does not have speak functionality.

We cannot make an instance of an interface as well like abstract class. So we can define a dog object in following ways:

```java
Dog d1 = new Dog(); // an instance of Dog with reference of Dog class
Animal d2 = new Dog(); // an instance of Dog with reference of parent Animal class
Speakable d3 = new Dog(); // an instance of Dog with reference of parent Speakable interface
```

In this way, we can use interfaces to juggle between different types and enforce type-safety as well.

- Sometimes we only declare an interface and leave it's body empty and then implement it in another class. For example, Java has a `Serializable` interface with empty body that is used to mark classes (by implementing it in that class). The objects of these marked classes are then passed through a gateway (like a web-server) and the gateway only allows those objects to pass through that have a reference to `Serializable` interface. An interface used in this manner is also called a **Marker Interface**. 

- In Java, we can only inherit from a single class but we can implement more than one interfaces.

- It is not necessary to write ```public abstract``` with an interface method because it is *by-default both public and abstract* (since it tends to be over-ridden later on).

- After Java 8, we can also provide a **default method** with ```default``` keyword. This method means that this abstract class has at least one functionality which we know well and can implement it then and there. The `default` method can also be Over-ridden later on. Similarly, interfaces can also have a `static` method which can also have a well-designed / already implemented body.

- The difference between `static` and `default` method is that `default` method can be Over-Ridden but `static` method cannot.

- After Java 8, the only major difference between Interfaces and Abstract classes is that Abstract class can have a constructor as well as normal (`public`, `private`, `protected` or `packaged`), `static` or `final` attributes. Whereas, Interfaces do not have constructors and can only have `static` or `static final` attributes.

- Both interfaces and abstract classes can have *multiple default & abstract methods*.

- *Default methods* can also be over-ridden.

- There can also be multiple interfaces with same method names and this is also called a **Diamond Problem**. In this case, we use the following syntax to distinguish between methods of different interfaces inside the child class:
```java

public class People implements Greedy, Miser {
	public static void main(String args[]) {
		super.Greedy.money();    // uses the money() method of Greedy interface
		super.Miser.money();    // uses the money() method of Miser interface
	}
}
```

### Anonymous Class

- Allows to make an **instance of an interface directly** without implementing it in another class.

```java
Speakable s = new Speakable() {
	@Override
	public void speaks() {
		// some code
	}
};
```

- Behind the scenes, the compiler will also generate a class by itself, with ```ClassName$1.class``` and then compiler will automatically compile it as well.

- This is useful in case of threading and event-handling.

### Lambda Expressions

- Also called arrow functions in JavaScript. After the arrow, we declare the method body. We save the lambda expression in a variable of *Functional Interface* datatype.

- A lambda expression is a short block of code which takes in parameters and returns a value.

- Lambda expressions are similar to methods, but they do not need a name and they can be implemented right in the body of a method.

		(parameter1, parameter2) -> expression

- Expressions are limited. They have to immediately return a value, and they cannot contain variables, assignments or statements such as if or for.

- In order to do more complex operations, a code block can be used with curly braces. If the lambda expression needs to return a value, **then the code block should have a return statement**.

		(parameter1, parameter2) -> { code block }

### Functional Interface

- An interface with only a single method.

- However, it can also have a `default` method in addition to the abstract `@FunctionalInterface` method.

- An instance of interface is created in 3 ways: by implementing the interface in a class, by using anonymous classes, or through lambda expressions.


---


## Exception Handling

- Main thread executes inside JVM (Java Virtual Machine).

- There are 2 types of exceptions in Java: 

	- Runtime Exception where error arises when the code is run. For example, dividing by zero. All exception of runtime nature inherit from the `RuntimeException` class.
	
	- Compile-Time Exception where error arises when the code first compiles (or the code is written in the IDE because the IDE is designed to handle compile type errors when as we type the code). For example, file not found exception. All exceptions of this nature inherit from the `Exception` class in Java.

- We can use multiple catch-blocks with a try-block but we can only use a single finally-block. Every catch block after try might or might not get executed (because it execution of catch block happens when an exception is raised) but the finally block always executes irrespective of catch block. So we use **finally** when we want to execute some code no matter what (like closing a file stream or input scanner). So every try and finally block is executed but catch block may or may not execute.

Java allows exception handling in following 3 ways: 

### 1. `try`...`catch` block

The try-catch block is used to handle exceptions in Java. Here's the syntax of `try...catch` block:

```Java
try {
  // code
}
catch(Exception e) {
  // code
}
```

Here, we have placed the code that might generate an exception inside the `try` block. Every `try` block is followed by a `catch` block.

When an exception occurs, it is caught by the `catch` block. The `catch` block cannot be used without the `try` block.

#### Example: Exception handling using `try`...`catch`

```Java
class Main {
  public static void main(String[] args) {

    try {

      // code that generate exception
      int divideByZero = 5 / 0;
      System.out.println("Rest of code in try block");
    }
    
    catch (ArithmeticException e) {
      System.out.println("ArithmeticException => " + e.getMessage());
    }
  }
}
```


**Output:** 
```java
ArithmeticException => / by zero
```

In the example, we are trying to divide a number by `0`. Here, this code generates an exception.

To handle the exception, we have put the code, `5 / 0` inside the `try` block. Now when an exception occurs, the rest of the code inside the `try` block is skipped.

The `catch` block catches the exception and statements inside the catch block is executed.

If none of the statements in the `try` block generates an exception, the `catch` block is skipped.

### 2. `finally` block

In Java, the `finally` block is always executed no matter whether there is an exception or not.

The `finally` block is optional. And, for each `try` block, there can be only one `finally` block.

The basic syntax of `finally` block is:

```java
try {
  //code
}
catch (ExceptionType1 e1) { 
  // catch block
}
finally {
  // finally block always executes
}
```

If an exception occurs, the `finally` block is executed after the `try...catch` block. Otherwise, it is executed after the try block. For each `try` block, there can be only one `finally` block.

---

#### Example: Exception Handling using `finally` block

```java
class Main {
  public static void main(String[] args) {
    try {
      // code that generates exception
      int divideByZero = 5 / 0;
    }

    catch (ArithmeticException e) {
      System.out.println("ArithmeticException => " + e.getMessage());
    }
    
    finally {
      System.out.println("This is the finally block");
    }
  }
}
```

**Output:**   
```java
ArithmeticException => / by zero
This is the finally block
```

In the above example, we are dividing a number by **0** inside the `try` block. Here, this code generates an `ArithmeticException`.

The exception is caught by the `catch` block. And, then the `finally` block is executed.

> [!NOTE]
> **Note**: It is a good practice to use the `finally` block. It is because it can include important cleanup codes like,
> 
> - code that might be accidentally skipped by return, [continue](https://www.programiz.com/java-programming/continue-statement) or [break](https://www.programiz.com/java-programming/break-statement)
> - closing a file or connection


### 3. `throw` and `throws` keyword

The Java `throw` keyword is used to explicitly throw a single exception.

When we `throw` an exception, the flow of the program moves from the `try` block to the `catch` block.

#### Example: Exception handling using `throw`

```java
class Main {
  public static void divideByZero() {

    // throw an exception
    throw new ArithmeticException("Trying to divide by 0");
  }

  public static void main(String[] args) {
    divideByZero();
  }
}
```

**Output:**

```java
Exception in thread "main" java.lang.ArithmeticException: Trying to divide by 0
        at Main.divideByZero(Main.java:5)
        at Main.main(Main.java:9)

```

In the above example, we are explicitly throwing the `ArithmeticException` using the `throw` keyword.

Similarly, the `throws` keyword is used to declare the type of exceptions that might occur within the method. It is used in the method declaration.

#### Example: `throws` keyword

```java
import java.io.*;

class Main {
  // declareing the type of exception
  public static void findFile() throws IOException {

    // code that may generate IOException
    File newFile = new File("test.txt");
    FileInputStream stream = new FileInputStream(newFile);
  }

  public static void main(String[] args) {
    try {
      findFile();
    }
    catch (IOException e) {
      System.out.println(e);
    }
  }
}
```


**Output**
```java
java.io.FileNotFoundException: test.txt (The system cannot find the file specified)
```

When we run this program, if the file **test.txt** does not exist, `FileInputStream` throws a `FileNotFoundException` which extends the `IOException` class.

The `findFile()` method specifies that an `IOException` can be thrown. The `main()` method calls this method and handles the exception if it is thrown.

If a method does not handle exceptions, the type of exceptions that may occur within it must be specified in the `throws` clause.

-> My class notes about the code files, below: 

- `exception A` has a child `exception B` which has a child `exception C`

- Parent class throws `exception B` in a method. when child class overrides that method then it can either throw `exception B` (same as parents original method) or `exception C`. But not `exception A`. we can only move down in hierarchy not upward.

- Same rule applies to return type of method.

- ***There are some errors in the files/classes in the `error_handling_class05` package.***


---


## Collections

- Arrays is a fixed time of collection whose size is known at compile time.

- Collections are dynamic, all of them. They are mainly of 3 types: list, set, map. List can have duplicate values and are sorted (where order is maintained and matters). Sets only store unique values (no duplicates) and it will not add duplicate values without raising error/exception. Also, order does not matter in sets. Map store data in key-value pairs, and they are like dictionaries (or objects in JavaScript). All contents of Collections (list, set, map) are interfaces. 

- Generic collections provide compile-time safety.

- Keys in maps are unique. Using the same key to add something new overwrites the previous entry (value) against that key.

- Iterators are used for looping because they give the ability to remove items as well as read items while reading an item during an iteration.

- String class is already comparable because it implements the Comparable interface.

- ``compareTo`` (in Comparable interface) is used for in-place sorting and ``comparator`` (in Comparator interface) is user to return a new sorted object.

### Stream API

- Streams API work only on Collections.

- Stream API has a `forEach` method that can take ``Consumer`` type Functional Interface. This simply means that ``forEach`` method can take another method as reference and calls it during each iteration. It should be noted that `forEach` will simply take a method, and this method should not be called inside `forEach`. For example, if we wish to pass SysOut then it will be passed as follows:  `System.out::println`

- `filter` method in Stream API takes a `Predicate` type Functional Interface as argument. This simply means that it will take as argument, a method, that returns `true` or `false`. If the result of that method call is `true`, then `filter` will filter that element (meaning removes it).

- `filter` is used in combination with `collect` method of Stream API. Firstly, `filter` will complete its running (it will complete all its iterations), and filter the array. Then `collect` will return a new Collection (e.g. a list) with filtered content without modifying the original list. The **new list will contain** those entries which returned `true` in the `filter`'s reference method (argument).

- `map` takes in a functional interface. `map` takes in **Function** class type arguments which are actually built upon Java's Functional Interfaces. So instead, we can directly declare lambda expressions inside `map`.

- `sorted` can be used to sort. While sorting custom classes, `Comparator` is used inside `sorted`. Sorted items can be reverse-sorted as well by calling the `reversed()` method after `comparing()`.

- We can compare multiple times by first using the `comparing` method of `Comparator` and then using `thenComparing` method immediately after that.

- `reduce` is used when we wish to perform some aggregation on a list. `reduce`also saves and stores the result of previous iterations.


---


## Java I/O and NIO




---


## Java Generics and Enums

- Provides compile-time data-type safety (removing the need for type-casting) and it also reduces code duplication while promoting code reuse.

- Class, method, enumeration, constructor, everything can be made a generic in Java.

- Generics never work on primitive types, we have to use objects with generics.

-  At any unknown type, we can perform read operations but not write operations so we cannot add to a generic list anything except null (except the items added while instantiating the list from `Arrays.toList()` ). But we can read from this list

-  Lower bounds (through `super`) and Upper bounds (through `extends`) can be defined by means of generics. Lower bounds are more generic and can allow writing data to lists as well as reading it.

- Type erasure by compiler at runtime and real compiled Java code does not have generics anywhere in it.

- Every numerical value (int, float, double, long) in Java inherits from the Number class.

- ? is a wild card that is used in generics.


### Enumerations

- Predefined lists that provide both type-safety and reduce the amount of code.

- Enumeration is treated as a data-type in Java.

- Enumerations can also have methods: normal, abstract, final and static. But static methods are not used because the enum's data item(s) is/are actually an instance of that enum so we don't need to use static method for it. 

- Enumerations can also have their own constructor which is **private** only because this constructor is used from inside that enumeration only. So we can also omit the constructor's access modifier and assume that it is private by default. Also, constructors will have **private attributes** as well.