# 2 OOP Fundamentals

Java has only 8 primitive types of data (byte, short, int, long, float, double, boolean, char). Everything else in Java, is an object. Strings, however, are a special type of object which are created in a **String Pool** in the memory instead of Heap/Stack like other objects.

## Encapsulation

- Done to hide sensitive data items. For example, in a video game, if the attributes of a game character class are not encapsulated and if the user hacks/modifies the attributes of that class to have, for example super-high health points, then all the objects spawned from that class (player, enemy) and its child classes (non-playable characters) will all have super-high health points.

## Polymorphism

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

## Abstraction

- A class having even a single abstract method, is automatically abstract. But sometimes we need to add the abstract keyword to the class as well, like in Java.

- A child class extending abstract class MUST override the abstract methods of the parent class, otherwise that child class also needs to be declared abstract.

- Abstraction is done to design a generalized response to a generic problem.

- Abstract class cannot have an instance because it is unclear what this class can and cannot do. It can only be extended by a concrete class.

## Inheritance

- In Java, every class by default inherits from the **Object** class.

- `Object` class has three important methods:
  - `public boolean equals(Object obj)`
  - `public String toString(Object obj)`
  - `public int hashCode()`

- These methods need to be over-ridden in all custom classes because they are extremely useful methods and cannot be used as is without overriding them first in our custom class.

- In Java, classes can inherit from another class as well as multiple interfaces.

### Drawbacks of Inheritance

- Inheritance is not recommended where requirements are changing constantly. In that case, we use **composition** (tight-coupling).

## Constructor Chaining

- `super` refers to parent class and `()` after super refers to parent class' constructor.

- Constructor of parents are created when child is created because child will inherit from the parent at the end.

- If no constructor exists in the parent class, then compiler will itself generate a zero-argument constructor (default constructor) by itself.

- `super` is always called at first line and we can only call one `super` once per child class' constructor.

- `this` keyword is used to call the constructor of  a class within that class itself. It could even be called in another constructor of that same class.

[Go back to title page](./../../README.md) or [go back to top.](#2-oop-fundamentals)
