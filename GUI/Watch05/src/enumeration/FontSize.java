package enumeration;

import constant.Const;


public enum FontSize implements constant.EnumInterfaceforClient<Integer>{
	SMALL_FONT {

		@Override
		public Integer getValue() {
			return Const.SMALL_FONT_SIZE;
		}
	},

	MEDIUM_FONT {


		@Override
		public Integer getValue() {
			return Const.MIDIUM_FONT_SIZE;
		}
	},

	LARGE_FONT {
		@Override
		public Integer getValue() {
			return Const.LARGE_FONT_SIZE;
		}
	};

}
