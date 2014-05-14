//(C) 2014 zDpxq6
package ex14_01;

public class Main {
	//練習問題14.1 mainを実行しているスレッドの名前を表示するプログラムを作成しなさい。
	public static void main(String[] args){
		System.out.println(Thread.currentThread().getName());
	}
}
