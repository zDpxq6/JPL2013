package carfactory;

import factory.Actuator;

public class TireActuator implements Actuator{
	private static final String NAME = "tire";
	private final int number;

	public TireActuator(int number){
		this.number = number;
	}

	@Override
	public String getActuator() {
		return this.number + "-" + NAME;
	}

}
