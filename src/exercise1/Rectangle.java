package exercise1;

public class Rectangle extends Shape {
	float length;
	float width;
	
	public Rectangle(float length, float width) {
		this.length = length;
		this.width = width;
	}
	
	
	@Override
	public void draw() {
		System.out.println("Drawing a rectangle.");
	}

	@Override
	public double calcArea() {
		return width * length;
	}

}
