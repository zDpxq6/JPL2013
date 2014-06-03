package consta;


public enum FontSize{
	SMALL_FONT {
		@Override
		public Integer getFontSize() {
			return Const.SMALL_FONT_SIZE;
		}

		@Override
		public String toString(){
			return name();
		}
	},

	MEDIUM_FONT {
		@Override
		public Integer getFontSize() {
			return Const.MIDIUM_FONT_SIZE;
		}


		@Override
		public String toString(){
			return name();
		}
	},

	LARGE_FONT {
		@Override
		public Integer getFontSize() {
			return Const.LARGE_FONT_SIZE;
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
