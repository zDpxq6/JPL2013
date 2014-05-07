package ex16_Interpret;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import component.ExceptionArea;
import component.Models;
import editingArray.�z�񃁃��oUI;
import editingObject.�z��ȊO�����oUI;


public class ���t���N�V�����X�^�[�gUI�����σI�u�W�F�N�g�I���}�E�X���X�i implements MouseListener {

	private final ExceptionArea ea;
	private Object selectedInstance;
	private final Models mdls;

	public ���t���N�V�����X�^�[�gUI�����σI�u�W�F�N�g�I���}�E�X���X�i(Models mdls, ExceptionArea ea){
		this.mdls = mdls;
		this.ea = ea;
	}

	@Override
	public void mouseClicked( MouseEvent arg0) {
		this.selectedInstance = this.mdls.getList().getSelectedValue();
		this.mdls.getList().clearSelection();// ���Ƃ̃��X�g�̑I��������
		JFrame frame = null;
		if(this.selectedInstance.getClass().isArray()){
			frame = new �z�񃁃��oUI(this.selectedInstance, this.mdls, this.ea);
		}else{
			frame = new �z��ȊO�����oUI(this.selectedInstance, this.mdls, this.ea);
		}
		frame.setVisible(true);
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
