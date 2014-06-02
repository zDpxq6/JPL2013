//(C) 2014 zDpxq6
package ex14_03;
//現在の値を保持し、その値に加算して新たな値を表示するメソッドを持つオブジェクトのクラスを作成しなさい。
//そのオブジェクトを作成し、複数のスレッドを生成して、各スレッドからその加算メソッドを繰り返し呼び出すプログラムを作成しなさい。
//加算の結果が失われないようにそのクラスを作成しなさい。
public class Demo {
	private static final int[] DEMO_ARRAY = {1,2,3,4,5};
	private static final Calculator DEMO_TARGET = new Calculator();

	public static void main(String[] args){
		for(int i = 0; i < DEMO_ARRAY.length; i++){
			new Thread(new ExecuterRunable(DEMO_TARGET, DEMO_ARRAY[i])).start();
		}
	}
}
