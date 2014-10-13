package ex02_18;


public enum RelativeDirection {
	RIGHT {
		@Override
		public Direction turn(Direction direction) {
			return direction.right();
		}
	}, LEFT {
		@Override
		public Direction turn(Direction direction) {
			return direction.left();
		}
	};

	public abstract Direction turn(Direction direction);
}
