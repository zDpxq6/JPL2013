package ex16_Interpret;
import java.awt.Component;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;

import javax.swing.JComboBox;
import javax.swing.SwingUtilities;

import component.ExceptionArea;


public class �z�񃁃��oUI�t�B�[���h����{�^�����X�i implements ActionListener {
	private final Object selectedInstance;
	private final ExceptionArea ea;
	private final JComboBox[] �z��v�f�ҏW�R���{�{�b�N�X�A���C;
//	private final Class clz;

	public �z�񃁃��oUI�t�B�[���h����{�^�����X�i(Object obj, JComboBox[] �R���{�{�b�N�X�A���C, ExceptionArea ea){
		this.�z��v�f�ҏW�R���{�{�b�N�X�A���C = �R���{�{�b�N�X�A���C;
		this.selectedInstance = obj;
		this.ea = ea;
	}

	@Override
	public void actionPerformed( ActionEvent arg0) {
		try {
//			Class<?>[] �t�B�[���h�^�z�� = new Class<?>[this.�z��v�f�ҏW�R���{�{�b�N�X�A���C.length];
			int i = 0;
			for(JComboBox comboBox :this.�z��v�f�ҏW�R���{�{�b�N�X�A���C){
				Array.set(this.selectedInstance, i++, comboBox.getSelectedItem());
//				i++;
////				�t�B�[���h�^�z��[i] = clz;
////
////				int mod = �t�B�[���h�^�z��[i].getModifiers();
//
////				if(!Modifier.isStatic(mod) && !Modifier.isFinal(mod)){
//					if(Character.TYPE.equals(this.clz)){
//						((Object)Array.get(this.selectedInstance, i)).setAccessible(true);
//						this.�z��v�f�ҏW�R���{�{�b�N�X�A���C[i].setChar(this.selectedInstance, (Character)comboBox.getSelectedItem());
//					}else if(Byte.TYPE.equals(this.clz)){
//						this.�z��v�f�ҏW�R���{�{�b�N�X�A���C[i].setAccessible(true);
//						this.�z��v�f�ҏW�R���{�{�b�N�X�A���C[i].setByte(this.selectedInstance, (Byte)comboBox.getSelectedItem());
//					}else if(Short.TYPE.equals(this.clz)){
//						this.�z��v�f�ҏW�R���{�{�b�N�X�A���C[i].setAccessible(true);
//						this.�z��v�f�ҏW�R���{�{�b�N�X�A���C[i].setShort(this.selectedInstance, (Short)comboBox.getSelectedItem());
//					}else if(Integer.TYPE.equals(this.clz)){
//						this.�z��v�f�ҏW�R���{�{�b�N�X�A���C[i].setAccessible(true);
//						this.�z��v�f�ҏW�R���{�{�b�N�X�A���C[i].setInt(this.selectedInstance, (Integer) comboBox.getSelectedItem());
//					}else if(Long.TYPE.equals(this.clz)){
//						this.�z��v�f�ҏW�R���{�{�b�N�X�A���C[i].setAccessible(true);
//						this.�z��v�f�ҏW�R���{�{�b�N�X�A���C[i].setLong(this.selectedInstance, (Long) comboBox.getSelectedItem());
//					}else if(Float.TYPE.equals(this.clz)){
//						this.�z��v�f�ҏW�R���{�{�b�N�X�A���C[i].setAccessible(true);
//						this.�z��v�f�ҏW�R���{�{�b�N�X�A���C[i].setFloat(this.selectedInstance, (Float)comboBox.getSelectedItem());
//					}else if(Double.TYPE.equals(this.clz)){
//						this.�z��v�f�ҏW�R���{�{�b�N�X�A���C[i].setAccessible(true);
//						this.�z��v�f�ҏW�R���{�{�b�N�X�A���C[i].setDouble(this.selectedInstance, (Double)comboBox.getSelectedItem());
//					}else if(Boolean.TYPE.equals(this.clz)){
//						this.�z��v�f�ҏW�R���{�{�b�N�X�A���C[i].setAccessible(true);
//						this.�z��v�f�ҏW�R���{�{�b�N�X�A���C[i].setBoolean(this.selectedInstance, (Boolean) comboBox.getSelectedItem());
//					} else {
//						this.�z��v�f�ҏW�R���{�{�b�N�X�A���C[i].setAccessible(true);
//						this.�z��v�f�ҏW�R���{�{�b�N�X�A���C[i].set(this.selectedInstance,comboBox.getSelectedItem());
//					}
////				}
			}
		} catch (Throwable e) {
			this.ea.writeException(e);
		} finally {
			Window w = SwingUtilities.getWindowAncestor((Component) arg0.getSource());
			w.dispose();
		}
	}
}
