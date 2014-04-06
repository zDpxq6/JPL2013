package ex14_05;

public interface IExecuterInterface {
	static final class Target{
		private static int t;
		public static int get(){
				return t;
		}
		public static void set(int i){
			Target.t = i;
		}
	}
	
	public void calculate(int value);
}
