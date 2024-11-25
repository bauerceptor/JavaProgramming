# 4 Interfaces and Lambda Expressions

## Interfaces

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

- It is not necessary to write ```public abstract``` with an interface method because it is *by-default both public and abstract* (since it tends to be over-ridden later on). Also, implementations of methods defined in the interface **must always have public** as their visibility attribute.

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

## Anonymous Class

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

## Lambda Expressions

- Also called arrow functions in JavaScript. After the arrow, we declare the method body. We save the lambda expression in a variable of *Functional Interface* datatype.

- A lambda expression is a short block of code which takes in parameters and returns a value.

- Lambda expressions are similar to methods, but they do not need a name and they can be implemented right in the body of a method.

  (parameter1, parameter2) -> expression

- Expressions are limited. They have to immediately return a value, and they cannot contain variables, assignments or statements such as if or for.

- In order to do more complex operations, a code block can be used with curly braces. If the lambda expression needs to return a value, **then the code block should have a return statement**.

  (parameter1, parameter2) -> { code block }

## Functional Interface

- An interface with only a single method.

- However, it can also have a `default` method in addition to the abstract `@FunctionalInterface` method.

- An instance of interface is created in 3 ways: by implementing the interface in a class, by using anonymous classes, or through lambda expressions.

[Go back to title page](./../../README.md) or [go back to top.](#4-interfaces-and-lambda-expressions)
