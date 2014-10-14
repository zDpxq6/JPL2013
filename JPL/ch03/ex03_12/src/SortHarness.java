@SuppressWarnings("rawtypes")
public abstract class SortHarness implements Comparable{
	private Object[] values;
	private final SortMetrics curMetrics = new SortMetrics();

	/** Invoked to do the full sort */
	public final SortMetrics sort(Object[] data)	{
		this.values = data;
		this.curMetrics.init();
		doSort();
		return getMetrics();
	}

	public final SortMetrics getMetrics() {
		return this.curMetrics.clone();
	}

    /** For extended classes to know the number of elements*/
    protected final int getDataLength() {
    		return this.values.length;
    }

    /** For extended classes to probe elements */
	protected final Object probe(int i) {
		this.curMetrics.probeCnt++;
		return this.values[i];
	}

    /** For extended classes to compare elements */
    @SuppressWarnings("unchecked")
	protected final int compare(int i, int j) {
    		this.curMetrics.compareCnt++;
    		Comparable d1 = (Comparable)this.values[i];
    		Comparable d2 = (Comparable)this.values[j];

    		return d1.compareTo(d2);

    }

	/** For extended classes to swap elements */
    protected final void swap (int i, int j) {
    		this.curMetrics.swapCnt++;
    		Object tmp = this.values[i];
    		this.values[i] = this.values[j] ;
    		this.values[j] = tmp;
    }

	/** Extended classes implement this -- used by sort */
	protected abstract void doSort();
}
