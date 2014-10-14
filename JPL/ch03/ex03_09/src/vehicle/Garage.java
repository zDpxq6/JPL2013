package vehicle;

public final class Garage implements Cloneable {
	private static final String SEPARATOR = ", ";
	static final int MAX = 2;
	private Vehicle[] garage = new Vehicle[MAX];

	/**
	 * @return the garage
	 */
	public Vehicle[] getGarage() {
		return this.garage;
	}

	/**
	 * @param garage the garage to set
	 */
	public void setGarage(Vehicle[] garage) {
		this.garage = garage;
	}

	public Garage(Vehicle... vehicle) {
		int i = 0;
		while (i < this.garage.length) {
			this.garage[i] = vehicle[i];
			i++;
		}
	}

	@Override
	public Garage clone() {
		try {
			Garage result = (Garage) super.clone();
			Vehicle[] newGarage = new Vehicle[MAX];
			int i = 0;
			for (Vehicle e : this.garage) {
				newGarage[i++] = (Vehicle) e.clone();
			}
			result.garage = newGarage;
			return result;
		} catch (CloneNotSupportedException e) {
			throw new InternalError();
		}
	}

	@Override
	public String toString() {
		StringBuilder strBld = new StringBuilder("{");
		for(Vehicle e:this.garage){
			strBld.append(e.toString());
			strBld.append(SEPARATOR);
		}
		strBld.delete(strBld.length()-SEPARATOR.length(),strBld.length()-1);
		strBld.append("}");
		return strBld.toString();
	}
}
