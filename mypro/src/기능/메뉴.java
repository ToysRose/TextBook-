package 기능;

import Main.UI;
import 커넥터.BaseUI;
import 커넥터.Dao;

public class 메뉴 extends UI implements BaseUI{
private Dao dao;
	
	public 메뉴(Dao dao) {
		this.dao=dao;
	}
	
	
	
	public void service() {
		
	}
}
