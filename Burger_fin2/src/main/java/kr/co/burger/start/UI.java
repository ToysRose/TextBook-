package kr.co.burger.start;

import java.util.Scanner;

import kr.co.burger.InterfaceA.BaseUI;
import kr.co.burger.domain.Userdate;
import kr.co.burger.loginUi.logIn;
import kr.co.burger.loginUi.logOut;
import kr.co.burger.loginUi.userInfo;
import kr.co.burger.loginUi.userJoin;
import kr.co.burger.menuUI.menuA;
import kr.co.burger.noticeUI.noticeUI;
import kr.co.burger.shop.shop;

public class UI {
	
public static Userdate LoginStatus = null;

public static Scanner sc = new Scanner(System.in);

	public void service() {
		BaseUI ui =null;
		while(true) {
			if(LoginStatus == null) {
				switch(menuview()) {
				case 1 : ui= new logIn(); break;
				case 2 : ui= new menuA(LoginStatus);break;
				case 3 : ui= new userJoin(); break;
				case 4 : ui= new shop(LoginStatus);  break;
				case 5 : ui= new noticeUI(LoginStatus); break;
				case 0 : exit();
				default :  System.out.println("잘못선택했습니다"); break;
				}
			}else {
				switch(menuview()) {
				case 1 : ui= new logOut(); break;
				case 2 : ui= new menuA(LoginStatus);break;
				case 3 : ui= new userInfo(LoginStatus); break;
				case 4 : ui= new shop(LoginStatus);  break;
				case 5 : ui= new noticeUI(LoginStatus); break;
				case 0 : exit();
				default :  System.out.println("잘못선택했습니다"); break;
				}
			}if(ui!=null)ui.service();
		}
		
	}
	
	
public int menuview() {
	if(LoginStatus == null) {
	System.out.println("------------------------");
	System.out.println("메인메뉴");
	System.out.println("------------------------");
	System.out.println("1.로그인");	
	System.out.println("2.메뉴");	
	System.out.println("3.회원가입");	
	System.out.println("4.지점");	
	System.out.println("5.공지사항");	
	System.out.println("0.종료");	
	System.out.println("-------------------------");	
	System.out.println("번호를 선택해주세요.");	
	}else {
		System.out.println("------------------------");
		System.out.println("메인메뉴");
		System.out.println("------------------------");
		System.out.println("1.로그아웃");	
		System.out.println("2.메뉴");	
		System.out.println("3.회원정보");	
		System.out.println("4.지점");	
		System.out.println("5.공지사항");	
		System.out.println("0.종료");	
		System.out.println("-------------------------");	
		System.out.println("번호를 선택해주세요.");
	}
	return Integer.parseInt(sc.nextLine());
}

private void exit() {
	System.out.println("시스템을 종료합니다.");
	sc.close();
	System.exit(0);
}
}