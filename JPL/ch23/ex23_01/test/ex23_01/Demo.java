//(C) 2014 zDpxq6
package ex23_01;

import java.io.IOException;

public class Demo {
	public static void main(String[] args){
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
