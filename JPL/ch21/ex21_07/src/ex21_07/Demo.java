package ex21_07;


public class Demo {

	public static void main(String[] args){
		Stack<String> stack = new Stack<String>();
		stack.push("push1");
		System.out.println(stack.pop());
		stack.push("push2");
		System.out.println(stack.pop());
		stack.push("push3");
		System.out.println(stack.pop());
		stack.push("push4");
		System.out.println(stack.pop());
		System.out.println(stack.pop());

	}
}
