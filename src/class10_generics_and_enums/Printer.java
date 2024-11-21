package class10_generics_and_enums;

public class Printer<T> {		// T is any type, a generic type or place-holder, which will be decided by the user while calling/using this class
	private T t;		// t variable will be of type T where T will be replaced with the actual type used while calling/using this class
	
	public Printer(T t) {
		this.t = t;
	}
	
//	public void print() {
//		System.out.println(this.t);
//	}
	
	public void print() {
		System.out.println( this.t.getClass().getName() );
	}

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
	
	
}
