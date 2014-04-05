package editingObject;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Method;

import javax.swing.JList;

import method.メソッドパラメータ入力UI;
import openingScreen.Models;

import component.ExceptionArea;


public class 配列以外メンバUIメソッド選択マウスリスナ implements MouseListener {

	private final JList jl;
	private final Models mdls;
	private final ExceptionArea ea;

	public 配列以外メンバUIメソッド選択マウスリスナ(JList methodList, Models mdls, ExceptionArea ea){
		this.jl = methodList;
		this.mdls = mdls;
		this.ea = ea;
	}

	@Override
	public void mouseClicked( MouseEvent arg0) {
		Method selectedMethod = (Method) this.jl.getSelectedValue();
		this.jl.clearSelection();// もとのリストの選択を解除
		メソッドパラメータ入力UI mui = new メソッドパラメータ入力UI(selectedMethod, this.mdls,this.ea);
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
