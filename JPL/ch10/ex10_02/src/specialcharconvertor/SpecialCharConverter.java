package specialcharconvertor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;


public class SpecialCharConverter {

	static String printEscapedCharacter(String str) {
		Reader in = new BufferedReader(new StringReader(str));
		StringBuffer result = new StringBuffer();
		int contents;

		try {
			while ((contents = in.read()) != -1) {
				result.append(convertSpecialCharacter((char)contents));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result.toString();
    }

	private static String convertSpecialCharacter (char c){
		switch(c){
			case '\n':
				return "\\n";
			case '\t':
				return "\\t";
			case '\b':
				return "\\b";
			case '\r':
				return "\\r";
			case '\f':
				return "\\f";
			case '\\':
				return "\\\\";
			case '\'':
				return "\\'";
			case '\"':
				return "\\\"";
			default:
				return String.valueOf(c);
		}
	}


}
