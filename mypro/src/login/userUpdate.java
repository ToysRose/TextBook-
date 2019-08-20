package login;

import java.util.Scanner;

import InterfaceA.BaseUI;
import Main.UI;
import Vo.Userdata;
import userDao.userDao;

public class userUpdate implements BaseUI{

	private Userdata LoginInfo; 
	
	public userUpdate(Userdata LoginInfo) {
		this.LoginInfo=LoginInfo;
	}
	
	public void service() {
		Scanner sc=UI.sc;
		Userdata u=new Userdata();
		System.out.println("수정할 주소를 입력해주세요");
		u.setAddress(sc.nextLine());
		System.out.println("수정할 핸드폰번호를 입력해주세요");
		u.setPhone_no(sc.nextLine());
		System.out.println("수정할 이름을 입력해주세요");
		u.setName(sc.nextLine());
		new userDao().updateUser(LoginInfo.getId(),u);
	}

}
