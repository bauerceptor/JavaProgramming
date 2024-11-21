package class10_generics_and_enums;

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

	public void setColor(class10_generics_and_enums.sample_generics.ShirtColor red) {
		// TODO Auto-generated method stub
		
	}
	
}
