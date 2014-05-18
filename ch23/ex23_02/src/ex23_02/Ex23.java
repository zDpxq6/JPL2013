//(C) 2014 zDpxq6
package ex23_02;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * このクラスはプログラミング言語Javaの練習問題23.1,2,3解答用のクラスである
 *
 * */
// コマンドラインの引数に対してexecを実行して、コマンドから出力を表示するプログラムを作成しなさい。
// 各出力行の前には行番号を表示しなさい。
public class Ex23 {

	/**
	 * plugRunnableフィールドは、親プロセスの標準ストリームと 子プロセスの標準ストリームの結びつけを実際に行っているフィールドである。
	 * デフォルト値はPlugRunnableクラスである。
	 */
	private static PlugRunnable plugRunnable = new PlugRunnable();

	/**
	 * このメソッドは、親プロセスの標準ストリームを子プロセスの標準ストリームに結びつけるメソッドである。
	 * 親プロセスの標準ストリームを子プロセスの標準ストリームに結びつけた結果
	 * 、ユーザーがタイプした文字は指定されたプログラムへ送られてプログラムの出力はユーザーに見えるようになる。
	 *
	 * @param cmd
	 * @return 生成した子プロセス
	 * @throws IOException
	 */
	public static Process userProg(String cmd) throws IOException {
		Process proc = Runtime.getRuntime().exec(cmd);
		plugTogether(System.in, proc.getOutputStream());
		plugTogether(System.out, proc.getInputStream());
		plugTogether(System.err, proc.getErrorStream());
		return proc;
	}

	/**
	 * このメソッドは、1つのストリームからバイトを読みだして、 その読みだしたバイトをもう一つのストリームに書き込むことにより、
	 * 2つのストリームを結合するためのメソッドである。
	 *
	 * @param in
	 *            入力のInputStream
	 * @param outputStream
	 *            出力のOutputStream
	 * @throws InterruptedException
	 */
	public static void plugTogether(final InputStream in, final OutputStream outputStream) {
		plugRunnable.setStreams(in, outputStream);
		Thread th = new Thread(plugRunnable);
		try {
			th.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * このメソッドは、1つのストリームからバイトを読みだして、
	 * その読みだしたバイトをもう一つのストリームに書き込むことにより、2つのストリームを結合するためのメソッドである。
	 *
	 * @param out
	 *            出力のPrintStream
	 * @param inputStream
	 *            入力のInputStream
	 * @throws InterruptedException
	 */
	private static void plugTogether(final PrintStream out, final InputStream inputStream) {
		plugTogether(inputStream, out);
	}

	/**
	 * @return plugRunnable
	 */
	public static PlugRunnable getPlugRunnable() {
		return plugRunnable;
	}

	/**
	 * @param plugRunnable
	 *            セットする plugRunnable
	 */
	public static void setPlugRunnable(PlugRunnable plugRunnable) {
		Ex23.plugRunnable = plugRunnable;
	}
}
