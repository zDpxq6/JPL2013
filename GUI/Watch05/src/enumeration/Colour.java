package enumeration;

import java.awt.Color;

import constant.EnumInterfaceforClient;

public enum Colour implements EnumInterfaceforClient<java.awt.Color>{

	RED {
		@Override
		public Color getValue() {
			return java.awt.Color.RED;
		}
	},

	BLUE {
		@Override
		public Color getValue() {
			return java.awt.Color.BLUE;
		}
	},

	YELLOW {
		@Override
		public Color getValue() {
			return java.awt.Color.YELLOW;
		}
	},

	GREEN {
		@Override
		public Color getValue() {
			return java.awt.Color.GREEN;
		}
	},

	WHITE {
		@Override
		public Color getValue() {
			return java.awt.Color.WHITE;
		}
	},

	BLACK {
		@Override
		public Color getValue() {
			return java.awt.Color.BLACK;
		}
	};

}
