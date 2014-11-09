enum SignalEnum {
	GREEN("GREEN"){
		@Override
		public Color getColor(){
			return new Color(0,255,0);
		}
	},
	YELLOW("YELLOW"){
		@Override
		public Color getColor(){
			return new Color(255,255,0);
		}
	},
	RED("RED"){
		@Override
		public Color getColor(){
			return new Color(0,255,0);
		}
	},;

	String name;

	SignalEnum(String name) {
		this.name = name;
	}

	abstract Color getColor();

	public static class Color{
		private final int red;
		private final int green;
		private final int blue;
		public Color(int r, int g, int b){
			this.red = r;
			this.green = g;
			this.blue = b;
		}
	}

}

