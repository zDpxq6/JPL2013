package font;

import consta.Const;

public enum FontSize {
	LARGE(Const.FONT_SIZE_LARGE),
	SMALL(Const.FONT_SIZE_SMALL);

	private int value;

	FontSize( int value) {
		this.value = value;
	}

	public int getValue( ) {
		return this.value;
	}
}
