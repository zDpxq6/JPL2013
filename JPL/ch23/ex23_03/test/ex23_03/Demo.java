//(C) 2014 zDpxq6
package ex23_03;

import java.io.IOException;
import java.util.regex.Pattern;

public class Demo {
	public static void main(String[] args){
		Pattern pattern = Pattern.compile(".*HotSpot.*");
		Ex23.setPlugRunnable(new PatternBreakingPlugRunnable(pattern));
		System.out.println("start");
		try {
			Ex23.userProg("java -version");
			Ex23.userProg("java -version");
			Ex23.userProg("java -version");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("end");
		}
	}
}
