package login;

import java.util.Scanner;

import InterfaceA.BaseUI;
import Main.UI;
import Vo.Userdata;
import userDao.userDao;

public class userDelete implements BaseUI{

	private Userdata LoginInfo;
	
	public userDelete(Userdata LoginInfo) {
		this.LoginInfo=LoginInfo;
	}
	
	public void service() {
	new userDao().deleteUser(LoginInfo.getId());
	}

}
