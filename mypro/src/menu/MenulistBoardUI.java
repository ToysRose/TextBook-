package menu;

import InterfaceA.BaseUI;
import Main.UI;
import Vo.BurgerDate;
import Vo.Userdata;
import menuDao.selectmenuDao;

public class MenulistBoardUI implements BaseUI {
	private selectmenuDao dao;
	private Userdata LoginInfo;

	public MenulistBoardUI(Userdata LoginStatus) {
		this.LoginInfo = LoginStatus;
		this.dao = new selectmenuDao();
	}

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

	public void service() {
		while (true) {
			switch (menu()) {
			case 1: burger(1); break;
			case 2: burger(2); break;
			case 3: burger(3); break;
			case 4: burger(4); break;
			case 5: burger(5); break;
			case 6: burger(6); break;
			case 7: burger(7); break;
			case 8: burger(8); break;
			case 0: return;
			default: {
				System.out.println("잘못된 메뉴번호 입니다.");
				System.out.println("다시 선택해 주세요.");
				break;
			}
			}
		}
	}

	public void burger(int no) {

		BurgerDate b = dao.burgerOneselect(no);
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.println("이름" + b.getMenu());
		System.out.println("가격" + b.getPrice());
		System.out.println("칼로리" + b.getKcal());
		System.out.println("추천수" + b.getRecom());
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

		service1();

	}

	public void service1() {
		BaseUI ui = null;
		while (true) {

			switch (menu1()) {
//			case 1: new recomBoardUI(); break;
			case 2: ui = new PayBoardUI();	break;
//			case 3: new reviewBoardUI(); break;
			case 0: return;
			}
			if (ui != null)
				ui.service();
		}
	}

	public int menu1() {

		System.out.println("1. 추천하기");
		System.out.println("2. 결제하기");
		System.out.println("3. 리뷰");
		System.out.println("0. 이전");
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.print("선택하세요 : ");
		return Integer.parseInt(UI.sc.nextLine());
	}

}