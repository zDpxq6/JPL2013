//(C) 2014 zDpxq6
package ex17_01;


public class Demo{
	//練習問題17.1
	//起動時と多くのオブジェクトを生成した後で、利用可能なメモリ量を調べるプログラムを書きなさい。
	//ガーベッジコレクタを呼び出して、空きメモリ量がどのように変化するかを調べなさい。
	//もちろん、新たに生成されたオブジェクトへの参照を間違いなく保持しないようにしてください。

	public static void main(String [] args){
		Runtime runtime = Runtime.getRuntime();
		Demo.printMemoryInformation(runtime);
		makeManyInstances();
		Demo.printMemoryInformation(runtime);
		runtime.gc();
		Demo.printMemoryInformation(runtime);
	}

	private static long[] getMemoryInformation(Runtime runtime){
		long free = runtime.freeMemory();
		long total = runtime.totalMemory();
		long[] result = {free, total};
		return result;
	}

	public static void printMemoryInformation(Runtime runtime){
		long[] memInfo = getMemoryInformation(runtime);
		System.out.printf("%f\t(%d/%d)\n",(double)memInfo[0]*100/memInfo[1],memInfo[0],memInfo[1]);
	}

	public static void makeManyInstances(){
		for(long i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; i++){
			new Long(Long.MAX_VALUE);
		}
	}

}