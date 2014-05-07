package method;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;

import javax.swing.JComboBox;

import component.ExceptionArea;
import component.Models;


public class ���\�b�h�p�����[�^����UI���\�b�h���s�{�^�����X�i implements ActionListener {

	private final Method selectedMethod;
	private final JComboBox[] ���\�b�h�p�����[�^���̓R���{�{�b�N�X�A���C;
	private final Models mdls;
	private final ExceptionArea ea;
	private final Object obj;

	public ���\�b�h�p�����[�^����UI���\�b�h���s�{�^�����X�i(Method selectedMethod, Object obj, JComboBox[] ���\�b�h�p�����[�^���̓R���{�{�b�N�X�A���C, Models mdls,ExceptionArea ea) {
		this.selectedMethod = selectedMethod;
		this.���\�b�h�p�����[�^���̓R���{�{�b�N�X�A���C = ���\�b�h�p�����[�^���̓R���{�{�b�N�X�A���C;
		this.mdls = mdls;
		this.ea = ea;
		this.obj = obj;
		System.out.println("�����܂�OK");
	}

	@Override
	public void actionPerformed( ActionEvent arg0) {
		try {
		Class<?>[] methodParameterTypeArray = this.selectedMethod.getParameterTypes();
		Object[] parameterArray = new Object[methodParameterTypeArray.length];
		Object tmp = null;
		int i = 0;
		for(JComboBox comboBox :this.���\�b�h�p�����[�^���̓R���{�{�b�N�X�A���C){
			String type = methodParameterTypeArray[i].toString();
			if("char".equals(type)){
				char[] charArray = ((String) comboBox.getSelectedItem()).toCharArray();
				tmp = charArray[0];
			}else if("byte".equals(type)){
				tmp = Byte.valueOf((String) comboBox.getSelectedItem());
			}else if("short".equals(type)){
				tmp = Short.valueOf((String) comboBox.getSelectedItem());
			}else if("int".equals(type)){
				System.out.println("�^: " + comboBox.getSelectedItem().getClass());
				tmp = Integer.valueOf((String) comboBox.getSelectedItem());
			}else if("long".equals(type)){
				tmp = Long.valueOf((String) comboBox.getSelectedItem());
			}else if("float".equals(type)){
				tmp = Float.valueOf((String) comboBox.getSelectedItem());
			}else if("double".equals(type)){
				tmp = Double.valueOf((String) comboBox.getSelectedItem());
			}else if("boolean".equals(type)){
				tmp = Boolean.valueOf((String) comboBox.getSelectedItem());
			} else {
				tmp = comboBox.getSelectedItem();
			}
			parameterArray[i] = tmp;
			i++;
		}
			//�������򂪓���(void,primitive�ȊO�͒ǉ�)
			Object createdInstance = this.selectedMethod.invoke(this.obj, parameterArray);
			if(createdInstance instanceof Object){
				this.mdls.getListModel().addElement(createdInstance);
			}
		} catch (Throwable e) {
			this.ea.writeException(e);
		}
	}


}
