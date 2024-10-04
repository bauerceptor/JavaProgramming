package Lambda;

public class TestClass {
	
	public static void main(String args[]) {
		
//		TestInterface fi = new TestInterface() {
//			@Override
//			public String printSomething(String msg) {
//				return "Hello world & " + msg;
//			}
//		};
//		
//		System.out.println( fi.printSomething(" today is Friday"));
	
//		TestInterface addNum = (num1, num2) -> num1 + num2;
//		int msg = addNum.operate(10, 4);
//		System.out.println(msg);
//		
//		TestInterface multiplyNum = (num1, num2) -> num1 * num2;
//		int msg2 = multiplyNum.operate(10, 4);
//		System.out.println(msg2);
		
		StringInterface toUpper = (str) -> str.toUpperCase();
		String output = toUpper.operate("SaMplE stRing");
		System.out.println(output);
		
		StringInterface toLower = (str) -> str.toLowerCase();
		String output2 = toLower.operate("SaMplE stRing");
		System.out.println(output2);
		
		
	}
	
	
}
