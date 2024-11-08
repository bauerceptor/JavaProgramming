package exercise_class10;

import java.util.Arrays;

public class TestClass {
	
	public static void main(String args[]) {
//		GenericArray<String> list = new GenericArray();
		
		Integer[] nums = {1, 2, 3, 4, 5, 6};
		nums = replaceArrayItemAtIndexAndReturn(nums, 4, 1);
		System.out.println( Arrays.toString(nums) );
		
		String[] editors = {"vim", "eclipse", "intellij", "vscode"};
		replaceArrayItemAtIndex(editors, 0, 2);
		System.out.println( Arrays.toString(editors) );
		
	}
	
	public static <T> T[] replaceArrayItemAtIndexAndReturn( T[] t, int index1, int index2 ) {
		T temp = t[index1];
		t[index1] = t[index2];
		t[index2] = temp;
		
		return t;
		
	}
	
	public static <T> void replaceArrayItemAtIndex( T[] t, int index1, int index2 ) {
		T temp = t[index1];
		t[index1] = t[index2];
		t[index2] = temp;
		
	}
}
