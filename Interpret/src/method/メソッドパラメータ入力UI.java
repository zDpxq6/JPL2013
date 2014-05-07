package method;
import java.awt.GridLayout;
import java.lang.reflect.Method;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import component.ExceptionArea;
import component.Models;

import constant.Const;
import createingConstructor.ParameterScreen;

public class メソッドパラメータ入力UI extends JFrame {

	private static final long serialVersionUID = 1L;

	public メソッドパラメータ入力UI(Method selectedMethod, Object obj, Models mdls, ExceptionArea ea) {
		super(Const.メソッドパラメータ入力UIタイトル);
		setSize(Const.メソッドパラメータ入力UI幅, Const.メソッドパラメータ入力UI高さ);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

		Class<?>[] methodParameterTypeArray = selectedMethod.getParameterTypes();

		setLayout(new GridLayout(methodParameterTypeArray.length + 2, 1));

		JPanel ターゲットパネル = new JPanel();
		ターゲットパネル.setLayout(new GridLayout(1, 2));
		ターゲットパネル.add(new JLabel("ターゲットとなるオブジェクト"));

		DefaultComboBoxModel 非同期用1 = (DefaultComboBoxModel) ParameterScreen.createInputComboBoxModel(mdls.getComboBoxModel());
		JComboBox ターゲットコンボボックス = new JComboBox(非同期用1);
		ターゲットコンボボックス.setEditable(true);
		ターゲットパネル.add(ターゲットコンボボックス);
		add(ターゲットパネル);

		JPanel[] jPanelArray = new JPanel[methodParameterTypeArray.length];
		JComboBox[] メソッドパラメータ入力コンボボックスアレイ = new JComboBox[methodParameterTypeArray.length];
		int i = 0;
		for (JPanel element : jPanelArray) {
			element = new JPanel();
			element.setLayout(new GridLayout(1, 2));
			element.add(new JLabel(methodParameterTypeArray[i].toString()));
			DefaultComboBoxModel 非同期用 = (DefaultComboBoxModel) ParameterScreen.createInputComboBoxModel(mdls.getComboBoxModel());
			メソッドパラメータ入力コンボボックスアレイ[i] = new JComboBox(非同期用);
			メソッドパラメータ入力コンボボックスアレイ[i].setEditable(true);
			element.add(メソッドパラメータ入力コンボボックスアレイ[i]);
			add(element);
			i++;
		}

		JButton メソッド実行ボタン = new JButton(Const.メソッドパラメータ入力UIメソッド実行ボタンラベル);
		メソッドパラメータ入力UIメソッド実行ボタンリスナ tmp = new メソッドパラメータ入力UIメソッド実行ボタンリスナ(selectedMethod, obj, メソッドパラメータ入力コンボボックスアレイ, mdls, ea);
		メソッド実行ボタン.addActionListener(tmp);
		add(メソッド実行ボタン);

	}

}
