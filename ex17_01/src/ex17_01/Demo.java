package ex17_01;

public class Demo{
	/**起動時と多くのオブジェクトを生成した後で、利用可能なメモリ量を調べるプログラムを書きなさい。
	  *ガーベッジコレクタを呼び出して、空きメモリ量がどのように変化するかを調べなさい。
	  *もちろん、新たに生成されたオブジェクトへの参照を間違いなく保持しないようにしてください。*/
	
	public static void main(String [] args){
		Demo.fullGc();
		Demo.getMemoryInformation();
		makeManyInstances();
		Demo.getMemoryInformation();
		Demo.fullGc();
		Demo.getMemoryInformation();
	}
	
	public static void getMemoryInformation(){
		Runtime runtime = Runtime.getRuntime();
		long free = runtime.freeMemory();
		long total = runtime.totalMemory();
		System.out.println((double)free*100/total+"\t("+free + "/" + total+")");
	}
	
	public static void fullGc() {
		Runtime runtime = Runtime.getRuntime();
		long isFree = runtime.freeMemory();
		long wasFree;
		do {
			wasFree = isFree;
			runtime.runFinalization();
			runtime.gc();
			wasFree = runtime.freeMemory();
		} while (isFree > wasFree );
	}
	
	public static void makeManyInstances(){
		for(int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; i++){
			new Double(Double.MAX_VALUE);
		}
	}

}
