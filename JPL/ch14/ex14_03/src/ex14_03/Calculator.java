//(C) 2014 zDpxq6
package ex14_03;
//現在の値を保持し、その値に加算して新たな値を表示するメソッドを持つオブジェクトのクラスを作成しなさい。
//そのオブジェクトを作成し、複数のスレッドを生成して、各スレッドからその加算メソッドを繰り返し呼び出すプログラムを作成しなさい。
//加算の結果が失われないようにそのクラスを作成しなさい。

public class Calculator {
	private int value;

	/**
	 * このメソッドは、加算を繰り返すメソッドである。
	 * @param value 新たに加える数
	 */
	public void add(int value){
		synchronized(this){
			this.value += value;
			System.out.println("add: " + this.value);
		}
	}
}
