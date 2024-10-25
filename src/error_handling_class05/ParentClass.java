package error_handling_class05;

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
