package ex02_07;


public class Demo {
	public static void main(String[] args){
		Vehicle v1 = new Vehicle(1.1, Direction.N, "Aran");
		v1.setSpeed(1.1);
		v1.setDirection(Direction.N);
		System.out.println(v1);
		Vehicle v2 = new Vehicle();
		v2.setOwner("Jhon");
		v2.setSpeed(0);
		v2.setDirection(Direction.E);
		System.out.println(v2);
	}
}
