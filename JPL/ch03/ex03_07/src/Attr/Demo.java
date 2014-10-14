package Attr;

public class Demo {

	public static void main( String[] args) {
		ScreenColor white1 = new ScreenColor ("white");
		ColorAttr cAttr01 = new ColorAttr ( "white", white1 );
		ScreenColor white2 = new ScreenColor ("white");
		ColorAttr cAttr02 = new ColorAttr ( "white", white2 );
		System.out.println(cAttr01.equals(cAttr02));

	}

}
