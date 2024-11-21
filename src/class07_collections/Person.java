package class07_collections;

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

	public Person(String name2, String string) {
		// TODO Auto-generated constructor stub
	}

	@Override
//	public int compareTo(Object arg0) {
//	Person p = (Person)obj;
	
	public int compareTo(Person p) {
		// p1 == p2 -> return 0
		// p1 > p2 -> return 1 or higher integer
		// p1 < p2 -> return -1 or lower integer
		
//		if (this.age == p.age) {
//			return 0;
//		} else if (this.age > p.age) {
//			return 1;
//		}
//		
//		return -1;
		
		return this.name.compareTo(p.name);		// String is already comparable
		
	}
	
	
}
