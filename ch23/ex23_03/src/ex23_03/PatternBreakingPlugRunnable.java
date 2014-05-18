//(C) 2014 zDpxq6
package ex23_03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.regex.Pattern;

/**
 * このクラスは入力ストリームと出力ストリームの結びつけを行うクラスである。
 * 出力に特定の文字列がある場合、コマンドを終了する。
 * @author zDpxq6
 *
 */
//コマンドラインの引数に対してexecを実行して、コマンドから出力を表示するプログラムを作成しなさい。
//出力中に特定の文字列が現れたらそのコマンドを終了させるようにしなさい。
public class PatternBreakingPlugRunnable extends PlugRunnable {
	private BufferedReader bufferedReader;
	private BufferedWriter bufferedWriter;
	private final Pattern pattern;

	/**
	 * コンストラクタ PlugRunnableおよびそのサブタイプは、フィールドが空の状態では責務を果たせないため、
	 * setStreamsメソッドでフィールドを設定する必要がある。
	 */
	// ただし、実装上PlugRunnableおよびそのサブタイプ生成時にはフィールドがどのようになるかわからない。
	// したがってフィールドを引数に持つコンストラクタは作っていない。
	public PatternBreakingPlugRunnable(Pattern pattern) {
		super();
		this.pattern = pattern;
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
		while ((readLine = this.bufferedReader.readLine()) != null) {
			if (this.pattern.matcher(readLine).matches()) {
				break;
			}
			this.bufferedWriter.write(readLine);
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
