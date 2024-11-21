package class10_generics_and_enums;

public class Person implements Comparable<Person> {		// implementing Comparable interface to include sorting feature in Person class
	private String name;
	private int age;
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	
//	this compareTo method does not use generics so we need to typecast the Object into Person
//	public class Person implements Comparable  --> class will be like this when we are not using generics

//	@Override
//	public int compareTo(Object obj) {
//		Person p = (Person)obj;
//		return this.name.compareTo(p.name);
//	}
	
	
	@Override
	public int compareTo(Person p) {
		return this.name.compareTo(p.name);		// String is already comparable
		
	}
	
	
}

