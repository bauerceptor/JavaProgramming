package generics_and_enums_class10;

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
	
	// constructor below
	private int rate;
	
	private ShirtColor(int rate) {
		this.rate = rate;
	}
	
	// enums can also have methods
	public String toLowerCase() {
		return this.name().toLowerCase();
	}
	
	// abstract method in enumeration
	public abstract int getColorCode();
	
	public int getRate() {
		return this.rate;
	}
}
