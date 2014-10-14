package energysource;

public class Battery extends EnergySource {

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
}
