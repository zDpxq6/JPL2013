package carfactory;

import java.util.Calendar;

import factory.Actuator;
import factory.Controller;
import factory.Factory;
import factory.Vehicle;

public final class CarFactory extends Factory {
	@Override
	public Vehicle createVehicle(Controller controller, Actuator actuator) {
		return new CarVehicle(controller, actuator);
	}

	@Override
	public Controller createController() {
		return new WheelController();
	}

	@Override
	public Actuator createActuator(final int number) {
		return new Actuator() {
			@Override
			public String getActuator() {
				int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
				StringBuffer result = new StringBuffer(Integer.toString(number));
				result.append("-");
				if(11 <= month || month < 5){
					result.append("studless ");
				}
				result.append("tire");
				return result.toString();
			}
		};
	}
}
