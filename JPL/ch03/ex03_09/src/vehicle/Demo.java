package vehicle;

public class Demo {
	public static void main (String[] args){
		Vehicle vehicle01 = new Vehicle(0, Direction.N , "Taro") ;
		Vehicle vehicle02 = new Vehicle(0, Direction.N , "Jiro") ;
		Vehicle vehicle03 = new Vehicle(0, Direction.N , "Thabro") ;

		Garage garage01 = new Garage(vehicle01, vehicle02, vehicle03);
		Garage garage02 = garage01.clone();
		System.out.println(garage01);
		System.out.println(garage02);
		Vehicle[] garage = garage02.getGarage();
		garage[0] = vehicle03;
		System.out.println(garage02);
	}
}