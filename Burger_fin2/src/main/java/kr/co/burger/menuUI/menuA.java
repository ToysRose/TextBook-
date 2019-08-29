package kr.co.burger.menuUI;

import cmd.cmd;
import kr.co.burger.InterfaceA.BaseUI;
import kr.co.burger.domain.Userdate;
import kr.co.burger.start.UI;

public class menuA implements BaseUI{

	private Userdate LoginInfo;
	public menuA(Userdate LoginStatus) {
		cmd.cmdSkip();
		this.LoginInfo=LoginStatus;
	}
	
	private int menu() {
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.println("1. 전체 메뉴");
		System.out.println("2. 추천 메뉴");
//		System.out.println("3. 메뉴 검색");
//		System.out.println("4. 시그니쳐 메뉴");
		System.out.println("0. 이전");
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.print("입력 : ");
		return Integer.parseInt(UI.sc.nextLine());
	}

	public void service() {
		System.out.println("---------------------------");
		System.out.println("원하는 메뉴를 선택하세요.");
		System.out.println("---------------------------");
		while (true) {
			switch (menu()) {
			case 1: new MenulistBoardUI(LoginInfo); break;
			case 2: new recomMenuBoardUI(LoginInfo).service(); break;
//			case 3: ui = new searchMenuBoardUI(dao); break;
//			case 4: ui = new signatureMenuBoardUI(dao); break;
			case 0: return;
			default: 
				System.out.println("잘못된 번호입니다.");
				System.out.println("다시 선택해 주세요.");break;
			}
		}
	}
}
