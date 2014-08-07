package constant;

import java.awt.Color;

public enum Colour{
	RED {
		String getName() {
			return "RED";
		}

		@Override
		public java.awt.Color getColour() {
			return java.awt.Color.RED;
		}

		@Override
		public String toString(){
			return getName();
		}
	},

	BLUE {
		String getName() {
			return "BLUE";
		}

		@Override
		public java.awt.Color getColour() {
			return java.awt.Color.BLUE;
		}

		@Override
		public String toString(){
			return getName();
		}
	},

	YELLOW {
		String getName() {
			return "YELLOW";
		}

		@Override
		public java.awt.Color getColour() {
			return java.awt.Color.YELLOW;
		}

		@Override
		public String toString(){
			return getName();
		}
	},

	GREEN {
		String getName() {
			return "GREEN";
		}

		@Override
		public java.awt.Color getColour() {
			return java.awt.Color.GREEN;
		}

		@Override
		public String toString(){
			return getName();
		}
	}

	,WHITE {
		String getName() {
			return "WHITE";
		}

		@Override
		public java.awt.Color getColour() {
			return java.awt.Color.WHITE;
		}

		@Override
		public String toString(){
			return getName();
		}
	},

	BLACK {
		String getName() {
			return "BLACK";
		}

		@Override
		public java.awt.Color getColour() {
			return java.awt.Color.BLACK;
		}

		@Override
		public String toString(){
			return getName();
		}
	};

	public Color getColour() {
		return null;
	}

}
