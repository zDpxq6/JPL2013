package planefactory;

import factory.Actuator;

public class PropellerActuator implements Actuator{
	private static final String NAME = "propeller";
	private final int number;

	public PropellerActuator(int number){
		this.number = number;
	}

	@Override
	public String getActuator() {
		return this.number + "-" + NAME;
	}

}
