package creatingArray;

import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import component.CommonButton;
import component.CommonInputPanel;
import component.ExceptionArea;
import component.Models;

import constant.Const;
import createingConstructor.ParameterScreen;

public class MakingArrayScreen extends JFrame {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;


	private final Class<?> selectedClass;
	private final ExceptionArea ea;
	private final Models mdls;
	private final int arrayLength;
	JComboBox[] 配列要素入力コンボボックスアレイ;

	public MakingArrayScreen( Class<?> selectedClass, JSpinner sp, Models mdls, ExceptionArea ea) {
		super(Const.配列要素入力UI);
		this.selectedClass = selectedClass;
		this.ea = ea;
		this.mdls = mdls;
		this.arrayLength = ((SpinnerNumberModel)sp.getModel()).getNumber().intValue();
		init(this);
	}

	private void init(MakingArrayScreen 配列入力画面){
		int 要素数 = this.arrayLength;

		配列入力画面.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		配列入力画面.setLayout(new GridLayout(要素数 + 2, 1));
		配列入力画面.setLocationRelativeTo(null);
		配列入力画面.setSize(Const.CONSTRUCTOR_LIST_SCREEN_FRAME_WIDTH, Const.CONSTRUCTOR_SCREEN_FRAME_HIGHT);

		JCheckBox chb = new JCheckBox();
		配列入力画面.add(チェックボックスパネルの生成(chb));
		配列入力画面.addPanels(要素数);
		配列入力画面.add(new CommonButton("生成", new MAMakingArrayButtonListener(this.selectedClass, chb, this.配列要素入力コンボボックスアレイ, this.mdls,this.ea)));

		配列入力画面.setVisible(true);
	}

	private static JPanel チェックボックスパネルの生成(JCheckBox chb) {
		JPanel チェックボックスパネル = new JPanel();
		チェックボックスパネル.setLayout(new GridLayout(1,2));

		チェックボックスパネル.add(new JLabel("プリミティブ配列にする"));
		チェックボックスパネル.add(chb);

		return チェックボックスパネル;
	}

	public static JComboBox コンボボックス生成(DefaultComboBoxModel 複製したいコンボボックスモデル){
		DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();
		for (int k = 0; k < 複製したいコンボボックスモデル.getSize(); k++) {
			comboBoxModel.addElement(複製したいコンボボックスモデル.getElementAt(k));
		}
		JComboBox result = new JComboBox(comboBoxModel);
		result.setEditable(true);
		return result;
	}

	private void addPanels(int パネル数){
		JPanel[] result = new JPanel[パネル数];

		this.配列要素入力コンボボックスアレイ = new JComboBox[パネル数];
		int i = 0;
		for (JPanel element : result) {
			this.配列要素入力コンボボックスアレイ[i] = new JComboBox(ParameterScreen.createInputComboBoxModel(this.mdls.getComboBoxModel()));
			JPanel tmp = new CommonInputPanel(new JLabel("要素" + i + ": "), this.配列要素入力コンボボックスアレイ[i], Const.OPENING_SCREEN_MAKE_OBJECT_BUTTON_LABEL, null, false);//定数.リフレクションスタートUIオブジェクト生成開始ボタンラベル, new リフレクションスタートUIオブジェクト生成開始ボタンリスナ()));
			element = tmp;
			this.add(element);
			i++;
		}
	}

}
