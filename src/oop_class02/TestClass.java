package oop_class02;

public class TestClass {
	public static void main(String args[]) {
		Animal animal = new Animal();
		animal.weight = 10.5f;
		animal.speak();
		
		Cat cat = new Cat();
		cat.weight = 5.5f;
		cat.speak();
//		Animal a2 = new Cat();		Parent can have reference of child
//!!	Cat c = new Animal();	!!  Child cannot have reference of parent	
	
//		==============================================
		
//		Animal a = new Cat();		-Valid
//!!	Cat c = a;					Invalid because Cat (child) cannot have reference of Animal (parent)				
//		Cat c = (Cat) a;			-Valid type-casting, because we know that "c" is a reference to Cat so we casted it into Cat as there is no loss of data/information
	
//		==============================================
		
		Dog dog = new Dog();
		dog.weight = 15.5f;
		dog.speak();
		
//		==============================================
		
		Animal a = new Cat();		// this line is polymorphism
		// or
	//  Animal a = new Dog();
		a.speak();					// method always binds to its reference -> Lazy Binding
//!!	a.extraVarOfCat = 2;		//!! not working because all variables are not bound to reference, they are bound to data types (Animal or Cat or Dog). they are bound at compile-time, and as there is no reference to Cat for "a" at compile-time (because references are not estabilished at compile-time rather than at runtime). This is called compile-time binding or static binding.
//		Cat a = (Cat) a;
//		a.extraVarOfCat = 2;		- now it is Valid.
//-->	((Cat)a).extraVarOfCat = 2;	- short-hand way

//		=============================================
		
		Animal catto = new Cat();
		Animal doggo = new Dog();
		
//??	The below also works for polymorphism because afterall, Cat and Dog are both childs of Animal
//??	Animal catto = new Cat();
//??	Animal doggo = new Dog();
		
		speakAnimal(catto);
		speakAnimal(doggo);
		
	}
	
	public static void speakAnimal(Animal animal) {		// here, animal is a polymorphic argument
		
//??	The code below needs to be implemented if we are using the ?? code above	
		if (animal instanceof Dog == true) {
			animal = (Dog) animal;
		} else if (animal instanceof Cat == true) {
			animal = (Cat) animal;
		}
		
		animal.speak();
	}
}
