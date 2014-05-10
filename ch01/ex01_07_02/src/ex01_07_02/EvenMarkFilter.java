//(C) 2014 zDpxq6
package ex01_07_02;

public class EvenMarkFilter<INPUT_ARGUMENT_TYPE> implements Filter<INPUT_ARGUMENT_TYPE> {
	private static final int EVEN_CONDITION = 2;
	private static final String SPACE = " ";

	private final String mark;

	public EvenMarkFilter(String mark){
		this.mark = SPACE + mark;
	}

	@Override
	public boolean isConditionFulfilled(INPUT_ARGUMENT_TYPE target) {
		return target instanceof Integer && (Integer) target % EVEN_CONDITION == 0;
	}

	@Override
	public Object executeInTrue(INPUT_ARGUMENT_TYPE target) {
		return target.toString() + this.mark;
	}

	@Override
	public Object executeInFalse(INPUT_ARGUMENT_TYPE target) {
		return target.toString();
	}

	public String getMark(){
		return this.mark;
	}

	@Override
	public Object modify(INPUT_ARGUMENT_TYPE target) {
		if(isConditionFulfilled(target)){
			return executeInTrue(target);
		}else{
			return executeInFalse(target);
		}
	}
}
