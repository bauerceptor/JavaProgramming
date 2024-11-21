package class05_error_handling;

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
	

}
