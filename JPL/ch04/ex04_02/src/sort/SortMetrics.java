package sort;
final class SortMetrics implements Cloneable {
	public long	probeCnt,		// simple data probes
				compareCnt,		// comparing two elements
				swapCnt;			// swapping two elements

	public void init() {
	    this.probeCnt = this.swapCnt = this.compareCnt = 0;
	}

	@Override
	public String toString() {
	    return	this.probeCnt + " probes "
	    			+ this.compareCnt + " compares "
	    			+ this.swapCnt + " swaps";
	}

	/** This class supports clone */
	@Override
	public SortMetrics clone() {
		try
		{
			// default mechanism works
			return (SortMetrics) super.clone();
		}
		catch (CloneNotSupportedException e)
		{
			// can't happen: this and Object both clone
		    throw new InternalError(e.toString());
		}
	}
}