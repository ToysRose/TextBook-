package kr.co.burger.loginUi;

import kr.co.burger.domain.User;
import kr.co.burger.userDao.BaseUI;
import kr.co.burger.userDao.userDao;

public class userDelete implements BaseUI{

	private User LoginInfo;
	
	public userDelete(User LoginInfo) {
		this.LoginInfo=LoginInfo;
	}
	
	public void service() {
	new userDao().deleteUser(LoginInfo.getId());
	}

}
