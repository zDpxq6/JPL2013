//(C) 2014 zDpxq6
package ex01_12;


//練習問題1.12 ImprovedFibonacciを修正してprintlnで文字列を直接表示するのではなく、Stringオブジェクトを作成して配列に入れるようにしてみてください
public class Demo {
	private static final String TITLE = "*****Output*****";
	private static final int TERMINATING_CONDITION = 50;

	public static void main(String[] args) {
		AlteredImprovedFibonacci altFib = AlteredImprovedFibonacci.createAlteredFibonacci(TERMINATING_CONDITION);
		System.out.println(TITLE);
		Object[] resultList= Utility.analyzeList(altFib.getFibonacci(), new EvenMarkFilter<Integer>(null));
		Utility.printList(resultList);
	}
}
