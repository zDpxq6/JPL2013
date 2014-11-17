import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Exe1304 {
	// 練習問題 13.4:"type value" 形式の行を持つ入力文字列を読み込むプログラムを書きなさい。
	// typeは, ラッパークラス名(Boolean, Characterなど)の1つであり,
	// valueはその型のコンストラクタが変換できる文字列です.
	// 各行に対して, 指定された値を持つ, 指定された型のオブジェクトを生成してArrayListに追加しなさい
	// (ArrayListについては, 512頁の「ArrayList」を参照).
	// 全ての行が読み込まれたら, 最終結果を表示しなさい.各行は, 単純に改行文字'\n'で終了していると想定しなさい.

	// http://java.keicode.com/lang/reflection-new-instance.php

	private static final char SEPARATOR = ' ';

	@SuppressWarnings("unchecked")
	public static <T> void readFile( String filePath) {
		List <T> result = new ArrayList <T> ();
		BufferedReader bufferedReader = null;
		try {
			File file = new File ( filePath );
			bufferedReader = new BufferedReader(new FileReader(file));

			String line = bufferedReader.readLine();
			while (line != null) {
				String type = line.substring(0, line.indexOf(SEPARATOR));
				String value = line.substring(	line.indexOf(SEPARATOR) + 1,
												line.length());
				result.add((T) makeInstance(type, value));
				line = bufferedReader.readLine();
			}

			for (T element : result) {
				System.out.println(element);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bufferedReader != null) {
					bufferedReader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// クラスローダーをなんとかする

	@SuppressWarnings("unchecked")
	public static <T> T makeInstance( String className, String argument) {
		Class<?> clazz;
		Constructor<?> constructor;
		T result = null;
		try {
			clazz = Class.forName(className);
			constructor = clazz.getConstructor(String.class);
			result = (T) constructor.newInstance(argument);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return result;
	}
}
