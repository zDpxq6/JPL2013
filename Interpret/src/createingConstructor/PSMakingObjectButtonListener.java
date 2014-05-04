package createingConstructor;
import java.awt.Component;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;

import javax.swing.JComboBox;
import javax.swing.SwingUtilities;

import component.ExceptionArea;
import component.Models;


public class PSMakingObjectButtonListener implements ActionListener {

	private final Constructor<?> selectedConstructor;
	private final JComboBox[] �R���X�g���N�^�p�����[�^���̓R���{�{�b�N�X�A���C;
	private final Models mdls;
	private final ExceptionArea ea;
	private static final String CLASS_NAME = PSMakingObjectButtonListener.class.toString();

	public PSMakingObjectButtonListener(Constructor<?> selectedConstructor, Models mdls,JComboBox[] �R���X�g���N�^�p�����[�^���̓R���{�{�b�N�X�A���C, ExceptionArea ea){
		this.selectedConstructor = selectedConstructor;
		this.�R���X�g���N�^�p�����[�^���̓R���{�{�b�N�X�A���C = �R���X�g���N�^�p�����[�^���̓R���{�{�b�N�X�A���C;
		this.mdls = mdls;
		this.ea = ea;
	}

	@Override
	public void actionPerformed( ActionEvent arg0) {
		try {
			Class<?>[] �I�������R���X�g���N�^�̃p�����[�^�̌^�z�� = this.selectedConstructor.getParameterTypes();
			Object[] �I�������R���X�g���N�^�̃p�����[�^�z�� = new Object[�I�������R���X�g���N�^�̃p�����[�^�̌^�z��.length];

			int i = 0;
			for(JComboBox comboBox :this.�R���X�g���N�^�p�����[�^���̓R���{�{�b�N�X�A���C){
				Class<?> type = �I�������R���X�g���N�^�̃p�����[�^�̌^�z��[i];	//���߂���^
				Object �R���{�{�b�N�X�ɓ��͂����p�����[�^�̒l= null;
				Object �擾�l = null;
				if(comboBox.getSelectedIndex() < 0){
					�擾�l = comboBox.getSelectedItem();
					System.out.println("�擾�l�̌^: ");
					if(type == Character.TYPE || type == Character.class){//���߂���^���v���~�e�B�u�����b�p�Ȃ�
						char[] charArray = ((String) �擾�l).toCharArray();
						�R���{�{�b�N�X�ɓ��͂����p�����[�^�̒l = charArray[0];
					}else if(type == Byte.TYPE || type == Byte.class){//���߂���^���v���~�e�B�u�����b�p�Ȃ�
						�R���{�{�b�N�X�ɓ��͂����p�����[�^�̒l = Byte.valueOf((String) comboBox.getSelectedItem());
					}else if(type == Short.TYPE || type == Short.class){
						�R���{�{�b�N�X�ɓ��͂����p�����[�^�̒l = Short.valueOf((String) comboBox.getSelectedItem());
					}else if(type == Integer.TYPE || type == Integer.class){// || type == Integer.class.toString()){
						System.out.println(comboBox.getSelectedItem().getClass());
						�R���{�{�b�N�X�ɓ��͂����p�����[�^�̒l = Integer.valueOf((String) comboBox.getSelectedItem());
					}else if(type == Long.TYPE || type == Long.class){
						System.out.println(comboBox.getSelectedItem().getClass());
						�R���{�{�b�N�X�ɓ��͂����p�����[�^�̒l = Long.valueOf((String) comboBox.getSelectedItem());
					}else if(type == Float.TYPE || type == Float.class){
						�R���{�{�b�N�X�ɓ��͂����p�����[�^�̒l = Float.valueOf((String) comboBox.getSelectedItem());
					}else if(type == Double.TYPE || type == Double.class){
						�R���{�{�b�N�X�ɓ��͂����p�����[�^�̒l = Double.valueOf((String) comboBox.getSelectedItem());
					}else if(type == Boolean.TYPE || type == Boolean.class){
						�R���{�{�b�N�X�ɓ��͂����p�����[�^�̒l = Boolean.valueOf((String) comboBox.getSelectedItem());
					} else {
						�R���{�{�b�N�X�ɓ��͂����p�����[�^�̒l = comboBox.getSelectedItem();
					}
				} else {
					�R���{�{�b�N�X�ɓ��͂����p�����[�^�̒l = comboBox.getSelectedItem();
				}
				�I�������R���X�g���N�^�̃p�����[�^�z��[i] = �R���{�{�b�N�X�ɓ��͂����p�����[�^�̒l;
				i++;
			}
			Object createdInstance = this.selectedConstructor.newInstance(�I�������R���X�g���N�^�̃p�����[�^�z��);
			this.mdls.addElement(createdInstance);
		} catch (Throwable e) {
			this.ea.writeException(e);
		}finally{
			Window w = SwingUtilities.getWindowAncestor((Component) arg0.getSource());
			w.dispose();
		}
	}

	private static boolean �K���Ȗ��O(String type, Class<?> p2){
		boolean result = true;
		if(type == "boolean" || p2 == boolean.class && p2 == Boolean.class/*type == "boolean" && p2 == boolean.class || type == "boolean" && p2 == Boolean.class*/){
			result = false;
		} else if(type == "char" && p2 == char.class || type == "char" && p2 == Character.class){
			result = false;
		} else if(type == "byte" && p2 == byte.class || type == "byte" && p2 == Byte.class){
			result = false;
		} else if(type == "short" && p2 == short.class || type == "short" && p2 == Short.class){
			result = false;
		} else if(type == "int" && p2 == int.class || type == "int" && p2 == Integer.class){
			result = false;
		} else if(type == "long" && p2 == long.class || type == "long" && p2 == Long.class){
			result = false;
		} else if(type == "float" && p2 == float.class || type == "float" && p2 == Float.class){
			result = false;
		} else if(type == "double" && p2 == double.class || type == "double" && p2 == Double.class){
			result = false;
		}

		else if(type == "Boolean" && p2 == boolean.class || type == "Boolean" && p2 == Boolean.class){
			result = false;
		} else if(type == "Character" && p2 == char.class || type == "Character" && p2 == Character.class){
			result = false;
		} else if(type == "Byte" && p2 == byte.class || type == "Byte" && p2 == Byte.class){
			result = false;
		} else if(type == "Short" && p2 == short.class || type == "Short" && p2 == Short.class){
			result = false;
		} else if(type == "Integer" && p2 == int.class || type == "Integer" && p2 == Integer.class){
			result = false;
		} else if(type == "Long" && p2 == long.class || type == "Long" && p2 == Long.class){
			result = false;
		} else if(type == "Float" && p2 == float.class || type == "Float" && p2 == Float.class){
			result = false;
		} else if(type == "Double" && p2 == double.class || type == "Double" && p2 == Double.class){
			result = false;
		}
		return result;
	}

}
