package ex21_02;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.WeakHashMap;

public class DataHandler {
	private final WeakHashMap<File, byte[]> lastData = new WeakHashMap<File, byte[]>();

	byte[] readFile(File file) {
		byte[] data;

		if (this.lastData.containsKey(file)) {
			data = this.lastData.get(file);
			if (data != null) {
				return data;
			}
		}

		// 記憶していないので読み込む
		data = readByteFromFile(file);
		this.lastData.put(file, data);
		return data;
	}

	private static byte[] readByteFromFile(File file) {
		FileInputStream input = null;
		ByteArrayOutputStream byteArrayOutputStream = null;
		try {
			input = new FileInputStream(file);
			byteArrayOutputStream = new ByteArrayOutputStream();
			int data;
			while ((data = input.read()) > 0) {
				byteArrayOutputStream.write(data);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				byteArrayOutputStream.close();
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return byteArrayOutputStream.toByteArray();
	}
}