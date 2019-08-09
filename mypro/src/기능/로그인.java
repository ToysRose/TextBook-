package 기능;

import java.util.List;

import javax.print.DocFlavor.STRING;

import Database.Userdata;
import Main.UI;
import 커넥터.BaseUI;
import 커넥터.Dao;

public class 로그인 extends UI implements BaseUI {

	private Dao dao;
	
	public 로그인(Dao dao) {
		this.dao=dao;
	}
	
	
	
	public void service() {
		//로그 아웃 기능 트루 상태에서 누르면 바로 폴스로 바꿈
		if(login == true) login = false; 
		else {
		System.out.println("아이디를 입력하세요");
		String id= sc.nextLine();
		System.out.println("비밀번호를 입력하세요");
		String pass= sc.nextLine();
		 List arr =dao.select();
		if (id.equals(dao.) && pass.equals(anObject)          )
		
		
		login=true;
		}
	}



}
