package original;

import java.io.File;
import java.lang.ref.WeakReference;

//練習問題17.2 DataHolderを修正してlastFileも弱く保存されるようにしなさい。
public class DataHolder {
	private File lastFile;					//最後に読んだファイル
	private WeakReference<byte[]> lastData;	//(おそらく)最後のデータ

	byte[] readFile(File file) {
		byte[] data;

		// データを記憶しているか調べる
		if (file.equals(this.lastFile)) {
			data = this.lastData.get();
			if (data != null) {
				return data;
			}

		}

		data = readBytesFromFile(file);
		this.lastFile = file;
		this.lastData = new WeakReference<byte[]>(data);
		return data;

	}

	private byte[] readBytesFromFile(File file) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
}
