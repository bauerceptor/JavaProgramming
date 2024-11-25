package class10_generics_and_enums;

public enum ShirtColor {
	// without abstract method(s)
	//	RED, GREEN, BLUE, WHITE;		// each color is treated as a instances of this ShirtColor enumeration
	
	// with abstract method
//	RED {
//		@Override
//		public int getColorCode() {
//			return 1;
//		}
//	},
//	
//	BLUE {
//		@Override
//		public int getColorCode() {
//			return 2;
//		}
//	},
//	
//	WHITE {
//		@Override
//		public int getColorCode() {
//			return 3;
//		}
//	};
	
	
	// with abstract method AND constructor
	RED(10) {
		@Override
		public int getColorCode() {
			return 1;
		}
	},
	
	BLUE(20) {
		@Override
		public int getColorCode() {
			return 2;
		}
	},
	
	WHITE(30) {
		@Override
		public int getColorCode() {
			return 3;
		}
	};
	

	private int rate;		// constructor attribute
	
	// constructor below
	private ShirtColor(int rate) {
		this.rate = rate;
	}
	
	// normal method in enumeration
	public String toLowerCase() {
		return this.name().toLowerCase();
	}
	
	// abstract method in enumeration
	public abstract int getColorCode();
	
	// another normal method (getter) in enumeration, but this one returns the constructor attribute
	public int getRate() {
		return this.rate;
	}
}
