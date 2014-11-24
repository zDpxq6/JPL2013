package ex17_02;

import java.io.File;
import java.lang.ref.WeakReference;

//練習問題17.2 DataHolderを修正してlastFileも弱く保存されるようにしなさい。
public class DataHolder {
	private static final String ERROR_MESSAGE = "null is not allowed";
	private WeakReference<File> lastFile; // 最後に読んだファイル
	private WeakReference<byte[]> lastData; // (おそらく)最後のデータ

	public byte[] readFile(File file) {
		if (file == null) {
			throw new IllegalArgumentException(ERROR_MESSAGE);
		}
		synchronized (this) {
			updateWeakReference(this.lastFile, file);
			updateWeakReference(this.lastData, Utility.readFile(this.lastFile.get()));
			return this.lastData.get();
		}
	}

	/**
	 * 参照がある値を参照しているか確認する。
	 * 値を参照していない場合、値を新たに参照するよう、参照の更新を行う。
	 * @param reference 確認される参照
	 * @param newValue 確認される値
	 */
	private <T> void updateWeakReference(WeakReference<T> reference, T newValue) {
		//引数のnullチェックは本メソッドの責務ではない
		T referencingObject = reference.get();
		if (null == referencingObject || newValue.equals(referencingObject) == false) {
			reference = new WeakReference<T>(newValue);
		}
	}
}
