package class05_errors_and_exceptions;

public class ParentClass {
	
	int i = 4;
	
	public ParentClass() {
		System.out.println("Parent class");
	}
	
	public ParentClass(String msg) {
		System.out.println("Parent class " + msg);
	}
	
	public void myMethod() throws MyException {
		
	}

	public void myMethod1() {
		// TODO Auto-generated method stub
		
	}
	

}