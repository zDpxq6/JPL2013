import java.util.ArrayList;
import java.util.List;

public class Exe1303 {
	//本文中のdelimitedStringメソッドは、1つの入力文字列に1つの区切られた文字列しかないと仮定しています。
	//すべての区切られた文字列を取り出して配列にして返すバージヨンを作成しなさい。

	public static final boolean DEBAG = false;

	private static void debag(boolean flag,String trueMessage){
		String message = flag?trueMessage:"";
		System.out.print(message);
	}

	private static void debagln(boolean flag,String trueMessage){
		debag(flag,trueMessage+"\n");
	}

	public static String[] delimitedStrings(String from, final char start, final char end){
		debagln(DEBAG,"String: " + from);
		debagln(DEBAG,"start: " + start);
		debagln(DEBAG,"end: " + end);
		List<String>result = new ArrayList<String>();
		int startPos = 0;
		int endPos = 0;

		while(true){
			if(startPos == 0){
				startPos = from.indexOf(start);
			}else{
				debagln(DEBAG,"startPos:"+startPos);
				startPos = from.indexOf(start,startPos);
				debagln(DEBAG,"newStartPos:"+startPos);
			}
			if(startPos == -1){
				debagln(DEBAG,"break@startPos");
				break;
			}
			debagln(DEBAG,"startPos: " + startPos);

			endPos = from.indexOf(end,startPos);
			debagln(DEBAG,"endPos: " + endPos);
			if(endPos == -1){
				debagln(DEBAG,"break@endPos");
				break;
			}
			result.add(from.substring(startPos, endPos + 1));
			debagln(DEBAG,"add: " + result);
			startPos = endPos ;
			debagln(DEBAG,"LoopEND");
		}
		debagln(DEBAG,"END");
		return result.toArray(new String[result.size()]);
	}

}
