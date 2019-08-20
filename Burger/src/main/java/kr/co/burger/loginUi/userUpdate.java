package kr.co.burger.loginUi;

import java.util.Scanner;

import kr.co.burger.domain.User;
import kr.co.burger.start.UI;
import kr.co.burger.userDao.BaseUI;
import kr.co.burger.userDao.userDao;

public class userUpdate implements BaseUI{

	private User LoginInfo; 
	
	public userUpdate(User LoginInfo) {
		this.LoginInfo=LoginInfo;
	}
	
	public void service() {
		Scanner sc=UI.sc;
		User u=new User();
		System.out.println("수정할 주소를 입력해주세요");
		u.setAddress(sc.nextLine());
		System.out.println("수정할 핸드폰번호를 입력해주세요");
		u.setPhone_no(sc.nextLine());
		System.out.println("수정할 이름을 입력해주세요");
		u.setName(sc.nextLine());
		new userDao().updateUser(LoginInfo.getId(),u);
	}

}
