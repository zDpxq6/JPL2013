package ex22_01;

import java.util.HashSet;

public class WhichChars {
	private final HashSet<Character>used = new HashSet<Character>();

	public WhichChars(String str){
		for(int i = 0; i < str.length(); i++){
			this.used.add(str.charAt(i));
		}
	}

	@Override
	public String toString(){
		String result = "[";
		for(Character c : this.used){
			result += c;
		}
		return result + "]";
	}
}
