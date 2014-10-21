package sort;
@SuppressWarnings("rawtypes")
public interface SortHarness extends Comparable{

	/** Invoked to do the full sort */
	public SortMetrics sort(Object[] data);

	public SortMetrics getMetrics();

    /** For extended classes to know the number of elements*/
    int getDataLength();

    /** For extended classes to probe elements */
	Object probe(int i);

    /** For extended classes to compare elements */
    int compare(int i, int j);

	/** For extended classes to swap elements */
    void swap (int i, int j);

	/** Extended classes implement this -- used by sort */
	void doSort();
}
