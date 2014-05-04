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

public class ���\�b�h�p�����[�^����UI extends JFrame {

	private static final long serialVersionUID = 1L;

	public ���\�b�h�p�����[�^����UI(Method selectedMethod, Object obj, Models mdls, ExceptionArea ea) {
		super(Const.���\�b�h�p�����[�^����UI�^�C�g��);
		setSize(Const.���\�b�h�p�����[�^����UI��, Const.���\�b�h�p�����[�^����UI����);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

		Class<?>[] methodParameterTypeArray = selectedMethod.getParameterTypes();

		setLayout(new GridLayout(methodParameterTypeArray.length + 2, 1));

		JPanel �^�[�Q�b�g�p�l�� = new JPanel();
		�^�[�Q�b�g�p�l��.setLayout(new GridLayout(1, 2));
		�^�[�Q�b�g�p�l��.add(new JLabel("�^�[�Q�b�g�ƂȂ�I�u�W�F�N�g"));

		DefaultComboBoxModel �񓯊��p1 = (DefaultComboBoxModel) ParameterScreen.createInputComboBoxModel(mdls.getComboBoxModel());
		JComboBox �^�[�Q�b�g�R���{�{�b�N�X = new JComboBox(�񓯊��p1);
		�^�[�Q�b�g�R���{�{�b�N�X.setEditable(true);
		�^�[�Q�b�g�p�l��.add(�^�[�Q�b�g�R���{�{�b�N�X);
		add(�^�[�Q�b�g�p�l��);

		JPanel[] jPanelArray = new JPanel[methodParameterTypeArray.length];
		JComboBox[] ���\�b�h�p�����[�^���̓R���{�{�b�N�X�A���C = new JComboBox[methodParameterTypeArray.length];
		int i = 0;
		for (JPanel element : jPanelArray) {
			element = new JPanel();
			element.setLayout(new GridLayout(1, 2));
			element.add(new JLabel(methodParameterTypeArray[i].toString()));
			DefaultComboBoxModel �񓯊��p = (DefaultComboBoxModel) ParameterScreen.createInputComboBoxModel(mdls.getComboBoxModel());
			���\�b�h�p�����[�^���̓R���{�{�b�N�X�A���C[i] = new JComboBox(�񓯊��p);
			���\�b�h�p�����[�^���̓R���{�{�b�N�X�A���C[i].setEditable(true);
			element.add(���\�b�h�p�����[�^���̓R���{�{�b�N�X�A���C[i]);
			add(element);
			i++;
		}

		JButton ���\�b�h���s�{�^�� = new JButton(Const.���\�b�h�p�����[�^����UI���\�b�h���s�{�^�����x��);
		���\�b�h�p�����[�^����UI���\�b�h���s�{�^�����X�i tmp = new ���\�b�h�p�����[�^����UI���\�b�h���s�{�^�����X�i(selectedMethod, obj, ���\�b�h�p�����[�^���̓R���{�{�b�N�X�A���C, mdls, ea);
		���\�b�h���s�{�^��.addActionListener(tmp);
		add(���\�b�h���s�{�^��);

	}

}
