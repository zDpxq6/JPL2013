package createingConstructor;
import java.awt.Component;
import java.awt.Window;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Constructor;

import javax.swing.JList;
import javax.swing.SwingUtilities;

import openingScreen.Models;

import component.ExceptionArea;


public class LSSelectingMouseListener implements MouseListener {

	private final ExceptionArea ea;
	private final Models mdls;
	private final JList jl;

	public LSSelectingMouseListener(ListScreen コンストラクタ選択ui, Models mdls, ExceptionArea ea){
		this.jl = コンストラクタ選択ui.getList();
		this.mdls = mdls;
		this.ea =ea;
	}

	@Override
	public void mouseClicked( MouseEvent arg0) {
		try {
			Constructor<?> selectedConstructor = (Constructor<?>) this.jl.getSelectedValue();// 指定したコンストラクタを取得
			Class<?>[] constructorParameterTypeArray = selectedConstructor.getParameterTypes();// コンストラクタの引数の型を取得
			if(constructorParameterTypeArray.length == 0){
				Object createdInstance = selectedConstructor.newInstance();
				this.mdls.get生成済オブジェクトのリストモデル().addElement(createdInstance);
				this.mdls.get生成済オブジェクトのコンボボックスモデル().addElement(createdInstance);
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
