package energysource;

public class GasTank implements EnergySource {
	int energySource;

	@Override
	public boolean empty() {
		return getEnergySource() == EMPTY;
	}

	@Override
	public void fullCharge() {
		System.out.println("給油");
		setEnergySource(FULL);
	}

	/**
	 * @return the energySource
	 */
	@Override
	public int getEnergySource() {
		return this.energySource;
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
			this.energySource = energySource;
		}
	}

}
