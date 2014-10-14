package energysource;

public abstract class EnergySource {
	protected static final int EMPTY = 0;
	protected static final int FULL = 100;
	private int energySource = 0;

	public abstract boolean empty();

	public abstract void fullCharge();

	/**
	 * @return the energySource
	 */
	public int getEnergySource() {
		return this.energySource;
	}

	/**
	 * @param energySource
	 *            the energySource to set
	 */
	public void setEnergySource(int energySource) {
		if (FULL < energySource || energySource <= EMPTY) {
			throw new IllegalArgumentException();
		} else {
			this.energySource = energySource;
		}
	}
}
