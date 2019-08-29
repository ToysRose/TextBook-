package kr.co.burger.menuUI;

import cmd.cmd;
import kr.co.burger.domain.Userdate;
import kr.co.burger.start.UI;

public class MenulistBoardUI {
	private Userdate LoginInfo;

	public int menu() {
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.println("1. 불고기버거");
		System.out.println("2. 비프버거");
		System.out.println("3. 양고기버거");
		System.out.println("4. 치킨버거");
		System.out.println("5. 아보카도버거");
		System.out.println("6. 올리브버거");
		System.out.println("7. 와규와규버거");
		System.out.println("8. 하와이안버거");
		System.out.println("0. 뒤로가기");
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.print("햄버거를 고르세요 : ");
		return Integer.parseInt(UI.sc.nextLine());
	}

	public MenulistBoardUI(Userdate LoginStatus) {
		cmd.cmdSkip();
		this.LoginInfo = LoginStatus;
		while (true) {
			switch (menu()) {
			case 1: new menuAll(LoginInfo).burger(1); break;
			case 2: new menuAll(LoginInfo).burger(2); break;
			case 3: new menuAll(LoginInfo).burger(3); break;
			case 4: new menuAll(LoginInfo).burger(4); break;
			case 5: new menuAll(LoginInfo).burger(5); break;
			case 6: new menuAll(LoginInfo).burger(6); break;
			case 7: new menuAll(LoginInfo).burger(7); break;
			case 8: new menuAll(LoginInfo).burger(8); break;
			case 0: return;
			default: {
				System.out.println("잘못된 메뉴번호 입니다.");
				System.out.println("다시 선택해 주세요.");
				break;
			}
			}
		}
	}

}