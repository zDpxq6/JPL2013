package energysource;

public class Battery implements EnergySource {
	private int battery;

	@Override
	public
	boolean empty(){
		return getEnergySource() == EMPTY;
	}

	@Override
	public void fullCharge(){
		System.out.println("充電");
		setEnergySource(FULL);
	}

	/**
	 * @return the energySource
	 */
	@Override
	public int getEnergySource() {
		return this.battery;
	}

	/**
	 * @param energySource
	 *            the energySource to set
	 */
	@Override
	public void setEnergySource(int energySource) {
		if (FULL < energySource || energySource <= EMPTY) {
			throw new IllegalArgumentException();
		} else {
			this.battery = energySource;
		}
	}
}
