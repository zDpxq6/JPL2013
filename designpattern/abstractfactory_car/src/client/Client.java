package client;

import planefactory.PropellerActuator;
import carfactory.CarVehicle;
import carfactory.TireActuator;
import carfactory.WheelController;
import factory.Actuator;
import factory.Controller;
import factory.Factory;
import factory.Vehicle;

public class Client {
	public static void main(String[] args){
		//自動車をインスタンス化する場合、
		//クライアントは自ら部品(ハンドル(wheel), タイヤ(tire))を選択・生成し、インスタンス化することができる
		CarVehicle car = new CarVehicle(new WheelController(), new TireActuator(4));
		car.move();

		//しかし、クライアントが部品を間違うと、予期しないインスタンスができる。
		CarVehicle strangeCar = new CarVehicle(new WheelController(), new PropellerActuator(4));
		strangeCar.move();//空飛ぶ車??

		//AbstractFactoryパターンを使ってインスタンス化する場合、
		//部品の生成はFactoryおよびConcreteFactoryの責務なので、クライアントは部品を間違えない(間違えようがない)
		Factory carFactory = Factory.getFactory("carfactory.CarFactory");//Factoryの具象クラスを設定すると
		Actuator actuator = carFactory.createActuator(4);//タイヤも
		Controller controller =carFactory.createController();//ハンドルもファクトリーが提供してくれる
		Vehicle newCar = carFactory.createVehicle(controller,actuator);
		newCar.move();
	}
}
