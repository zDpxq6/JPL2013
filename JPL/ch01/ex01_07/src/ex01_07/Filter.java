//(C) 2014 zDpxq6
package ex01_07;

public interface Filter<INPUT_ARGUMENT_TYPE> {
	public boolean isConditionFulfilled(INPUT_ARGUMENT_TYPE target);
	public Object executeInTrue(INPUT_ARGUMENT_TYPE target);
	public Object executeInFalse(INPUT_ARGUMENT_TYPE target);
	public Object modify(INPUT_ARGUMENT_TYPE target);
}
