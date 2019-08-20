package login;

import java.util.Scanner;

import InterfaceA.BaseUI;
import Main.UI;
import Vo.Userdata;
import userDao.userDao;


public class logIn extends UI implements BaseUI {

	private userDao dao;

	Scanner scan = new UI().sc;
	
	public logIn() {
		this.dao=new userDao();
	}

	public void service() {
		System.out.println("아이디");
		String id =scan.nextLine();
		System.out.println("비밀번호");
		String pass =scan.nextLine();

		Userdata login =dao.logIn(id,pass);
		if (login == null) {
			System.out.println("아이디 또는 패스워드가 올바르지 않습니다.");
			return;
		}
		UI.LoginStatus = login;
		System.out.println("로그인 되었습니다.");
		}
	}
