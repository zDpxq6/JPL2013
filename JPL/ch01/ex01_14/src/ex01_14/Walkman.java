package ex01_14;

public interface Walkman {

	public static final String MESSAGE = "This Walkman has %d Jack(s).";

	public Jack[] getJack();
	public int setJack(boolean[] isPluged);
	public String getMessage ();

}
