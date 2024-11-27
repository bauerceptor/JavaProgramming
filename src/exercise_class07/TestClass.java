package exercise_class07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import class07_collections_comparisons_streams.Person;

public class TestClass {

	public static void main(String args[]) {
		

		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person("Bilal", 50));
		persons.add(new Person("Zahid", 60));
		persons.add(new Person("Ali", 20));
		
		
		
		
		
		Collections.sort( persons, (per1, per2) -> new Integer(per1.getAge()).compareTo(per2.getAge()) );
		
//		oldest(persons);
		
		persons.remove(persons.size() - 1);
		
		System.out.println(persons);
		
		
		
		
	}
	
	public static Person oldest(List<Person> persons) {
		int old = 0;
		int index = -1;
		
		for (int i = 0; i < persons.size(); i++) {
			if (persons.get(i).getAge() > old) {
				old = persons.get(i).getAge();
				index = i;
			}
		}
		return persons.remove(index);
		
	}
	
}