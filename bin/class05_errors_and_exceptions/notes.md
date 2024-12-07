# 5 Exception Handling

- [5 Exception Handling](#5-exception-handling)
  - [1. `try`...`catch` block](#1-trycatch-block)
    - [Example: Exception handling using `try`...`catch`](#example-exception-handling-using-trycatch)
  - [2. `finally` block](#2-finally-block)
    - [Example: Exception Handling using `finally` block](#example-exception-handling-using-finally-block)
  - [3. `throw` and `throws` keyword](#3-throw-and-throws-keyword)
    - [Example: Exception handling using `throw`](#example-exception-handling-using-throw)
      - [Example: `throws` keyword](#example-throws-keyword)
  - [List of Important Exceptions in Java](#list-of-important-exceptions-in-java)

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

## List of Important Exceptions in Java

| **Exception Class**       | **Type**        | **Description**                                                                                 | **Common Properties**                                                                                     |
|---------------------------|-----------------|-------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------|
| **`Exception`**            | **Checked**     | The base class for all exceptions that are not errors.                                             | - Can be caught and handled.<br>- Has constructors that accept a message and/or a cause.                    |
| **`RuntimeException`**     | **Unchecked**   | The superclass of all exceptions that can be thrown during the normal operation of the JVM.       | - Does not need to be explicitly caught or declared.<br>- Can be caused by programming bugs (e.g., null pointer). |
| **`NullPointerException`** | **Unchecked**   | Thrown when the JVM attempts to access a method or field of an object that is `null`.             | - Often caused by dereferencing a null reference.<br>- Subclass of `RuntimeException`.                      |
| **`ArrayIndexOutOfBoundsException`** | **Unchecked** | Thrown when an invalid index is accessed in an array.                                             | - Commonly occurs when accessing an array with an index that is negative or exceeds the array length.        |
| **`ArithmeticException`**  | **Unchecked**   | Thrown when an exceptional arithmetic condition occurs, such as dividing by zero.                | - Subclass of `RuntimeException`.<br>- Often caused by division by zero or invalid arithmetic operations.     |
| **`ClassNotFoundException`** | **Checked**    | Thrown when a class is not found during runtime when attempting to load it via reflection or other means. | - Can be caught and handled.<br>- Usually indicates a problem with classpath or missing classes.              |
| **`FileNotFoundException`**| **Checked**     | Thrown when an attempt to open a file denoted by a specified pathname has failed.                 | - Subclass of `IOException`.<br>- Can be thrown by file I/O operations when the file doesn't exist.           |
| **`IOException`**          | **Checked**     | Thrown when an I/O operation fails or is interrupted.                                             | - Superclass for other I/O exceptions.<br>- Can be caught and handled by code that performs I/O operations.    |
| **`SQLException`**         | **Checked**     | Thrown when there is an issue with a database access or JDBC-related operation.                   | - Subclass of `Exception`.<br>- Usually provides error code and message related to database operations.       |
| **`InterruptedException`** | **Checked**     | Thrown when a thread is interrupted while it is waiting, sleeping, or otherwise occupied.          | - Commonly used in multithreading scenarios.<br>- Can be thrown during blocking operations like `sleep()`.    |
| **`IllegalArgumentException`** | **Unchecked** | Thrown to indicate that a method has been passed an illegal or inappropriate argument.            | - Subclass of `RuntimeException`.<br>- Often used for validation checks of method arguments.                  |
| **`IllegalStateException`** | **Unchecked**   | Thrown when a method has been invoked at an illegal or inappropriate time.                        | - Subclass of `RuntimeException`.<br>- Used for errors in the state of an object or resource.                 |
| **`NumberFormatException`** | **Unchecked**   | Thrown when an attempt to convert a string to a numeric type fails.                               | - Subclass of `IllegalArgumentException`.<br>- Common in parsing operations for numbers.                     |
| **`IndexOutOfBoundsException`** | **Unchecked** | Thrown when an index is out of range for an operation like accessing a list or a collection.       | - Common in operations on `List` or similar data structures.<br>- Subclass of `RuntimeException`.            |
| **`NoSuchElementException`** | **Unchecked** | Thrown when one tries to access an element that isn't available in a collection or iterator.       | - Subclass of `RuntimeException`.<br>- Common when accessing an empty iterator or an absent element.          |
| **`UnsupportedOperationException`** | **Unchecked** | Thrown when an unsupported operation is attempted on a collection or class.                       | - Subclass of `RuntimeException`.<br>- Commonly used in collections or classes where a certain operation is not supported. |
| **`SecurityException`**    | **Unchecked**   | Thrown to indicate a security violation.                                                         | - Subclass of `RuntimeException`.<br>- Often related to security manager checks or permission issues.         |
| **`OutOfMemoryError`**     | **Error**       | Thrown when the JVM runs out of memory.                                                           | - Subclass of `Error`.<br>- Indicates a severe condition that the program cannot recover from.               |
| **`StackOverflowError`**   | **Error**       | Thrown when a stack overflow occurs (e.g., from deep recursion).                                   | - Subclass of `Error`.<br>- Indicates a program error that usually requires code optimization (e.g., tail recursion). |
| **`AssertionError`**       | **Error**       | Thrown when an assertion fails (used for debugging purposes).                                     | - Subclass of `Error`.<br>- Occurs if a program encounters a failed assertion when `assert` is enabled.         |

[Go back to title page](./../../README.md) or [go back to top.](#5-exception-handling)
