package vehicle;


public class Demo {
	public static void main(String[] args){
		Vehicle v1 = new Vehicle("Aran");
		System.out.println(v1);
		v1.getSource().fullCharge();
		v1.start();
	}
}
