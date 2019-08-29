package kr.co.burger.menuUI;

import java.util.Random;

import cmd.cmd;
import kr.co.burger.InterfaceA.BaseUI;
import kr.co.burger.domain.Userdate;

public class recomMenuBoardUI implements BaseUI{
	
	private Userdate LoginInfo;
	private int no;

	public recomMenuBoardUI(Userdate LoginStatus) {
		cmd.cmdSkip();
		this.LoginInfo = LoginStatus;
		this.no=new Random().nextInt(8)+1;
	}

	public void service() {
	new menuAll(LoginInfo).burger(no);
}
}

