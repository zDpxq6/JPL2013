package Attr;
class ScreenColor{
	private final Object color;

	ScreenColor(Object color) {
		this.color = color;
	}

	public Object getScreenColor() {
		return this.color;
	}

	@Override
	public boolean equals(Object target){
		if(target instanceof ScreenColor == false){
			return false;
		}
		return this.color.equals(((ScreenColor)target).getScreenColor());
	}


	@Override
	public int hashCode() {
		int result = 17;
		result = result * 31 + this.color.hashCode();
		return result;
	}
}