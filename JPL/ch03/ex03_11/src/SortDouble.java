abstract class SortDouble {
	private double[] values;
	private final SortMetrics curMetrics = new SortMetrics();

	public final SortMetrics sort(double[] data)	{
		this.values = data;
		this.curMetrics.init();
		doSort();
		return getMetrics();
	}

	public final SortMetrics getMetrics() {
		return this.curMetrics.clone();
	}

    protected final int getDataLength() {
    		return this.values.length;
    }

	protected final double probe(int i) {
		this.curMetrics.probeCnt++;
		return this.values[i];
	}

    protected final int compare(int i, int j) {
    		this.curMetrics.compareCnt++;
    		double d1 = this.values[i];
    		double d2 = this.values[j];

		if (d1 == d2)
		{
			return 0;
		}
		else
		{
			return d1 < d2 ? -1 : 1;
		}
    }

    protected final void swap (int i, int j) {
    		this.curMetrics.swapCnt++;
    		double tmp = this.values[i];
    		this.values[i] = this.values[j] ;
    		this.values[j] = tmp;
    }

	protected abstract void doSort();
}
