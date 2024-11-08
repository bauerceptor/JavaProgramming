package generics_and_enums_class10;

public class Shirt {
	private ShirtColor color;	// shirt can only have four colors: red, green, blue or white
	
	public Shirt() {
		
	}

	public ShirtColor getColor() {
		return this.color;
	}

	public void setColor(ShirtColor color) {
		
		
//		if (color.equals("red"))
		this.color = color;
	}
	
}
