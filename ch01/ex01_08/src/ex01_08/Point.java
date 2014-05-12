//(C) 2014 zDpxq6
package ex01_08;
/**
 * @auther zDpxq6
 * Pointクラスは、座標をモデル化したクラスである
 * */
public class Point {
	/**
	 * xはPointオブジェクトのx座標
	 * */
	/**
	 * yはPointオブジェクトのy座標
	 * */
	public double x, y;

	public Point(){
		super();
	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * このメソッドはインスタンスの座標を(0,0)に初期化する
	 * */
	public void clear(){
		this.x = 0;
		this.y = 0;
	}

	/**
	 * このメソッドはインスタンスの座標を変更する
	 * @param x double型の変数xは変更後のx座標である
	 * @param y double型の変数yは変更後のy座標である
	 * */
	public void move(double x, double y){
		this.x = x;
		this.y = y;
	}

	/**
	 * このメソッドはインスタンスの座標を変更する
	 * @param point Point型のpointは変更後の座標をモデル化したPointインスタンスである。
	 * */
	public void move(Point point){
		this.x = point.x;
		this.y = point.y;
	}

	/**
	 * このメソッドはカレントオブジェクトと任意のPointオブジェクトの間のユークリッド距離を求める
	 * @param that Point型のpointは任意の座標をモデル化したPointインスタンスである。
	 * */
	public double distance(Point that){
		double xdiff = this.x - that.x;
		double ydiff = this.y - that.y;
		return Math.sqrt(xdiff * xdiff + ydiff * ydiff);
	}

	@Override
	public boolean equals(Object obj){
		return obj instanceof Point && this.x == ((Point) obj).x && this.y == ((Point) obj).y;
	}

}
