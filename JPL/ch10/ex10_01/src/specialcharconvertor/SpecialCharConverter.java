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
		if (c == '\n' ){
			return "\\n";
		}
		if (c == '\t') {
            return "\\t";
        }
        else if (c == '\b') {
            return "\\b";
        }
        else if (c == '\r') {
            return "\\r";
        }
        else if (c == '\f') {
            return "\\f";
        }
        else if (c == '\\') {
            return "\\\\";
        }
        else if (c == '\'') {
            return "\\'";
        }
        else if (c == '\"') {
        		return "\\\"";
        }
        else {
            return String.valueOf(c);
        }
	}


}
