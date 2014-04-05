package method;
import java.awt.GridLayout;
import java.lang.reflect.Method;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import openingScreen.Models;

import component.ExceptionArea;

import constant.Const;

public class メソッドパラメータ入力UI extends JFrame {

	private static final long serialVersionUID = 1L;

	public メソッドパラメータ入力UI(Method selectedMethod, Models mdls, ExceptionArea ea) {
		super(Const.メソッドパラメータ入力UIタイトル);
		setSize(Const.メソッドパラメータ入力UI幅, Const.メソッドパラメータ入力UI高さ);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

		Class<?>[] methodParameterTypeArray = selectedMethod.getParameterTypes();

		setLayout(new GridLayout(methodParameterTypeArray.length + 2, 1));

		JPanel ターゲットパネル = new JPanel();
		ターゲットパネル.setLayout(new GridLayout(1, 3));
		ターゲットパネル.add(new JLabel("ターゲットとなるオブジェクト"));

		DefaultListModel dlm = mdls.get生成済オブジェクトのリストモデル();
		int サイズ1 = dlm.getSize();
		DefaultComboBoxModel 非同期用1 = new DefaultComboBoxModel();
		for (int k = 0; k < サイズ1; k++) {
			非同期用1.addElement( dlm.getElementAt(k));
		}
		JComboBox ターゲットコンボボックス = new JComboBox(非同期用1);
		ターゲットコンボボックス.setEditable(true);
		ターゲットパネル.add(ターゲットコンボボックス);
		ターゲットパネル.add(new JButton("オブジェクト生成"));
		add(ターゲットパネル);

		JPanel[] jPanelArray = new JPanel[methodParameterTypeArray.length];
		JComboBox[] メソッドパラメータ入力コンボボックスアレイ = new JComboBox[methodParameterTypeArray.length];
		int i = 0;
		for (JPanel element : jPanelArray) {
			element = new JPanel();
			element.setLayout(new GridLayout(1, 3));
			element.add(new JLabel(methodParameterTypeArray[i].toString()));
			int サイズ = mdls.get生成済オブジェクトのコンボボックスモデル().getSize();
			DefaultComboBoxModel 非同期用 = new DefaultComboBoxModel();
			for (int k = 0; k < サイズ; k++) {
				非同期用.addElement(mdls.get生成済オブジェクトのコンボボックスモデル().getElementAt(k));
			}
			メソッドパラメータ入力コンボボックスアレイ[i] = new JComboBox(非同期用);
			メソッドパラメータ入力コンボボックスアレイ[i].setEditable(true);
			element.add(メソッドパラメータ入力コンボボックスアレイ[i]);
			element.add(new JButton("オブジェクト生成"));
			add(element);
			i++;
		}

		JButton メソッド実行ボタン = new JButton(Const.メソッドパラメータ入力UIメソッド実行ボタンラベル);
		メソッド実行ボタン.addActionListener(new メソッドパラメータ入力UIメソッド実行ボタンリスナ(selectedMethod, メソッドパラメータ入力コンボボックスアレイ, mdls, ea));
		add(メソッド実行ボタン);

	}

}
