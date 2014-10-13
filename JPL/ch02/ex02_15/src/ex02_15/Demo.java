package ex02_15;

public class Demo {
	public static void main(String[] args){
		Vehicle v1 = new Vehicle(1.1, Direction.N, "Aran");
		System.out.println(v1);
		v1.changeSpeed(100);
		System.out.println(v1);
		v1.stopVehicle();
		System.out.println(v1);
	}
}
