package exercise_class05;


public class TestClass5 {
	
	public static void main(String args[]) {
		OddEvenCheckInterface testEven = num -> num % 2 == 0;
		boolean even1 = testEven.isEven(4);
		boolean even2 = testEven.isEven(5);
		boolean even3 = testEven.isEven(15);
		boolean even4 = testEven.isEven(26);
		
		System.out.println(even1);
		System.out.println(even2);
		System.out.println(even3);
		System.out.println(even4);
		
		
	}
	
	
	
}
