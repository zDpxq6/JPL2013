package createingConstructor;
import java.awt.GridLayout;
import java.lang.reflect.Constructor;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import component.CommonButton;
import component.CommonInputPanel;
import component.ExceptionArea;
import component.Models;

import constant.Const;

public class ParameterScreen extends JFrame {
	private static final long serialVersionUID = 1L;

	private final Constructor<?> selectedConstructor;
	private final Models mdls;
	private final ExceptionArea ea;
//	private JList jl;//���g�p

	public ParameterScreen(Constructor<?> selectedConstructor, Models mdls, ExceptionArea ea) {
		super(Const.CONSTRUCTOR_LIST_SCREEN_TITLE);
		this.selectedConstructor = selectedConstructor;
		this.mdls = mdls;
		this.ea = ea;
		this.init();
	}

	private void init(){
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(Const.CONSTRUCTOR_LIST_SCREEN_FRAME_WIDTH, Const.CONSTRUCTOR_SCREEN_FRAME_HIGHT);

		Class<?>[] constructorParameterTypeArray = this.selectedConstructor.getParameterTypes();
		setLayout(new GridLayout(constructorParameterTypeArray.length + 1, 1));
		JComboBox[] �R���X�g���N�^�p�����[�^���̓R���{�{�b�N�X�A���C = createComboBoxArray(this.selectedConstructor);

		for(int i= 0; i < constructorParameterTypeArray.length; i++){
			add(new CommonInputPanel(new JLabel(constructorParameterTypeArray[i].toString()), �R���X�g���N�^�p�����[�^���̓R���{�{�b�N�X�A���C[i], "�I�u�W�F�N�g����", null, false));
		}

		add(new CommonButton(Const.CONSTRUCTOR_LIST_SCREEN_MAKING_OBJECT_BUTTON_LABEL,new PSMakingObjectButtonListener(this.selectedConstructor, this.mdls, �R���X�g���N�^�p�����[�^���̓R���{�{�b�N�X�A���C,this.ea)));
		setVisible(true);
	}

	private JComboBox[] createComboBoxArray (Constructor<?> selectedConstructor){
		Class<?>[] paramTypeArr = this.selectedConstructor.getParameterTypes();//���x���g�����ߏ���
		JComboBox[] result = new JComboBox[paramTypeArr.length];
		for (int i= 0; i < paramTypeArr.length; i++) {//�R���{�{�b�N�X�̌�
			ComboBoxModel inputComboboxModel = createInputComboBoxModel(this.mdls.getComboBoxModel());
			result[i] = new JComboBox(inputComboboxModel);
			result[i].setEditable(true);
		}
		return result;
	}

	public static ComboBoxModel createInputComboBoxModel(ComboBoxModel source){
		ComboBoxModel inputComboboxModel = new DefaultComboBoxModel();
		int k = 0;
		int size = source.getSize();

		if(source.getElementAt(0) != null){
			((DefaultComboBoxModel) inputComboboxModel).insertElementAt(null,0);
		}else{
			size++;
		}
		for (; k < size; k++) {//�R���{�{�b�N�X�̒��g�̈ڐA
			((DefaultComboBoxModel) inputComboboxModel).addElement(source.getElementAt(k));
		}
		inputComboboxModel.setSelectedItem(null);
		return inputComboboxModel;
	}

	public static ComboBoxModel copyComboBox(ComboBoxModel source){
		DefaultComboBoxModel inputComboboxModel = new DefaultComboBoxModel();
		for (int k = 0; k < source.getSize(); k++) {//�R���{�{�b�N�X�̒��g�̈ڐA
			inputComboboxModel.addElement(source.getElementAt(k));
		}
		return inputComboboxModel;
	}
}
