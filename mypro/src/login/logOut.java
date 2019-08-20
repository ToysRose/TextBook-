package login;

import InterfaceA.BaseUI;
import Main.UI;

public class logOut implements BaseUI{

	public void service() {
		
		UI.LoginStatus = null;
		System.out.println("로그아웃 되었습니다.");
		
	}
}
