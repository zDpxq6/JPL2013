package constant;


public enum FontSize{
	SMALL_FONT {
		@Override
		public Integer getFontSize() {
			return Constant.SMALL_FONT_SIZE;
		}

		@Override
		public String toString(){
			return name();
		}
	},

	MEDIUM_FONT {
		@Override
		public Integer getFontSize() {
			return Constant.MIDIUM_FONT_SIZE;
		}


		@Override
		public String toString(){
			return name();
		}
	},

	LARGE_FONT {
		@Override
		public Integer getFontSize() {
			return Constant.LARGE_FONT_SIZE;
		}

		@Override
		public String toString(){
			return name();
		}
	};

	public Integer getFontSize() {
		return -1;
	}


}
