package class10_generics_and_enums;

public class GenClass2<T extends Number> {
	private T t;		// compiler will automatically change this code to -> private Number t;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
	
	
}
