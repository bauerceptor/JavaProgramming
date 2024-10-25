package lambda_class04;

public class TestClass4 {
	
	public static void main(String args[]) {
		
//		TestInterface fi = new TestInterface() {
//			@Override
//			public String printSomething(String msg) {
//				return "Hello world & " + msg;
//			}
//		};
//		
//		
//		System.out.println( fi.printSomething("today is Friday"));
	
		
//		----------------------------------------
		
//		Testing TestInterface below
		
//		----------------------------------------
		
		TestInterface addNum = (num1, num2) -> num1 + num2;
		int msg = addNum.operate(10, 4);
		System.out.println(msg);
		
		TestInterface multiplyNum = (num1, num2) -> num1 * num2;
		int msg2 = multiplyNum.operate(10, 4);
		System.out.println(msg2);
		
		
//		----------------------------------------
		
//		Testing StringFormatter below
		
//		----------------------------------------
		
		StringFormatter toUpper = str -> str.toUpperCase();
		String output = toUpper.operate("SaMplE stRing");
		System.out.println(output);
		
		StringFormatter toLower = (str) -> str.toLowerCase();
		String output2 = toLower.operate("SaMplE stRing");
		System.out.println(output2);
		
		
//		----------------------------------------
		
//		Testing EmailValidator below
		
//		----------------------------------------

		EmailValidator emailValidate = (str) -> str.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
		System.out.println(emailValidate.validate("person@gmail.com"));
		System.out.println(emailValidate.validate("person2gmail.com"));
		
		
		EmailValidator lengthValidate = (str) -> str.length() > 8;
		System.out.println(lengthValidate.validate("random"));
		System.out.println(lengthValidate.validate("person3@gmail.com"));

		
	
		EmailValidator emailValidateWithLength = (str) -> {
			if (str.length() > 8 && str.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
				return true;
			} else {
				return false;
			}
		};
		
	
	}
	
	
}
