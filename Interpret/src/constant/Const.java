package constant;
import java.awt.GridLayout;

import javax.swing.JLabel;




//定数を格納するクラス



public class Const {
	public static final int OPENING_SCREEN_FRAME_WIDTH = 500;
	public static final int OPENING_SCREEN_FRAME_HIGHT = 500;
	public static final String 配列要素入力UI = "配列要素の入力";

	public static final String CONSTRUCTOR_PARAMETER_INPUT_SCREEN_TITLE = "コンストラクタパラメータ入力UI";
	public static final int CONSTRUCTOR_LIST_SCREEN_FRAME_WIDTH = 300;
	public static final int CONSTRUCTOR_SCREEN_FRAME_HIGHT = 300;
	static final int コンストラクタ選択UI幅 = 300;
	static final int コンストラクタ選択UI高さ = 300;
	public static final String CONSTRUCTOR_LIST_SCREEN_MAKING_OBJECT_BUTTON_LABEL = "オブジェクト生成";

	static final int コンストラクタ選択UIスクロールペイン幅 = 200;
	static final int コンストラクタ選択UIスクロールペイン高さ = 100;

	public static final int スクロールペイン幅 = 200;
	public static final int スクロールペイン高さ = 100;

	public static final String TEXTFIELD_INITIAL_VALUE = "java.lang.Integer";
	public static final String OPENING_SCREEN_TITLE = "リフレクションデモ";
	static final int TEXTFIELD_LENGTH = 10;

	static final int RECORD_OF_INSTANCE = 10;
	public static final String CONSTRUCTOR_LIST_SCREEN_TITLE = "コンストラクタの選択";


	public static final int メンバUI幅 = 1200;
	public static final int メンバUI高さ = 300;
	public static final String メンバUIタイトル = "メンバ入力画面";
	public static final String PARAMETER_INPUT_UI_TITLE = null;
	public static final String OPENING_SCREEN_MAKE_ARRAY_BUTTON_LABEL = "配列生成開始";
	public static final JLabel OPENING_SCREEN_OBJECT_LABEL = new JLabel("クラス名を入力");
	public static final JLabel リフレクションスタートUI配列サイズスピナラベル = new JLabel("クラス名を入力");
	public static final JLabel OPENING_SCREEN_ARRAY_LABEL = new JLabel("配列数を入力");
	public static final String メソッドパラメータ入力UIタイトル = "メソッドパラメータ入力画面";
	public static final int メソッドパラメータ入力UI幅 = 900;
	public static final int メソッドパラメータ入力UI高さ = 300;
	public static final String メソッドパラメータ入力UIメソッド実行ボタンラベル = "メソッド実行";

	public static String OPENING_SCREEN_MAKE_OBJECT_BUTTON_LABEL = "オブジェクト生成開始";

	static final GridLayout OPENING_SCREEN = new GridLayout(3,1);
	static final GridLayout 定数_入力パネルレイアウト = new GridLayout(2,1);
	static final GridLayout 定数_ラベル入力ボタンレイアウト = new GridLayout(1,3);
}
