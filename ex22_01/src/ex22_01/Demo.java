package ex22_01;

import java.util.Observer;


public class Demo {

	public static void main(String[] args){
		Observer client1 = new Client("client1");
		Observer client2 = new Client("client2");
		Observer client3 = new Client("client3");
		AttributedImpl attributed = new AttributedImpl();
		attributed.addObserver(client1);
		attributed.addObserver(client2);
		attributed.addObserver(client3);
		attributed.add(new Attr("Color", "Red"));
		attributed.deleteObserver(client3);
		attributed.add(new Attr("Font", "Times"));
	}
}
