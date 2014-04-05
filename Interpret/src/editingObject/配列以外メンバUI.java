package editingObject;
import java.awt.GridLayout;
import java.lang.reflect.Field;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import openingScreen.Models;

import component.CommonInputPanel;
import component.ExceptionArea;

import constant.Const;
import creatingArray.MakingArrayScreen;
import ex16_Interpret.MethodListPane;
import ex16_Interpret.メンバUIフィールド決定ボタンリスナ;


public class 配列以外メンバUI extends JFrame {
	/**
	 *
	 */

	private final Object selectedInstance;
	private final Models mdls;
	private final ExceptionArea ea;
	private final JComboBox[] 配列要素編集コンボボックスアレイ = null;
	private final Field[] フィールド配列;
	private JComboBox[] フィールド入力コンボボックスアレイ;

	private static final long serialVersionUID = 1L;

	public 配列以外メンバUI(Object selectedInstance, Models mdls, ExceptionArea ea){
		super(Const.メンバUIタイトル);
		this.selectedInstance = selectedInstance;
		this.フィールド配列 = this.selectedInstance.getClass().getDeclaredFields();
		this.mdls = mdls;
		this.ea = ea;
		init();
	}

	private void init(){
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setSize(Const.メンバUI幅, Const.メンバUI高さ);
		this.setLocationRelativeTo(null);
		this.setLayout(new GridLayout(1,2));//1行2列のレイアウト

		try{
			add(フィールドパネルの生成());
			add(new MethodListPane(this.selectedInstance.getClass(), new 配列以外メンバUIメソッド選択マウスリスナ(null, this.mdls, this.ea), this.mdls, this.ea));//なおしたい
		}catch(Throwable e){
			this.ea.writeException(e);
		}
	}

	protected JPanel フィールドパネルの生成() throws IllegalArgumentException, IllegalAccessException{
		JPanel result = new JPanel();
		result.setLayout(new GridLayout(this.フィールド配列.length+1,1));

		JPanel[] jPanelArray = new JPanel[this.フィールド配列.length];
		this.フィールド入力コンボボックスアレイ = new JComboBox[this.フィールド配列.length];
		int i = 0;

		for (JPanel element : jPanelArray) {
			element = new JPanel();
			element.setLayout(new GridLayout(1, 3));
			element.add(new JLabel(this.フィールド配列[i].toString()));
			int サイズ = this.mdls.get生成済オブジェクトのコンボボックスモデル().getSize();
			DefaultComboBoxModel 非同期用 = new DefaultComboBoxModel();//初期値だけ特別に設定する
			this.フィールド配列[i].setAccessible(true);
			非同期用.addElement(this.フィールド配列[i].get(this.selectedInstance));

			for (int k = 0; k < サイズ; k++) {
				非同期用.addElement(this.mdls.get生成済オブジェクトのコンボボックスモデル().getElementAt(k));
			}
			this.フィールド入力コンボボックスアレイ[i] = new JComboBox(非同期用);
			element.add(this.フィールド入力コンボボックスアレイ[i]);
			element.add(new JButton("オブジェクト生成"));
			result.add(element);
			i++;
		}
		result.add(CommonInputPanel.makeCommonButton("フィールド決定",new メンバUIフィールド決定ボタンリスナ(this.selectedInstance, this.フィールド入力コンボボックスアレイ, this.ea)));
		return result;
	}

	private void addPanels(int パネル数){
		JPanel[] result = new JPanel[パネル数];

		JComboBox[] 配列要素入力コンボボックスアレイ = new JComboBox[パネル数];
		int i = 0;
		for (JPanel element : result) {
			this.フィールド入力コンボボックスアレイ[i] = MakingArrayScreen.コンボボックス生成(this.mdls.get生成済オブジェクトのコンボボックスモデル());
			JPanel tmp = new CommonInputPanel(new JLabel(this.フィールド配列[i].toString()), this.フィールド入力コンボボックスアレイ[i], Const.OPENING_SCREEN_MAKE_OBJECT_BUTTON_LABEL, null);
			element = tmp;
			this.add(element);
			i++;
		}
	}
}
