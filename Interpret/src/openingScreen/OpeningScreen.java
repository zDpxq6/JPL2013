package openingScreen;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import component.CommonInputPanel;
import component.ExceptionArea;
import component.ListPane;
import component.Models;

import constant.Const;
import ex16_Interpret.���t���N�V�����X�^�[�gUI�����σI�u�W�F�N�g�I���}�E�X���X�i;

public class OpeningScreen extends JFrame {

	private static final GridLayout OPENING_SCREEN_LAYOUT = new GridLayout(3, 1);//�N���X�Ɣz��̐ݒ�̈�, �����I�u�W�F�N�g�̕\���̈�, ���b�Z�[�W�\���̈��3�̈�
	private static final GridLayout INPUT_PANEL_LAYOUT = new GridLayout(2, 1);//�N���X�ݒ�̈�Ɣz��ݒ�̈��2�̈�

	private static final long serialVersionUID = 1L;

	private final Models mdls;
	private final ExceptionArea ea;

	public OpeningScreen() {
		super(Const.OPENING_SCREEN_TITLE);
		this.mdls = new Models();
		this.ea = new ExceptionArea();
		this.init();
	}

	/**
	 * �t���[�����������\�b�h
	 * */
	private void init() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(Const.OPENING_SCREEN_FRAME_WIDTH, Const.OPENING_SCREEN_FRAME_HIGHT);
		this.setLayout(OPENING_SCREEN_LAYOUT);
		this.setLocationRelativeTo(null);

		this.add(createInputPanel());
		this.add(new ListPane(this.mdls.getList(), new ���t���N�V�����X�^�[�gUI�����σI�u�W�F�N�g�I���}�E�X���X�i(this.mdls, this.ea)));
		this.add(this.ea);

		this.setVisible(true);
	}

	private JPanel createInputPanel() {
		JPanel jPanel = new JPanel();
		jPanel.setLayout(INPUT_PANEL_LAYOUT);
		//�{�^�����X�i�̓R���|�[�l���g��n��?
		JTextField classNameField = new JTextField(Const.TEXTFIELD_INITIAL_VALUE);
		//������
		jPanel.add(new CommonInputPanel(Const.OPENING_SCREEN_OBJECT_LABEL, classNameField, Const.OPENING_SCREEN_MAKE_OBJECT_BUTTON_LABEL, new OSMakingObjectButtonListener(classNameField, this.mdls, this.ea), true));//������
		//�{�^�����X�i�̓R���|�[�l���g��n��?
		JSpinner arrayLengthSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 255, 1));
		jPanel.add(new CommonInputPanel(Const.OPENING_SCREEN_ARRAY_LABEL, arrayLengthSpinner, Const.OPENING_SCREEN_MAKE_ARRAY_BUTTON_LABEL, new OSMakingArrayButtonListener(arrayLengthSpinner, classNameField, this.mdls, this.ea), true));
		return jPanel;
	}
}
