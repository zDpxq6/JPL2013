public final class SimpleSortHarness extends SortHarness {
	@Override
	protected void doSort() {
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

}