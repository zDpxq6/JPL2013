package Attr;

class ColorAttr extends Attr {
	private ScreenColor myColor;

	public ColorAttr(String name, Object value) {
		super(name, value);
		decodeColor();
	}

	public ColorAttr(String name) {
		this(name, "transparent");
	}

	public ColorAttr(String name, ScreenColor value) {
		super(name, value.toString());
		this.myColor = value;
	}

	@Override
	public Object setValue(Object newValue) {
		Object retval = super.setValue(newValue);
		decodeColor();
		return retval;
	}

	public ScreenColor setValue(ScreenColor newValue) {
		super.setValue(newValue.toString());
		ScreenColor oldValue = this.myColor;
		this.myColor = newValue;
		return oldValue;
	}

	public ScreenColor getColor() {
		return this.myColor;
	}

	protected void decodeColor() {
		if (getValue() == null) {
			this.myColor = null;
		} else {
			this.myColor = new ScreenColor(getValue());
		}
	}

	@Override
	public boolean equals(Object target) {
		if (target instanceof ColorAttr == false) {
			return false;
		}
		if(this.getName().equals(((ColorAttr) target).getName()) == false){
			return false;
		}
		if(this.getValue().equals(((ColorAttr) target).getValue()) == false){
			return false;
		}
		if(this.myColor.equals(((ColorAttr) target).getColor()) == false){
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int result = 17;
		result = result * 31 + this.getName().hashCode();
		result = result * 31 + this.getValue().hashCode();
		result = result * 31 + this.myColor.hashCode();
		return result;
	}
}
