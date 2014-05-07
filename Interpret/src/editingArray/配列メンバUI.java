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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import component.CommonButton;
import component.ExceptionArea;
import component.Models;

import constant.Const;
import editingObject.�z��ȊO�����oUI���\�b�h�I���}�E�X���X�i;
import ex16_Interpret.�z�񃁃��oUI�t�B�[���h����{�^�����X�i;

public class �z�񃁃��oUI extends JFrame {

	private static final long serialVersionUID = 1L;

	private final Object selectedInstance;
	private final Models mdls;
	private final ExceptionArea ea;
	private JComboBox[] �z��v�f�ҏW�R���{�{�b�N�X�A���C = null;

	public �z�񃁃��oUI(Object selectedInstance, Models mdls, ExceptionArea ea) {
		super(Const.�����oUI�^�C�g��);
		this.selectedInstance = selectedInstance;
		this.mdls = mdls;
		this.ea = ea;
		init();
	}

	private void init() {
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setSize(Const.�����oUI��, Const.�����oUI����);
		this.setLocationRelativeTo(null);
		this.setLayout(new GridLayout(1, 2));// 1�s2��̃��C�A�E�g

		Class<? extends Object> �I�������C���X�^���X�̃N���X = this.selectedInstance.getClass();
		try {
			this.add(�t�B�[���h�p�l���̐���(null));
			this.add(���\�b�h�ꗗ�̐���(�I�������C���X�^���X�̃N���X));
		} catch (Throwable e) {
			this.ea.writeException(e);
		}
	}

	protected JPanel �t�B�[���h�p�l���̐���(Field[] �t�B�[���h�z��) throws IllegalArgumentException, IllegalAccessException {
		JPanel result = new JPanel();
		result.setLayout(new GridLayout(Array.getLength(this.selectedInstance) + 2, 1));

		result.add(frame���ɉ��̔z�񂩂̐�����\������());
		//
		JPanel[] jPanelArray = new JPanel[Array.getLength(this.selectedInstance)];
		this.�z��v�f�ҏW�R���{�{�b�N�X�A���C = new JComboBox[Array.getLength(this.selectedInstance)];
		int i = 0;
		//
		for (JPanel element : jPanelArray) {
			element = new JPanel();
			element.setLayout(new GridLayout(1, 3));
			element.add(new JLabel("�v�f: " + i));
			DefaultComboBoxModel �z��v�f = new DefaultComboBoxModel();
			�z��v�f.addElement(Array.get(this.selectedInstance, i));// �����l�͕ʂɂ��ē����
			DefaultComboBoxModel dcbm = this.mdls.getComboBoxModel();// �����l�ȍ~
			int �T�C�Y = dcbm.getSize();
			for (int k = 0; k < �T�C�Y; k++) {
				�z��v�f.addElement(dcbm.getElementAt(k));
			}
			this.�z��v�f�ҏW�R���{�{�b�N�X�A���C[i] = new JComboBox(�z��v�f);
			this.�z��v�f�ҏW�R���{�{�b�N�X�A���C[i].setEditable(true);
			element.add(this.�z��v�f�ҏW�R���{�{�b�N�X�A���C[i]);
			result.add(element);
			i++;
		}
		result.add(new CommonButton("�t�B�[���h����", new �z�񃁃��oUI�t�B�[���h����{�^�����X�i(this.selectedInstance, this.�z��v�f�ҏW�R���{�{�b�N�X�A���C, this.ea)));
		return result;
	}

	private JPanel frame���ɉ��̔z�񂩂̐�����\������() {
		JPanel result = new JPanel();
		result.setLayout(new GridLayout(1, 2));
		result.add(new JLabel("�z��v�f�̌^"));
		Class<?> clazz = this.selectedInstance.getClass().getComponentType();
		JLabel ���x�� = new JLabel(clazz.getName());
		result.add(���x��);
		return result;
	}

	private JScrollPane ���\�b�h�ꗗ�̐���(Class �I�������C���X�^���X�̃N���X) {
		Method[] methodArray = �I�������C���X�^���X�̃N���X.getMethods();

		DefaultListModel methodListModel = new DefaultListModel();
		Map<String, List<Method>> ���ёւ��pMap = new TreeMap<String, List<Method>>();
		for (Method obj : methodArray) {
			if (���ёւ��pMap.containsKey(obj.getName())) {// �d������ꍇ
				���ёւ��pMap.get(obj.getName()).add(obj);
			} else {// �d�����Ȃ��ꍇ
				List<Method> method = new LinkedList<Method>();
				method.add(obj);
				���ёւ��pMap.put(obj.getName(), method);
			}
		}

		Iterator<Map.Entry<String, List<Method>>> tempMapIterator = ���ёւ��pMap.entrySet().iterator();
		while (tempMapIterator.hasNext()) {
			Map.Entry<String, List<Method>> entry = tempMapIterator.next();
			entry.getValue();
			// ���X�g�����[�v����
			for (Method element : entry.getValue()) {
				methodListModel.addElement(element);
			}
		}

		JList methodList = new JList(methodListModel);
		methodList.addMouseListener(new �z��ȊO�����oUI���\�b�h�I���}�E�X���X�i(methodList, this.selectedInstance, this.mdls,this.ea));
		JScrollPane methodScrollPane = new JScrollPane(methodList);
		return methodScrollPane;
	}
}
