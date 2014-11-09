package bankaccount;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BankAccount {
	private long number;
	private long balance;
	private final History lastActs = new History() ;

	public void deposit(long amount){
		this.balance += amount;
		this.lastActs.add(new Action("deposit", amount));
	}

	public void withdraw(long amount){
		this.balance -= amount;
		this.lastActs.add(new Action("withdraw", amount));
	}

	public void transfer(BankAccount other, long amount){
		other.withdraw(amount);
		deposit(amount);
		this.lastActs.add(new Action("transfer", amount));
		other.lastActs.add(new Action("transfer", amount));
	}


	public class Action{
		private final String act;
		private final long amount;
		Action(String act, long amount){
			this.act = act;
			this.amount = amount;
		}
		public String toStrig(){
			return BankAccount.this.number + ": " + this.act + " " + this.amount;
		}
	}

	private class History<E> implements Iterable<E>{
		private static final int MAX_SIZE = 10;
		private final Queue<E>history = new LinkedList<E>();
		private int counter = 0;
		private History(){

		}

		private void add(E action){
			if(MAX_SIZE < this.counter){
				this.history.poll();
				this.counter--;
			}
			this.history.add(action);
			this.counter++;
		}

		@Override
		public Iterator<E> iterator() {
			return this.history.iterator();
		}

	}
}
