package kr.co.burger.menuUI;

import cmd.cmd;
import kr.co.burger.start.UI;

public class PayBoardUI {

	public PayBoardUI() {
		cmd.cmdSkip();
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.println("1. 현금결제");
		System.out.println("2. 카드결제");
		System.out.println("0. 뒤로가기");
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.print("메뉴 중 처리할 항목을 선택하세요 : ");
		int no = Integer.parseInt(UI.sc.nextLine());
		switch (no) {
		case 1:
			System.out.println("결제되었습니다.");break;
		case 2:
			System.out.println("결제되었습니다.");break;
		case 0:return;
		default:
			System.out.println("잘못된 번호입니다.");
			System.out.println("다시 선택해 주세요.");
		}
	}
}
