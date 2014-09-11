package ex22_06;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;


public class Demo {
	public static void main(String args[]) {
		Random random = new Random();
		Demo d = new Demo();
		Map tmp = d.generateNextGaussian(1000);
		d.showResult(tmp);
		System.out.println("end");
	}

	public Map<Integer, Integer> generateNextGaussian(int times) {
		Map<Integer, Integer> result = new HashMap<Integer, Integer>();
		Random random = new Random();
		int 結果;
		Integer count;
		for (int i = 0; i < times; i++) {
			結果 = (int) Math.round(random.nextGaussian());
			count = result.get(結果);
			count = null == result.get(結果) ? 0 : count;
			result.put(結果,count + 1);
//			count =  count == null ? 1 :count++;
//			result.put(total,count);
		}
		return result;
	}

	public void showResult(Map<Integer,Integer>result){
		Map<Integer,Integer>newResult = new TreeMap<Integer,Integer>();
		newResult.putAll(result);
		for(int l = -300; l <= 300; l++){
			System.out.printf("%4d:",l);
			Integer value = newResult.get(l);
			if( value != null) {
				for(int i = 0; i < value; i++){
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
}
