package ex22_04;


public class Attribute{
	private final String name;
	private Object value = null;

	public Attribute(String name){
		this.name=name;
	}

	public Attribute(String name, Object value){
		this.name=name;
		this.value=value;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @return the value
	 */
	public Object getValue() {
		return this.value;
	}

	/**
	 * @param value the value to set
	 */
	public Object setValue(Object newValue) {
		Object oldValue = this.value;
		this.value = newValue;
		return oldValue;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.name + "='" + this.value + "'";
	}

}