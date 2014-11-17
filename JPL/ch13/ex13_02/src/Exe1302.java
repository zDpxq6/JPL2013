public class Exe1302 {

	public static int countString( String target, String subString) {
		int start = 0;
		int result = -1;

		while(start < target.length() && start != -1){
			result++;
			start = target.indexOf(subString, start+1);
		}
		if(target.indexOf(subString)==0){
			result++;
		}

		return result;
	}
}
