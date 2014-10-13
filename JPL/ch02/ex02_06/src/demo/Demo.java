package demo;

import vehicle.Direction;
import vehicle.Vehicle;
import ex02_06.LinkedList;

public class Demo {
	public static void main(String[] args){
		Vehicle v1 = new Vehicle(1.1, Direction.N, "Aran");
		Vehicle v2 = new Vehicle(0, Direction.E, "Jhon");
		LinkedList list = new LinkedList();
		list.add(v1);
		list.add(v2);
		System.out.println(list);
}
}
