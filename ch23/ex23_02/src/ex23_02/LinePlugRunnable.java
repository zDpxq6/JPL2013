package ex23_02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

//コマンドラインの引数に対してexecを実行して、コマンドから出力を表示するプログラムを作成しなさい。
//各出力行の前には行番号を表示しなさい。
public class LinePlugRunnable extends PlugRunnable {
	private static final String LINE_SEPARATOR = System.getProperty("line.separator");
	private static final String SEPARATOR = ": ";
	private BufferedReader bufferedReader;
	private BufferedWriter bufferedWriter;

	/**
	 * コンストラクタ PlugRunnableおよびそのサブタイプは、フィールドが空の状態では責務を果たせないため、
	 * setStreamsメソッドでフィールドを設定する必要がある。
	 */
	// ただし、実装上PlugRunnableおよびそのサブタイプ生成時にはフィールドがどのようになるかわからない。
	// したがってフィールドを引数に持つコンストラクタは作っていない。
	public LinePlugRunnable() {
		super();
	}

	/**
	 * @see ex23_03.PlugRunnable#plug(java.io.InputStream, java.io.OutputStream)
	 */
	@Override
	protected void plug(InputStream in, OutputStream out) {
		synchronized (this.in) {
			synchronized (this.out) {
				try {
					execute();
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * @see ex23_03.PlugRunnable#execute()
	 */
	@Override
	protected void execute() throws IOException {
		String readLine;
		int i = 0;
		while ((readLine = this.bufferedReader.readLine()) != null) {
			this.bufferedWriter.write(i++ + SEPARATOR + readLine + LINE_SEPARATOR);
			this.bufferedWriter.flush();
		}
	}

	/**
	 * @see ex23_03.PlugRunnable#setStreams(java.io.InputStream,
	 *      java.io.OutputStream)
	 */
	@Override
	public void setStreams(InputStream in, OutputStream out) {
		if (in == null || out == null) {
			throw new NullPointerException();
		}
		this.bufferedReader = new BufferedReader(new InputStreamReader(this.in = in));
		this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(this.out = out));
	}

}
