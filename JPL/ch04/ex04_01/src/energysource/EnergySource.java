package energysource;

public abstract interface EnergySource {
	static final int EMPTY = 0;
	static final int FULL = 100;

	public abstract boolean empty();

	public abstract void fullCharge();

	/**
	 * @return the energySource
	 */
	public int getEnergySource();

	/**
	 * @param energySource
	 *            the energySource to set
	 */
	public void setEnergySource(int energySource);
}
