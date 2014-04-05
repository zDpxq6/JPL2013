package editingArray;

import java.awt.GridLayout;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import openingScreen.Models;

import component.CommonButton;
import component.CommonInputPanel;
import component.ExceptionArea;

import constant.Const;
import creatingArray.MakingArrayScreen;
import editingObject.配列以外メンバUIメソッド選択マウスリスナ;
import ex16_Interpret.配列メンバUIフィールド決定ボタンリスナ;

public class 配列メンバUI extends JFrame {

	private static final long serialVersionUID = 1L;

	private final Object selectedInstance;
	private final Models mdls;
	private final ExceptionArea ea;
	private JComboBox[] 配列要素編集コンボボックスアレイ = null;

	public 配列メンバUI(Object selectedInstance, Models mdls, ExceptionArea ea) {
		super(Const.メンバUIタイトル);
		this.selectedInstance = selectedInstance;
		this.mdls = mdls;
		this.ea = ea;
		init();
	}

	private void init() {
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setSize(Const.メンバUI幅, Const.メンバUI高さ);
		this.setLocationRelativeTo(null);
		this.setLayout(new GridLayout(1, 2));// 1行2列のレイアウト

		Class<? extends Object> 選択したインスタンスのクラス = this.selectedInstance.getClass();
		try {
			this.add(フィールドパネルの生成(null));
			this.add(メソッド一覧の生成(選択したインスタンスのクラス));
		} catch (Throwable e) {
			this.ea.writeException(e);
		}
	}

	private void addPanels(int パネル数) {
		JPanel[] result = new JPanel[パネル数];

		JComboBox[] 配列要素入力コンボボックスアレイ = new JComboBox[パネル数];
		int i = 0;
		for (JPanel element : result) {
//			静的変数.フィールド入力コンボボックスアレイ[i] = MakingArrayScreen.コンボボックス生成(this.mdls.get生成済オブジェクトのコンボボックスモデル());
			JPanel tmp = new CommonInputPanel(new JLabel(this.配列要素編集コンボボックスアレイ[i].toString()), MakingArrayScreen.コンボボックス生成(this.mdls.get生成済オブジェクトのコンボボックスモデル()), Const.OPENING_SCREEN_MAKE_OBJECT_BUTTON_LABEL, null);
			element = tmp;
			this.add(element);
			i++;
		}
	}

	protected JPanel フィールドパネルの生成(Field[] フィールド配列) throws IllegalArgumentException, IllegalAccessException {
		JPanel result = new JPanel();
		result.setLayout(new GridLayout(Array.getLength(this.selectedInstance) + 2, 1));

		result.add(frame内に何の配列かの説明を表示する());
		//
		JPanel[] jPanelArray = new JPanel[Array.getLength(this.selectedInstance)];
		System.out.println("@フィールドパネの生成");
		this.配列要素編集コンボボックスアレイ = new JComboBox[Array.getLength(this.selectedInstance)];
		int i = 0;
		//
		for (JPanel element : jPanelArray) {
			element = new JPanel();
			element.setLayout(new GridLayout(1, 3));
			element.add(new JLabel("要素: " + i));
			DefaultComboBoxModel 配列要素 = new DefaultComboBoxModel();
			配列要素.addElement(Array.get(this.selectedInstance, i));// 初期値は別にして入れる
			DefaultComboBoxModel dcbm = this.mdls.get生成済オブジェクトのコンボボックスモデル();// 初期値以降
			int サイズ = dcbm.getSize();
			for (int k = 0; k < サイズ; k++) {
				配列要素.addElement(dcbm.getElementAt(k));
			}
			this.配列要素編集コンボボックスアレイ[i] = new JComboBox(配列要素);
			element.add(this.配列要素編集コンボボックスアレイ[i]);
			element.add(new JButton("オブジェクト生成"));
			result.add(element);
			i++;
		}
		result.add(new CommonButton("フィールド決定", new 配列メンバUIフィールド決定ボタンリスナ(this.selectedInstance, this.配列要素編集コンボボックスアレイ, this.ea)));
		return result;
	}

	private JPanel frame内に何の配列かの説明を表示する() {
		JPanel result = new JPanel();
		result.setLayout(new GridLayout(1, 2));
		result.add(new JLabel("配列要素の型"));
		Class<?> clazz = this.selectedInstance.getClass().getComponentType();
		JLabel ラベル = new JLabel(clazz.getName());
		result.add(ラベル);
		return result;
	}

	private JScrollPane メソッド一覧の生成(Class 選択したインスタンスのクラス) {
		Method[] methodArray = 選択したインスタンスのクラス.getMethods();

		DefaultListModel methodListModel = new DefaultListModel();
		Map<String, List<Method>> 並び替え用Map = new TreeMap<String, List<Method>>();
		for (Method obj : methodArray) {
			if (並び替え用Map.containsKey(obj.getName())) {// 重複する場合
				並び替え用Map.get(obj.getName()).add(obj);
			} else {// 重複しない場合
				List<Method> method = new LinkedList<Method>();
				method.add(obj);
				並び替え用Map.put(obj.getName(), method);
			}
		}

		Iterator<Map.Entry<String, List<Method>>> tempMapIterator = 並び替え用Map.entrySet().iterator();
		while (tempMapIterator.hasNext()) {
			Map.Entry<String, List<Method>> entry = tempMapIterator.next();
			entry.getValue();
			// リストをループする
			for (Method element : entry.getValue()) {
				methodListModel.addElement(element);
			}
		}

		JList methodList = new JList(methodListModel);
		methodList.addMouseListener(new 配列以外メンバUIメソッド選択マウスリスナ(methodList, this.mdls, this.ea));
		JScrollPane methodScrollPane = new JScrollPane(methodList);
		return methodScrollPane;
	}
}
