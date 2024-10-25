package exercise_class02;

public class Circle extends Shape {
	double radius;
	
	public Circle(double radius) {
		this.radius = radius;
	}
	
	@Override
	public void draw() {
		System.out.println("Drawing a circle.");
	}

	@Override
	public double calcArea() {
		return (3.141569 * (radius * radius));
	}

}
