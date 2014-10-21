package sort;
public class TestSort {
	static Object[] testData = {	'h','g','f','e' };
	public static void main(String[] args) {
		SortHarness bsort = new SimpleSortHarness();
		SortMetrics metrics = bsort.sort(testData);
		System.out.println("Metrics: " + metrics);
		for (int i = 0; i < testData.length; i++) {
			System.out.println("\t" + testData[i]);
		}
	}
}