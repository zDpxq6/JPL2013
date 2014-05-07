package ex16_Interpret;
import java.awt.Component;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import javax.swing.JComboBox;
import javax.swing.SwingUtilities;

import component.ExceptionArea;


public class �����oUI�t�B�[���h����{�^�����X�i implements ActionListener {
	private final Object selectedInstance;
	private final ExceptionArea ea;
	private final JComboBox[] �t�B�[���h���̓R���{�{�b�N�X�A���C;
	private final Field[] �t�B�[���h�z��;

	public �����oUI�t�B�[���h����{�^�����X�i(Object selectedInstance, JComboBox[] �t�B�[���h���̓R���{�{�b�N�X�A���C, ExceptionArea ea) {
		this.selectedInstance = selectedInstance;
		this.�t�B�[���h�z�� = selectedInstance.getClass().getDeclaredFields();
		this.�t�B�[���h���̓R���{�{�b�N�X�A���C = �t�B�[���h���̓R���{�{�b�N�X�A���C;
		this.ea = ea;
	}

	@Override
	public void actionPerformed( ActionEvent arg0) {
		try {
			Class<?>[] �t�B�[���h�^�z�� = new Class<?>[this.�t�B�[���h���̓R���{�{�b�N�X�A���C.length];
			int i = -1;
			for(JComboBox comboBox :this.�t�B�[���h���̓R���{�{�b�N�X�A���C){
				i++;
				�t�B�[���h�^�z��[i] = this.�t�B�[���h�z��[i].getType();

				int mod = this.�t�B�[���h�z��[i].getModifiers();

				if(Modifier.isStatic(mod)){
					System.out.print("static ");
					if(Modifier.isFinal(mod)){
						System.out.println("final");
					}
				}else {
					if(Character.TYPE.equals(�t�B�[���h�^�z��[i])){
						this.�t�B�[���h�z��[i].setAccessible(true);
						this.�t�B�[���h�z��[i].setChar(this.selectedInstance, (Character)comboBox.getSelectedItem());
					}else if(Byte.TYPE.equals(�t�B�[���h�^�z��[i])){
						this.�t�B�[���h�z��[i].setAccessible(true);
						this.�t�B�[���h�z��[i].setByte(this.selectedInstance, (Byte)comboBox.getSelectedItem());
					}else if(Short.TYPE.equals(�t�B�[���h�^�z��[i])){
						this.�t�B�[���h�z��[i].setAccessible(true);
						this.�t�B�[���h�z��[i].setShort(this.selectedInstance, (Short)comboBox.getSelectedItem());
					}else if(Integer.TYPE.equals(�t�B�[���h�^�z��[i])){
						this.�t�B�[���h�z��[i].setAccessible(true);
						this.�t�B�[���h�z��[i].setInt(this.selectedInstance, (Integer) comboBox.getSelectedItem());
					}else if(Long.TYPE.equals(�t�B�[���h�^�z��[i])){
						this.�t�B�[���h�z��[i].setAccessible(true);
						this.�t�B�[���h�z��[i].setLong(this.selectedInstance, (Long) comboBox.getSelectedItem());
					}else if(Float.TYPE.equals(�t�B�[���h�^�z��[i])){
						this.�t�B�[���h�z��[i].setAccessible(true);
						this.�t�B�[���h�z��[i].setFloat(this.selectedInstance, (Float)comboBox.getSelectedItem());
					}else if(Double.TYPE.equals(�t�B�[���h�^�z��[i])){
						this.�t�B�[���h�z��[i].setAccessible(true);
						this.�t�B�[���h�z��[i].setDouble(this.selectedInstance, (Double)comboBox.getSelectedItem());
					}else if(Boolean.TYPE.equals(�t�B�[���h�^�z��[i])){
						this.�t�B�[���h�z��[i].setAccessible(true);
						this.�t�B�[���h�z��[i].setBoolean(this.selectedInstance, (Boolean) comboBox.getSelectedItem());
					} else {
						this.�t�B�[���h�z��[i].setAccessible(true);
						this.�t�B�[���h�z��[i].set(this.selectedInstance,comboBox.getSelectedItem());
					}
				}
			}
		} catch (Throwable e) {
			this.ea.writeException(e);
		} finally {
			Window w = SwingUtilities.getWindowAncestor((Component) arg0.getSource());
			w.dispose();
		}
	}
}
