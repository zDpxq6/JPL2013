package ex17_02;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Utility {
	public static byte[] readFile(File file) {
		FileInputStream fileInputStream = null;
		ByteArrayOutputStream byteArrayOutputStream = null;
		try {
			fileInputStream = new FileInputStream(file);
			byteArrayOutputStream = new ByteArrayOutputStream();
			int i;
			while ((i = fileInputStream.read()) != -1) {
				byteArrayOutputStream.write(i);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			try {
				byteArrayOutputStream.close();
				fileInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return byteArrayOutputStream.toByteArray();
	}
}
