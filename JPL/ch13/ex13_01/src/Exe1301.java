public class Exe1301 {

	public static int countChar( String target, int c) {

		int result = 0;
		for (int i = 0; i < target.length(); i++) {
			if(target.charAt(i)==c){
				result++;
			}
		}

		return result;
	}
}
