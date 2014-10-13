package benchmark;
import java.util.ArrayList;
import java.util.List;


public class ArrayListBenchmark extends Benchmark{
	private static final int MAX = 10000;
	private final List<Integer>list = new ArrayList<Integer>();
	{
		for(int i = 0; i < MAX; i++){
			this.list.add(i);
		}
	}
	@Override
	void benchmark() {
		for(Integer e:this.list){
//			System.out.println(e);
		}

	}
}
