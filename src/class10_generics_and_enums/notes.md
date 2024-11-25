# 10 Java Generics and Enums

- Provides compile-time data-type safety (removing the need for type-casting) and it also reduces code duplication while promoting code reuse.

- Class, method, enumeration, constructor, everything can be made a generic in Java.

- Generics never work on primitive types, we have to use objects with generics.

- Compiler can *infer the type* of data used in a generic type whether that generic type is an instance (of a generic class) or a generic method. Similarly, compiler can infer types of generic collections while using the Streams API as well. Also, the compiler can infer the data-type of local variables (variables inside the methods) when such variables are declared using the `var` keyword. This `var` variable can even be a collection.

- At any unknown type, we can perform read operations but not write operations so we cannot add to a generic list anything except null (except the items added while instantiating the list from `Arrays.toList()` ). But we can read from this list

- Lower bounds (through `super`) and Upper bounds (through `extends`) can be defined by means of generics. Lower bounds are more generic and can allow writing data to lists as well as reading it.

- Type erasure by compiler at runtime and real compiled Java code does not have generics anywhere in it.

- Every numerical value (int, float, double, long) in Java inherits from the Number class.

- ? is a wild card that is used in generics.

## When to use '?' wildcard in Java Generics

In Java, wildcards in generics (`?`) are used in certain situations where you need more flexibility than the fixed type parameter `T` allows. Wildcards are often used in method signatures, class definitions, and other places to express a broader range of types without specifying them explicitly. There are three main types of wildcards in Java generics: **unbounded wildcards**, **upper-bounded wildcards**, and **lower-bounded wildcards**. Here's a breakdown of when and why you would use each of them instead of a specific generic type `T`.

### 1. **Unbounded Wildcard (`?`)**

An unbounded wildcard is used when you don't know or care about the specific type, but you still want to work with any type of object. It is typically used when you don't need to write code that operates on the generic type but simply need to refer to the object in a general way.

#### Use Case

- When you want to work with any type, but you don't need to modify or operate on that type specifically.
- When the type doesn’t matter, but you want to write a more flexible method or class.

#### Example

```java
public void printList(List<?> list) {
    for (Object obj : list) {
        System.out.println(obj);
    }
}
```

Here, `List<?>` means that the list can hold any type, but the code doesn’t care about the type of the elements inside. This can be used for reading from the list without modifying its contents.

#### 2. **Upper-Bounded Wildcard (`? extends T`)**

An upper-bounded wildcard is used when you want to restrict the possible types to a specific type or its subclasses (i.e., the type must be a subtype of a given class or implement a specific interface). This is useful when you want to ensure that you can accept either a specific type or any type that extends it.

#### Use Case

- When you want to read from a structure and ensure that the elements are of a specific type or any type that extends it (i.e., a subtype).
- When you want to work with a class and its subclasses.

#### Example

```java
public void printNumbers(List<? extends Number> list) {
    for (Number num : list) {
        System.out.println(num);
    }
}
```

Here, `List<? extends Number>` means the list can contain any subclass of `Number` (such as `Integer`, `Double`, etc.). You can read from the list, but you can't safely add anything to it because you don't know the specific subtype.

### 3. **Lower-Bounded Wildcard (`? super T`)**

A lower-bounded wildcard is used when you want to restrict the possible types to a specific type or its superclasses (i.e., the type must be a supertype of the given class). This is useful when you want to write to a structure and ensure that you can add elements of a specific type or its subtypes.

#### Use Case

- When you want to add to a structure and want to ensure that you can safely add a specific type or its subtypes.
- When you need a method or class that accepts objects of a broader range of types but still allows adding elements of a specific type.

#### Example

```java
public void addNumbers(List<? super Integer> list) {
    list.add(10);  // This is safe because Integer is a subtype of Object
}
```

Here, `List<? super Integer>` means that the list can hold `Integer` or any supertype of `Integer`, such as `Number` or `Object`. You can add `Integer` to the list safely, but you can’t guarantee what type of object will be returned when you read from it.

### Summary of When to Use Wildcards vs. T

| **Situation**                                    | **Wildcard**                             | **Explanation**                                                   |
|--------------------------------------------------|------------------------------------------|-------------------------------------------------------------------|
| **You don’t care about the specific type at all.** | `List<?>` (unbounded wildcard)            | Used when you don't need to know the specific type, just that it's some type. |
| **You need to read from a collection, but don’t care about the exact type.** | `List<? extends T>` (upper-bounded wildcard) | Used when you only need to read from a collection and want flexibility with types. |
| **You need to write to a collection, and the elements are a certain type or a supertype.** | `List<? super T>` (lower-bounded wildcard) | Used when you need to add elements to a collection and ensure they are a certain type or a supertype. |

### When to Stick with `T` (Generic Type Parameter)

- When you **need to perform both read and write operations** on the collection, and you want to be specific about the type.
- When you need the **type safety** that a specific generic type provides (i.e., working with a known type `T`).
- When you **don’t need flexibility** in the types being passed (e.g., your method should always work with a specific type). 

In conclusion, wildcards are used in generics for **flexibility** when the specific type is not crucial, and the method or class needs to accept a broader range of types. Use `T` when you need to enforce type consistency and when you know the exact type you'll be working with.

## Enumerations

- Predefined lists that provide both type-safety and reduce the amount of code.

- Enumeration is treated as a data-type in Java.

- Enumerations have a built-in `.name()` method.

- Enumerations can also have methods: normal, abstract, final and static. But static methods are not used because the enum's data item(s) is/are actually an instance of that enum so we don't need to use static method for it.

- Enumerations can also have their own constructor which is **private** only because this constructor is used from inside that enumeration only. So when we omit the constructor's access modifier, assume that it is private by default. Also, constructors will have **private attributes** as well.

[Go back to title page](./../../README.md) or [go back to top.](#10-java-generics-and-enums)
