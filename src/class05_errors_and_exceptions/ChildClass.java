package class05_errors_and_exceptions;

public class ChildClass extends ParentClass {
	
	int i = 10;
	
	public ChildClass() {
//		super();
		super("test message");
		System.out.println("Child class" + super.i);
	}
	
	public ChildClass(int n) {
		this();
//		super("message");
//		System.out.println("abcdef");
//		this.i;
	}
	
	@Override
	public void myMethod1() {			// it is not necessary in java to also override parent method's thrown exception
		
	}
	
//	@Override
//	public void myMethod() throws Exception {	
//		
//	}
}
