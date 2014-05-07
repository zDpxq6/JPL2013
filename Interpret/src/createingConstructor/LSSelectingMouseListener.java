package createingConstructor;
import java.awt.Component;
import java.awt.Window;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Constructor;

import javax.swing.JList;
import javax.swing.SwingUtilities;

import component.ExceptionArea;
import component.Models;


public class LSSelectingMouseListener implements MouseListener {

	private final ExceptionArea ea;
	private final Models mdls;
	private final JList jl;

	public LSSelectingMouseListener(ConstructorListScreen �R���X�g���N�^�I��ui, Models mdls, ExceptionArea ea){
		this.jl = �R���X�g���N�^�I��ui.getList();
		this.mdls = mdls;
		this.ea =ea;
	}

	@Override
	public void mouseClicked( MouseEvent arg0) {
		try {
			Constructor<?> selectedConstructor = (Constructor<?>) this.jl.getSelectedValue();// �w�肵���R���X�g���N�^���擾
			Class<?>[] constructorParameterTypeArray = selectedConstructor.getParameterTypes();// �R���X�g���N�^�̈����̌^���擾
			if(constructorParameterTypeArray.length == 0){
				Object createdInstance = selectedConstructor.newInstance();
				this.mdls.getListModel().addElement(createdInstance);
				this.mdls.getComboBoxModel().addElement(createdInstance);
			}else if(0 < constructorParameterTypeArray.length){
				@SuppressWarnings("unused")
				ParameterScreen pui = new ParameterScreen(selectedConstructor, this.mdls, this.ea);
			}else{
				throw new Exception();
			}
		}catch (Throwable e){
			this.ea.writeException(e);
		} finally {
			Window w = SwingUtilities.getWindowAncestor((Component) arg0.getSource());
			w.dispose();
		}
	}

	@Override
	public void mouseEntered( MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited( MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed( MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased( MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
