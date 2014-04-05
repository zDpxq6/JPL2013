package openingScreen;

import component.ExceptionArea;
import component.ListPane;

import ex16_Interpret.リフレクションスタートUI生成済オブジェクト選択マウスリスナ;

public class ObjectListPane extends ListPane
{

	private static final long serialVersionUID = 1L;
	//selectedInstanceでどうするか
	public ObjectListPane(Models mdls, ExceptionArea ea){
		super(mdls.get生成済オブジェクト一覧(), new リフレクションスタートUI生成済オブジェクト選択マウスリスナ(mdls, ea));
	}

}
