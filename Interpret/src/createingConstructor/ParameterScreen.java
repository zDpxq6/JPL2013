package createingConstructor;
import java.awt.GridLayout;
import java.lang.reflect.Constructor;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import openingScreen.Models;

import component.CommonButton;
import component.CommonInputPanel;
import component.ExceptionArea;

import constant.Const;

public class ParameterScreen extends JFrame {
	private static final long serialVersionUID = 1L;

	public ParameterScreen(Constructor<?> selectedConstructor, Models mdls ,ExceptionArea ea) {
		super(Const.コンストラクタパラメータ入力UIタイトル);
		setSize(Const.コンストラクタパラメータ入力UI幅, Const.コンストラクタパラメータ入力UI高さ);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

		Class<?>[] constructorParameterTypeArray = selectedConstructor.getParameterTypes();

		int length = constructorParameterTypeArray.length;

		setLayout(new GridLayout(length + 1, 1));

		JComboBox[] コンストラクタパラメータ入力コンボボックスアレイ = new JComboBox[length];
		for (int i= 0; i < length; i++) {

			int サイズ = 1 + mdls.get生成済オブジェクトのコンボボックスモデル().getSize();
			DefaultComboBoxModel 非同期用 = new DefaultComboBoxModel();
			非同期用.addElement(new String(""));
			for (int k = 1; k < サイズ; k++) {
				非同期用.addElement(mdls.get生成済オブジェクトのコンボボックスモデル().getElementAt(k));
			}
			コンストラクタパラメータ入力コンボボックスアレイ[i] = new JComboBox(非同期用);
			コンストラクタパラメータ入力コンボボックスアレイ[i].setEditable(true);

			add(new CommonInputPanel(new JLabel(constructorParameterTypeArray[i].toString()), コンストラクタパラメータ入力コンボボックスアレイ[i], "オブジェクト生成", null));
		}
		add(new CommonButton(Const.コンストラクタパラメータ入力UIオブジェクト生成ボタンラベル,new PSMakingObjectButtonListener(selectedConstructor, mdls, コンストラクタパラメータ入力コンボボックスアレイ,ea)));
		setVisible(true);
	}



}
