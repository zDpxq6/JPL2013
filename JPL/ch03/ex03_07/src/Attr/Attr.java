package Attr;
public class Attr {
	private final String name;
	private Object value = null;

	public Attr(String name) {
		this(name, null);
	}

	public Attr(String name, Object value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return this.name;
	}

	public Object getValue() {
		return this.value;
	}

	public Object setValue(Object newValue) {
		Object oldval = this.value;
		this.value = newValue;
		return oldval;
	}

	@Override
	public String toString() {
		return this.name + " = '" + this.value + "'";
	}

}