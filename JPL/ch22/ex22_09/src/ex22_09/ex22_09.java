package ex22_09;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class ex22_09 {
	private static final String FILE_PATH = "data.csv";
	private static final String LINE_SEPARATOR_PATTEREN = "\r\n|[\n\r\u2028\2029\u0085]";
	private static final int CELLS = 4;

	public static void main(String[] args) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(FILE_PATH));
		} catch (FileNotFoundException e) {
			System.err.println(e.toString());
		}
		List<String[]> result = null;
		try {
			result = readCSVTable(reader,7);
		} catch (IOException e) {
			System.err.println(e.toString());
		}
		for (String[] e : result) {
			for (String f : e) {
				System.out.print(f + "\t");
			}
			System.out.println();
		}
	}

	private static final String PATTAN_ELEMENT_START = "^([^,]*)";
	private static final String PATTAN_ELEMENT = ",([^,]*)";

	public static List<String[]> readCSVTable(Readable source, int expectedCells) throws IOException {
		Scanner in = new Scanner(source);
		in.useDelimiter(",|" + LINE_SEPARATOR_PATTEREN);
		List<String[]> vals = new ArrayList<String[]>();
		StringBuilder exp = new StringBuilder();
		exp.append(PATTAN_ELEMENT_START);
		for(int i = 1; i < expectedCells; i++){
			exp.append(PATTAN_ELEMENT);
		}

		Pattern pat = Pattern.compile(exp.toString(), Pattern.MULTILINE);
		IOException ex = in.ioException();
		while (in.hasNextLine()) {
			String line = in.findInLine(pat);
			if (line != null && "".equals(line) == false) {
				String[] cells = new String[expectedCells];
				MatchResult match = in.match();
				for (int i = 0; i < expectedCells; i++) {
					String result = match.group(i + 1);
					cells[i] = result;
				}
				vals.add(cells);
			}else{
				throw ex;
			}
			in.nextLine();
		}

		if (ex != null) {
			throw ex;
		}
		return vals;
	}

	public static List<String[]> readCSVTable(Readable source) throws IOException {
		return readCSVTable(source, CELLS);
	}

}
