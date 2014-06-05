package constant;


public enum FontSize{
	SMALL_FONT {
		@Override
		public int getFontSize() {
			return Const.SMALL_FONT_SIZE;
		}

		@Override
		public String toString(){
			return name();
		}
	},

	MEDIUM_FONT {
		@Override
		public int getFontSize() {
			return Const.MIDIUM_FONT_SIZE;
		}


		@Override
		public String toString(){
			return name();
		}
	},

	LARGE_FONT {
		@Override
		public int getFontSize() {
			return Const.LARGE_FONT_SIZE;
		}

		@Override
		public String toString(){
			return name();
		}
	};

	public int getFontSize() {
		return 0;
	}


}
