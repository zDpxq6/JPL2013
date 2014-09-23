package factory;

public abstract class Factory {
	public static Factory getFactory(String className){
		Factory factory = null;
		try{
			factory = (Factory)Class.forName(className).newInstance();
		}catch(ClassNotFoundException e){
			System.err.println("クラス" + className + "がみつかりません。");
		}catch(Exception e){
			e.printStackTrace();
		}
		return factory;
	}

	public abstract Vehicle createVehicle(Controller controller, Actuator actuator);
	public abstract Controller createController();
	public abstract Actuator createActuator(int number);
}
