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

	@Override
	public SortMetrics clone() {
		try
		{
			return (SortMetrics) super.clone();
		}
		catch (CloneNotSupportedException e)
		{
		    throw new InternalError(e.toString());
		}
	}
}