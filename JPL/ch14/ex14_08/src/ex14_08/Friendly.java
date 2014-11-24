package ex14_08;

public class Friendly {
	private Friendly partner;
	private String name;
	
	public Friendly(String name) {
		this.name = name;
	}
	
	public synchronized void hug() {
		System.out.println(Thread.currentThread().getName()+ " in " + name + ".hug() trying to invoke " + partner.name + ".hugBack()");
		this.hugBack();//update
	}
	
	private synchronized void hugBack() {
		System.out.println(Thread.currentThread().getName()+ " in " + this.partner.name + ".hugBack()");//update
	}

	public void becomeFriend(Friendly partner) {
		this.partner = partner;
	}
}