package collections_class07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionsTest {

	public static void main(String args[]) {
		ArrayList<String> names = new ArrayList<>();
		List<String> names2 = new ArrayList();			// array list declared from the base class "list". this is better because base class should be used more and more for flexibility
		
		Set<String> hours = new HashSet();			// hash set is an implementation of set
		
//		Map<K, V> map = new HashMap();
		Map<String, String> map = new HashMap();
		map.put("name", "Ali");
		map.put("Age", "10");
		
		Integer i = new Integer(4);		// manual boxing
		i.intValue();					// manual unboxing
		
		Integer k = 3;					// auto-boxing
		int x = k;						// auto-unboxing
		
		names2.add("Ali");
		names2.add("Bilal");
		names2.add("Cavendish");
		names2.add("Zahid");
		names2.add("Haris");
		names2.add("Faisal");
		
		// looping using an iterator
		Iterator<String> iterator = names2.iterator();
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());		// can read item
			iterator.remove();							// can also remove item during same iteration
		}
		
		List<Person> persons = new ArrayList();
		persons.add(new Person("Bilal", 50));
		persons.add(new Person("Zahid", 60));
		persons.add(new Person("Ali", 20));
		
		
		Collections.sort(names2);
//		Collections.sort(persons);		// override sort method in Person class
		Collections.sort(persons, new PersonNameComparator());
		Collections.sort(persons, new PersonAgeComparator());
		// we can also use lambda expresssions or anonymous classes to create a flexible solution to above problems
		// instead of creating 2 new classes PersonNameComparator and PersonAgeComparator
		// like it is implemented below:
		
		// anonymous class for name comparison
		Comparator<Person> nameComp = new Comparator<Person>() {
			@Override
			public int compare(Person p1, Person p2) {
				return p1.getName().compareTo(p2.getName());
			}
		};
		
		Collections.sort(persons, nameComp);
		
		// through lambda expression
		Comparator<Person> nameComparator = (per1, per2) -> per1.getName().compareTo(per2.getName());
		Collections.sort( persons, nameComparator);
		// or
		Collections.sort( persons, (per1, per2) -> per1.getName().compareTo(per2.getName()) );
		
	}
	
}

