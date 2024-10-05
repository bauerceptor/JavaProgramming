# Topics Covered

 1. Class 01 - Introduction to Java & Its Ecosystem
 2. [Class 02 - OOP Fundamentals](#oop-fundamentals)
 3. Class 03 - Revision
 4. [Class 04 - Interfaces & Lambda Expressions](#interfaces-and-lambda-expressions)

## OOP Fundamentals

### Encapsulation

- Done to hide sensitive data items. For example, in a video game, if the attributes of a game character class are not encapsulated and if the user hacks/modifies the attributes of that class to have, for example super-high health points, then all the objects spawned from that class (player, enemy) and its child classes (non-playable characters) will all have super-high health points.

### Polymorphism

- Generalization = "is a" relation like in Inheritance

- Specialization = "has a" relation which is further enhanced through Association (weak) and Composition (strong).

- Instance variables stay together with that instance.

- Type casting, auto-promotion of a type (byte, short, int, long)

- Parent class (or object) can have reference of child class.

- But child class cannot have reference to parent class.

- References only occur at runtim, not compile type. So reference errors are not caught at compile type.

- **Lazy binding**: when program excutes, then at that time, methods bind to their reference. This implements polymorphism.

- Because Lazy Binding occurs at runtime (binding methods to their reference), this is the reason why polymorphism occurs at runtime.

- All methods follow Lazy Binding (runtime binding). But all attributes/instance variables are bound to data-types (compile-time binding). This is called **compile-time binding** or **static binding**.

### Abstraction

- A class having even a single abstract method, is automatically abstract. But sometimes we need to add the abstract keyword to the class as well, like in Java.

- A child class extending abstract class MUST override the abstract methods of the parent class, otherwise that child class also needs to be declared abstract.

- Abstraction is done to design a generalized response to every problem.

- Abstract class cannot have an instance because it is unclear what this class can and cannot do. It can only be extended by a concrete class.

### Drawbacks of Inheritance

- Inheritance is not recommended where requirements are changing constantly. In that case, we use **composition** (tight-coupling).

## Interfaces and Lambda Expressions

### Interfaces

- Java can only inherit from a single class. So interfaces allow us to implement multiple types. For example, a Speakable interfaces for all those animals that can speak (Cat, Dog,) can implement Speakable but Snake does not, Snake only needs to extend the Animal class because Snake does not have speak functionality.

We cannot make an instance of an interface as well like abstract class. So we can define a dog object in following ways:

```java
Dog d1 = new Dog();				// an instance of Dog class
Animal d2 = new Dog();			// an instance of Animal class
Speakable d3 = new Dog();		// an instance of Speakable interface
```

In this way, we can use interfaces to juggle between different types and enforce type-safety as well.

- In Java, we can only inherit from a single class but we can implement more than one interfaces.

- It is not necessary to write ```public abstract``` with an interface method because it is *by-default both public and abstract* (because it tends to be over-ridden later on).

- After Java 8, we can also provide a **default method** with ```default``` keyword. This method means that this abstract class has at least one functionality which we know well and can implement it then and there.

- Both interfaces and abstract classes can have *multiple default & abstract methods*.

- *Default methods* can also be over-ridden.

- *Static method* also exists in Interfaces and this method **cannot be over-ridden** in child/inheriting class.

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

- A lambda expression is a short block of code which takes in parameters and returns a value.

- Lambda expressions are similar to methods, but they do not need a name and they can be implemented right in the body of a method.

		(parameter1, parameter2) -> expression

- Expressions are limited. They have to immediately return a value, and they cannot contain variables, assignments or statements such as if or for.

- In order to do more complex operations, a code block can be used with curly braces. If the lambda expression needs to return a value, then the code block should have a return statement.

		(parameter1, parameter2) -> { code block }
