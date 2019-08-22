package menu;

import java.util.Random;

import InterfaceA.BaseUI;
import Vo.Userdata;

public class recomMenuBoardUI implements BaseUI{
	
	private Userdata LoginInfo;
	private int no;

	public recomMenuBoardUI(Userdata LoginStatus) {
		this.LoginInfo = LoginStatus;
		this.no=new Random().nextInt(8)+1;
	}

	public void service() {
	new menuAll(LoginInfo).burger(no);
}
}
