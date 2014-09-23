package planefactory;

import factory.Actuator;
import factory.Controller;
import factory.Factory;
import factory.Vehicle;

public final class PlaneFactory extends Factory{
	@Override
	public Vehicle createVehicle(Controller controller, Actuator actuator){
		return new PlaneVehicle(controller, actuator);
	}
	@Override
	public Controller createController(){
		return new StickController();
	}
	@Override
	public Actuator createActuator(int number){
		return new PropellerActuator(number);
	}
}
