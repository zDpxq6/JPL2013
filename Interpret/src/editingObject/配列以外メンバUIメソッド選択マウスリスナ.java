package editingObject;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Method;

import javax.swing.JList;

import method.���\�b�h�p�����[�^����UI;

import component.ExceptionArea;
import component.Models;


public class �z��ȊO�����oUI���\�b�h�I���}�E�X���X�i implements MouseListener {

	private final JList jl;
	private final Models mdls;
	private final ExceptionArea ea;
	private final Object selectedInstance;

	public �z��ȊO�����oUI���\�b�h�I���}�E�X���X�i(JList methodList, Object obj, Models mdls, ExceptionArea ea){
		this.jl = methodList;
		this.selectedInstance = obj;
		this.mdls = mdls;
		this.ea = ea;
	}

	@Override
	public void mouseClicked( MouseEvent arg0) {
		System.out.println("null?");
		Method selectedMethod = (Method) this.jl.getSelectedValue();
		this.jl.clearSelection();
		System.out.println("null?");
		���\�b�h�p�����[�^����UI mui = new ���\�b�h�p�����[�^����UI(selectedMethod, this.selectedInstance, this.mdls, this.ea);
		mui.setVisible(true);
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
