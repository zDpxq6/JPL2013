package benchmark;
public class Demo {
	public static void main(String[] args) {
		int count = Integer.parseInt(args[0]);

		long time = new ArrayListBenchmark().repeat(count);

		System.out.println(count + " methods in " + time + " nanoseconds");

		count = Integer.parseInt(args[0]);

		time = new LinkedListBenchmark().repeat(count);

		System.out.println(count + " methods in " + time + " nanoseconds");

	}
}
