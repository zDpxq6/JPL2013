//(C) 2014 zDpxq6
package ex23_01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * このクラスは入力ストリームと出力ストリームの結びつけを行うクラスである
 * @author zDpxq6
 *
 */
public class PlugRunnable implements Runnable {
	private static final String ERROR_CODE = "streams has not be initialized";
	protected InputStream in;
	protected OutputStream out;

	/**
	 * コンストラクタ PlugRunnableおよびそのサブタイプは、フィールドが空の状態では責務を果たせないため、
	 * setStreamsメソッドでフィールドを設定する必要がある。
	 */
	// ただし、実装上PlugRunnableおよびそのサブタイプ生成時にはフィールドがどのようになるかわからない。
	// したがってフィールドを引数に持つコンストラクタは作っていない。
	public PlugRunnable() {
		super();
	}

	/**
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		if (this.in == null || this.out == null) {
			throw new NullPointerException(ERROR_CODE);
		}
		plug(this.in, this.out);
	}

	/**
	 * このメソッドは入力ストリームと 出力ストリームの結びつけを行う
	 *
	 * @param in
	 *            入力ストリーム
	 * @param out
	 *            出力ストリーム
	 */
	protected void plug(InputStream in, OutputStream out) {
		synchronized (in) {
			synchronized (out) {
				try {
					execute();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * このメソッドは結びつけた2つのストリームに対し、何らかの動作を行う
	 * @throws IOException
	 */
	protected void execute() throws IOException{
		int read;
		while ((read = this.in.read()) != -1) {
			this.out.write(read);
		}
	}

	/**
	 * このメソッドはフィールドを設定する
	 *
	 * @param in
	 *            入力ストリーム
	 * @param out
	 *            出力ストリーム
	 */
	public void setStreams(InputStream in, OutputStream out) {
		this.in = in;
		this.out = out;
	}
}
