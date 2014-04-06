package ex14_09;
/**
 * 練習問題16.9: 指定されたクラスの完全な宣言を表示するプログラムをリフレクションを使用して作成しなさい。
 * ただし、インポート文、コメント、それに、初期化子、コンストラクタ、メソッドのコードは除外します。
 * メンバー宣言は、ソースコードに書かれたように表示すべきです。
 * 今まで説明してきた全てのリフレクションクラスを使用する必要があるでしょう。
 * 多くのリフレクションオブジェクトのtoStringメソッドは、
 * 欲しい情報を正しい形式で提供しませんので、個々の情報を集めてまとめる必要があります。*/

public class Demo {
	public static void main(String[] args) {
		final Friendly jareth = new Friendly("jareth");
		final Friendly cory = new Friendly("cory");
		
		jareth.becomeFriend(cory);
		cory.becomeFriend(jareth);
		
		for(int i= 0; i< 1000; i++){
		new Thread(new Runnable() {
			public void run() {
				jareth.hug();
			}
		}, "Thread1").start();
		
		new Thread(new Runnable() {
			public void run() {
				cory.hug();
			}
		}, "Thread2").start();
		}
	}
}
