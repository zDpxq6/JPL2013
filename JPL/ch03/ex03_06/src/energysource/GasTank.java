package energysource;

public class GasTank extends EnergySource {
	@Override
	public
	boolean empty(){
		return getEnergySource() == EMPTY;
	}

	@Override
	public void fullCharge(){
		System.out.println("給油");
		setEnergySource(FULL);
	}

}
