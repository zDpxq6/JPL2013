package ex02_09;

public enum Direction {
	N("North") {
		@Override
		public Direction right() {
			return E;
		}

		@Override
		public Direction left() {
			return W;
		}
	}, NE("NorthEast") {
		@Override
		public Direction right() {
			return SE;
		}

		@Override
		public Direction left() {
			return NW;
		}
	}, E("East") {
		@Override
		public Direction right() {
			return S;
		}

		@Override
		public Direction left() {
			return N;
		}
	}, SE("SouthEast") {
		@Override
		public Direction right() {
			return SW;
		}

		@Override
		public Direction left() {
			return NE;
		}
	}, S("South") {
		@Override
		public Direction right() {
			return W;
		}

		@Override
		public Direction left() {
			return E;
		}
	}, SW("SouthWest") {
		@Override
		public Direction right() {
			return NW;
		}

		@Override
		public Direction left() {
			return SE;
		}
	}, W("West") {
		@Override
		public Direction right() {
			return N;
		}

		@Override
		public Direction left() {
			return S;
		}
	}, NW("NorthWest") {
		@Override
		public Direction right() {
			return NE;
		}

		@Override
		public Direction left() {
			return SW;
		}
	}, ;

	private final String displayName;

	private Direction(String name) {
		this.displayName = name;
	}

	@Override
	public String toString() {
		return this.displayName;
	}

	public abstract Direction right();
	public abstract Direction left();

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
}
