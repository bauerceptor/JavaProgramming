# 5 Exception Handling

- Main thread executes inside JVM (Java Virtual Machine).

- There are 2 types of exceptions in Java:
  - Runtime Exception where error arises when the code is run. For example, dividing by zero. All exception of runtime nature inherit from the `RuntimeException` class.

  - Compile-Time Exception where error arises when the code first compiles (or the code is written in the IDE because the IDE is designed to handle compile type errors when as we type the code). For example, file not found exception. All exceptions of this nature inherit from the `Exception` class in Java.

- We can use multiple catch-blocks with a try-block but we can only use a single finally-block. Every catch block after try might or might not get executed (because it execution of catch block happens when an exception is raised) but the finally block always executes irrespective of catch block. So we use **finally** when we want to execute some code no matter what (like closing a file stream or input scanner). So every try and finally block is executed but catch block may or may not execute.

Java allows exception handling in following 3 ways:

## 1. `try`...`catch` block

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

### Example: Exception handling using `try`...`catch`

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

## 2. `finally` block

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

### Example: Exception Handling using `finally` block

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

## 3. `throw` and `throws` keyword

The Java `throw` keyword is used to explicitly throw a single exception.

When we `throw` an exception, the flow of the program moves from the `try` block to the `catch` block.

### Example: Exception handling using `throw`

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

**Output:**

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

[Go back to title page](./../../README.md) or [go back to top.](#5-exception-handling)
