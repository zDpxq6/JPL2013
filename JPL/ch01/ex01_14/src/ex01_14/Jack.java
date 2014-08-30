package ex01_14;

public final class Jack{
	private boolean isPluged;

	public Jack() {
		super();
		this.isPluged = false;
	}

	/**
	 *
	 */
	public final void setPlug(boolean isPluged) {
		this.isPluged = isPluged;
	}

	/**
	 * @return pluged
	 */
	public final boolean isPluged() {
		return this.isPluged;
	}
}