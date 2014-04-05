package ex16_Interpret;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import openingScreen.Models;

import component.ExceptionArea;

import editingArray.配列メンバUI;
import editingObject.配列以外メンバUI;


public class リフレクションスタートUI生成済オブジェクト選択マウスリスナ implements MouseListener {

	private final ExceptionArea ea;
	private Object selectedInstance;
	private final Models mdls;

	public リフレクションスタートUI生成済オブジェクト選択マウスリスナ(Models mdls, ExceptionArea ea){
		this.mdls = mdls;
		this.ea = ea;
	}

	@Override
	public void mouseClicked( MouseEvent arg0) {
		this.selectedInstance = this.mdls.get生成済オブジェクト一覧().getSelectedValue();
		this.mdls.get生成済オブジェクト一覧().clearSelection();// もとのリストの選択を解除
		JFrame frame = null;
		if(this.selectedInstance.getClass().isArray()){
			frame = new 配列メンバUI(this.selectedInstance, this.mdls, this.ea);
		}else{
			frame = new 配列以外メンバUI(this.selectedInstance, this.mdls, this.ea);
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
