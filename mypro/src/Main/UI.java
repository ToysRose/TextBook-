package Main;

import java.util.Scanner;

import 기능.로그인;
import 기능.맞춤메뉴;
import 기능.메뉴;
import 기능.메뉴검색;
import 기능.시그니쳐메뉴;
import 기능.추천메뉴;
import 기능.회원가입;
import 커넥터.BaseUI;
import 커넥터.Dao;

public class UI {

	private Dao dao =new Dao();
	public Scanner sc =new Scanner(System.in);
	protected boolean login = false;
	
	public void service() {
		
		BaseUI ui =null;
	 outer : 
		 while (true) {
			 
	if(login == false) {
		
			switch(menu()) {
			
			case 1: ui = new 로그인(dao); break;
			case 2: ui = new 메뉴(dao); break;
			case 3: ui = new 맞춤메뉴(dao); break;
			case 4: ui = new 추천메뉴(dao); break;
			case 5: ui = new 메뉴검색(dao); break;
			case 6: ui = new 회원가입(dao); break;
			
			case 0: exit();
			default : {
				System.out.println("잘못 선택하셧습니다.");
				System.out.println("다시 선택해 주세요.");
				break;
			}
			}
		} else {
			 switch(menu()) {
				
				case 1: ui = new 로그인(dao); break;
				case 2: ui = new 메뉴(dao); break;
				case 3: ui = new 맞춤메뉴(dao); break;
				case 4: ui = new 추천메뉴(dao); break;
				case 5: ui = new 메뉴검색(dao); break;
				case 6: ui = new 회원가입(dao); break;
				case 7: ui = new 시그니쳐메뉴(dao); break;
				case 0: exit();
				default : {
					System.out.println("잘못 선택하셧습니다.");
					System.out.println("다시 선택해 주세요.");
					break;
				}
		 }
		}
	if (ui !=null) ui.service();	 
	}
	}
	int menu() {
		if(login == false) {
			System.out.println("=====================");
			System.out.println("1.로그인");
			System.out.println("2.메뉴");
			System.out.println("3.맞춤메뉴");
			System.out.println("4.추천메뉴");
			System.out.println("5.메뉴검색");
			System.out.println("6.회원가입");
			System.out.println("0.종료");
			System.out.println("=====================");
			System.out.println("메뉴를 선택하세요.");
		} else {
		System.out.println("=====================");
		System.out.println("1.로그아웃");
		System.out.println("2.메뉴");
		System.out.println("3.맞춤메뉴");
		System.out.println("4.추천메뉴");
		System.out.println("5.메뉴검색");
		System.out.println("6.회원가입");
		System.out.println("7.시그니쳐 메뉴");
		System.out.println("0.종료");
		System.out.println("=====================");
		System.out.println("메뉴를 선택하세요.");
	}
		return Integer.parseInt(sc.nextLine());
	}
	void exit() {
		System.out.println("게시판 시스템을 종료합니다.");
		sc.close();
		System.exit(0);
	}
}
