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
	JComboBox[] �z��v�f���̓R���{�{�b�N�X�A���C;

	public MakingArrayScreen( Class<?> selectedClass, JSpinner sp, Models mdls, ExceptionArea ea) {
		super(Const.�z��v�f����UI);
		this.selectedClass = selectedClass;
		this.ea = ea;
		this.mdls = mdls;
		this.arrayLength = ((SpinnerNumberModel)sp.getModel()).getNumber().intValue();
		init(this);
	}

	private void init(MakingArrayScreen �z����͉��){
		int �v�f�� = this.arrayLength;

		�z����͉��.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		�z����͉��.setLayout(new GridLayout(�v�f�� + 2, 1));
		�z����͉��.setLocationRelativeTo(null);
		�z����͉��.setSize(Const.CONSTRUCTOR_LIST_SCREEN_FRAME_WIDTH, Const.CONSTRUCTOR_SCREEN_FRAME_HIGHT);

		JCheckBox chb = new JCheckBox();
		�z����͉��.add(�`�F�b�N�{�b�N�X�p�l���̐���(chb));
		�z����͉��.addPanels(�v�f��);
		�z����͉��.add(new CommonButton("����", new MAMakingArrayButtonListener(this.selectedClass, chb, this.�z��v�f���̓R���{�{�b�N�X�A���C, this.mdls,this.ea)));

		�z����͉��.setVisible(true);
	}

	private static JPanel �`�F�b�N�{�b�N�X�p�l���̐���(JCheckBox chb) {
		JPanel �`�F�b�N�{�b�N�X�p�l�� = new JPanel();
		�`�F�b�N�{�b�N�X�p�l��.setLayout(new GridLayout(1,2));

		�`�F�b�N�{�b�N�X�p�l��.add(new JLabel("�v���~�e�B�u�z��ɂ���"));
		�`�F�b�N�{�b�N�X�p�l��.add(chb);

		return �`�F�b�N�{�b�N�X�p�l��;
	}

	public static JComboBox �R���{�{�b�N�X����(DefaultComboBoxModel �����������R���{�{�b�N�X���f��){
		DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();
		for (int k = 0; k < �����������R���{�{�b�N�X���f��.getSize(); k++) {
			comboBoxModel.addElement(�����������R���{�{�b�N�X���f��.getElementAt(k));
		}
		JComboBox result = new JComboBox(comboBoxModel);
		result.setEditable(true);
		return result;
	}

	private void addPanels(int �p�l����){
		JPanel[] result = new JPanel[�p�l����];

		this.�z��v�f���̓R���{�{�b�N�X�A���C = new JComboBox[�p�l����];
		int i = 0;
		for (JPanel element : result) {
			this.�z��v�f���̓R���{�{�b�N�X�A���C[i] = new JComboBox(ParameterScreen.createInputComboBoxModel(this.mdls.getComboBoxModel()));
			JPanel tmp = new CommonInputPanel(new JLabel("�v�f" + i + ": "), this.�z��v�f���̓R���{�{�b�N�X�A���C[i], Const.OPENING_SCREEN_MAKE_OBJECT_BUTTON_LABEL, null, false);//�萔.���t���N�V�����X�^�[�gUI�I�u�W�F�N�g�����J�n�{�^�����x��, new ���t���N�V�����X�^�[�gUI�I�u�W�F�N�g�����J�n�{�^�����X�i()));
			element = tmp;
			this.add(element);
			i++;
		}
	}

}
