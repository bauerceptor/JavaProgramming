package class07_collections;

import java.util.Comparator;

public class PersonAgeComparator implements Comparator<Person>{
	
	
	@Override
	public int compare(Person p1, Person p2) {
		return new Integer(p1.getAge()).compareTo(p2.getAge());
	}
}

