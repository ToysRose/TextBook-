package kr.co.burger.loginUi;

import kr.co.burger.InterfaceA.BaseUI;
import kr.co.burger.start.UI;

public class logOut implements BaseUI{

	public void service() {
		
		UI.LoginStatus = null;
		System.out.println("로그아웃 되었습니다.");
		
	}
}
