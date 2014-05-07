package editingObject;
import java.awt.GridLayout;
import java.lang.reflect.Field;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import component.CommonInputPanel;
import component.ExceptionArea;
import component.Models;

import constant.Const;
import ex16_Interpret.MethodListPane;
import ex16_Interpret.�����oUI�t�B�[���h����{�^�����X�i;


public class �z��ȊO�����oUI extends JFrame {
	/**
	 *
	 */

	private final Object selectedInstance;
	private final Models mdls;
	private final ExceptionArea ea;
	private final Field[] �t�B�[���h�z��;
	private JComboBox[] �t�B�[���h���̓R���{�{�b�N�X�A���C;

	private static final long serialVersionUID = 1L;

	public �z��ȊO�����oUI(Object selectedInstance, Models mdls, ExceptionArea ea){
		super(Const.�����oUI�^�C�g��);
		this.selectedInstance = selectedInstance;
		this.�t�B�[���h�z�� = this.selectedInstance.getClass().getDeclaredFields();
		this.mdls = mdls;
		this.ea = ea;
		init();
	}

	private void init(){
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setSize(Const.�����oUI��, Const.�����oUI����);
		this.setLocationRelativeTo(null);
		this.setLayout(new GridLayout(1,2));//1�s2��̃��C�A�E�g

		try{
			add(�t�B�[���h�p�l���̐���());
			add(new MethodListPane(this.selectedInstance, new �z��ȊO�����oUI���\�b�h�I���}�E�X���X�i(null, this.selectedInstance, this.mdls, this.ea), this.mdls, this.ea));//�Ȃ�������
		}catch(Throwable e){
			this.ea.writeException(e);
		}
	}

	protected JPanel �t�B�[���h�p�l���̐���() throws IllegalArgumentException, IllegalAccessException{
		JPanel result = new JPanel();
		result.setLayout(new GridLayout(this.�t�B�[���h�z��.length+1,1));

		JPanel[] jPanelArray = new JPanel[this.�t�B�[���h�z��.length];
		this.�t�B�[���h���̓R���{�{�b�N�X�A���C = new JComboBox[this.�t�B�[���h�z��.length];
		int i = 0;

		for (JPanel element : jPanelArray) {
			element = new JPanel();
			element.setLayout(new GridLayout(1, 3));
			element.add(new JLabel(this.�t�B�[���h�z��[i].toString()));
			int �T�C�Y = this.mdls.getComboBoxModel().getSize();
			DefaultComboBoxModel �񓯊��p = new DefaultComboBoxModel();//�����l�������ʂɐݒ肷��
			this.�t�B�[���h�z��[i].setAccessible(true);
			�񓯊��p.addElement(this.�t�B�[���h�z��[i].get(this.selectedInstance));

			for (int k = 0; k < �T�C�Y; k++) {
				�񓯊��p.addElement(this.mdls.getComboBoxModel().getElementAt(k));
			}
			this.�t�B�[���h���̓R���{�{�b�N�X�A���C[i] = new JComboBox(�񓯊��p);
			this.�t�B�[���h���̓R���{�{�b�N�X�A���C[i].setEditable(true);
			element.add(this.�t�B�[���h���̓R���{�{�b�N�X�A���C[i]);
			result.add(element);
			i++;
		}
		result.add(CommonInputPanel.makeCommonButton("�t�B�[���h����",new �����oUI�t�B�[���h����{�^�����X�i(this.selectedInstance, this.�t�B�[���h���̓R���{�{�b�N�X�A���C, this.ea)));
		return result;
	}
}
