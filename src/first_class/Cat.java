package first_class;

public class Cat extends Animal {

	int extraVarOfCat;
	
	public Cat() {
		
	}
	
	@Override
	public void speak() {
		System.out.println("mein mein");
	}
}



//		This is composition. Now we also need to first define an animal in the TestClass and then a Cat through composition.
//public class Cat {
//	Animal animal;
//	
//	public Cat(Animal animal) {
//		this.animal = animal'
//	}
//	
//	public void speak() {
//		System.out.println("moun moun");
//	}
//}