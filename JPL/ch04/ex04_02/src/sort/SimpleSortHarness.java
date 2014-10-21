package sort;
public final class SimpleSortHarness implements SortHarness {
	@Override
	public void doSort() {
		for (int i = 0; i < getDataLength(); i++) {
			for (int j = i + 1; j < getDataLength(); j++) {
				if (compare(i, j) > 0) {
						swap(i, j);
				}
			}
		}
	}

	@Override
	public int compareTo( Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	private Object[] values;
	private final SortMetrics curMetrics = new SortMetrics();

	/** Invoked to do the full sort */
	@Override
	public final SortMetrics sort(Object[] data)	{
		this.values = data;
		this.curMetrics.init();
		doSort();
		return getMetrics();
	}

	@Override
	public final SortMetrics getMetrics() {
		return this.curMetrics.clone();
	}

    /** For extended classes to know the number of elements*/
	@Override
	public final int getDataLength() {
    		return this.values.length;
    }

    /** For extended classes to probe elements */
	@Override
	public final Object probe(int i) {
		this.curMetrics.probeCnt++;
		return this.values[i];
	}

    /** For extended classes to compare elements */
    @Override
	@SuppressWarnings("unchecked")
	public
	final int compare(int i, int j) {
    		this.curMetrics.compareCnt++;
    		Comparable d1 = (Comparable)this.values[i];
    		Comparable d2 = (Comparable)this.values[j];

    		return d1.compareTo(d2);

    }

	/** For extended classes to swap elements */
   @Override
public void swap (int i, int j) {
    		this.curMetrics.swapCnt++;
    		Object tmp = this.values[i];
    		this.values[i] = this.values[j] ;
    		this.values[j] = tmp;
    }


}