package ex14_Apendix02;

public class Demo {
	
	
	public static void main(String[] args){
		
		new Thread(new PrintingMessage("15ïbåoâﬂ", 15)).start();
		
		new Thread(new PrintingMessage("7ïbåoâﬂ", 7)).start();
		
		new Thread(Timer.getInstance()).start();
	}
}
