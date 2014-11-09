/*© 2013 Hatanaka Tsuguka*/
/** @author Hatanaka Tsuguka*/
public class PascalsTriangle{
//  練習問題7.3: 深さが12のパスカルの三角形を計算するプログラムを作成しなさい。
//  三角形の各行を適切な長さの配列とし、各行の配列を長さ12のint配列の配列に格納しなさい。
//  定数12ではなく、各配列の長さを使用して配列の配列を表示するメソッドにより結果を表示するようプログラムしなさい。
//  さらに表示メソッドを変更することなく、12をほかの定数にしなさい。

  private final int[][] pascalsTriangle;//本体
  private static final String SEPARATOR = ", ";
  private static final String TERMINATOR = " }\n";

  /**
   * パラメータで指定した値に基づき、パスカルの三角形を表す2次元配列を生成する
   *
   *@param: line
   *		パスカルの三角形の深さ
   */
  public PascalsTriangle(int line){
    this.pascalsTriangle = new int[line][];
    this.calc();
  }

  /**
   * パスカルの三角形の要素を算出する
   */
  private void calc(){
    for(int i = 0; i < this.pascalsTriangle.length; i++){
      this.pascalsTriangle[i] = this.binomialCoefficients(i+1);
    }
  }

  /**
   * 二項係数を算出する
   *
   * @param k
   * 	要素のインデックス(0 ~ k-1)
   *
   */
  private int[] binomialCoefficients(int k){
    int[] result = new int[k];

    for(int i = 0; i < k; i++){
      result[i] = factorial(k - 1)/(factorial(i)*factorial(k-1-i));
    }

    return result;
  }

  /**
   * 階乗を算出する
   *
   * @param n
   * 	掛けあわせる要素の最大値
   *
   */
  private int factorial(int n) {
    int result = n;
    if(n > 0){
      result *= factorial(n-1);
    } else if ( n == 0 ){
      result = 1;
    }
    else{
      assert false : "elementの値が負";
    }
    return result;
  }

  public void printPascalsTriangle(){
    for(int i = 0; i < this.pascalsTriangle.length; i++){
	    System.out.print("{ ");
	    printLines(i);
    }
  }

  private void printLines(int i){
	  for(int j = 0; j <= i; j++){
		  System.out.print( this.pascalsTriangle[i][j]);
		  System.out.print(j != i ? SEPARATOR : TERMINATOR );
	}
  }

}