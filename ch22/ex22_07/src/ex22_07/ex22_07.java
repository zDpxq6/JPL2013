package ex22_07;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class ex22_07 {
	public static void main(String[] args){
		StringBuilder builder = new StringBuilder();
		for(String e:args){
			builder.append(e + " ");
		}
//		BufferedReader reader = new BufferedReader(new StringReader(builder.toString()));
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader("./data.csv"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		List<String[]> result = null;
		try {
			result = readCSVTable(reader);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(String[] e:result){
			for(String f:e){
				System.out.println(f);
			}
			System.out.println();
		}
//		System.out.println(result);
//		result

//		double result = 0;
//		try {
//			result = sumStream(reader);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		System.out.println(result);
	}

	static final String LINE_SEPARATOR_PATTEREN = "\r\n|[\n\r\u2028\2029\u0085]";

	public static List<String> readCSV(Readable source) throws IOException{
		Scanner in = new Scanner(source);
		in.useDelimiter(",|" + LINE_SEPARATOR_PATTEREN);
		List<String> vals = new ArrayList<String>();

		while(in.hasNext()){
			vals.add(in.next());
		}
		IOException ex = in.ioException();
		if(ex != null){
			throw ex;
		}
		return vals;
	}

	static final int CELLS = 4;

	public static List<String[]> readCSVTable(Readable source, int expectedCells) throws IOException{
		Scanner in = new Scanner(source);
		in.useDelimiter(",|" + LINE_SEPARATOR_PATTEREN);
		List<String[]> vals = new ArrayList<String[]>();
		String exp = "^(.*),(.*),(.*),(.*)";
		Pattern pat = Pattern.compile(exp,Pattern.MULTILINE);

		while(in.hasNextLine()){
			String line = in.findInLine(pat);
			if(line!=null){
				String[] cells = new String[expectedCells];
				MatchResult match = in.match();
				for(int i = 0; i < CELLS; i++){
					cells[i] = match.group(i+1);
				}
				vals.add(cells);
				in.nextLine();
			}else{
				throw new IOException("input formant error");
			}
		}

		IOException ex = in.ioException();
		if(ex != null){
			throw ex;
		}
		return vals;
	}

	public static List<String[]> readCSVTable(Readable source) throws IOException{
		return readCSVTable(source, CELLS);
	}

	static double sumStream(Readable source) throws IOException{
		Scanner in = new Scanner(source);
		double result = 0;

		while(in.hasNext()){
			if(in.hasNextDouble()){
				result += in.nextDouble();
			} else {
				in.next();
			}
		}
		IOException ex = in.ioException();
		if(ex != null){
			throw ex;
		}
		return result;
	}
}
