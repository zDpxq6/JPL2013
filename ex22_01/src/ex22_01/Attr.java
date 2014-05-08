package ex22_01;

public class Attr {
	private final String name;
	private Object value = null;

	public Attr(String name){
		this.name = name;
	}

	public Attr(String name, Object value){
		this.name = name;
		this.setValue(value);
	}

	public String getName() {
		return this.name;
	}

	public Object getValue() {
		return this.value;
	}

	private Object setValue(Object newValue) {
		Object oldVal = this.value;
		this.value = newValue;
		return oldVal;
	}

	@Override
	public String toString(){
		return this.name + "=" + this.value + "'";
	}


}
