package class10_generics_and_enums;

public class Printer2<T, V> {
	private T t;		// t variable will be of type T where T will be replaced with the actual type used while calling/using this class
	private V v;
	
	public Printer2(T t, V v) {
		this.t = t;
		this.v = v;
	}
	
	public void print() {
		System.out.println(this.t + " " + this.v);
	}

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

	public V getV() {
		return v;
	}

	public void setV(V v) {
		this.v = v;
	}
}
