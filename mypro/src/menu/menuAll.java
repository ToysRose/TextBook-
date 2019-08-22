package menu;

import InterfaceA.BaseUI;
import Main.UI;
import Vo.BurgerDate;
import Vo.Userdata;
import menuDao.menuDao;

public class menuAll {
//하나의 번호받아서 그 버거 정보 뿌려주는 메소드
	private menuDao dao;
	private Userdata LoginInfo;

	public menuAll(Userdata LoginStatus) {
		this.LoginInfo = LoginStatus;
		this.dao = new menuDao();
	}

	public void burger(int code) {
		if(LoginInfo!=null) inBurger(code);
		else outBurger(code);
	}

	public void inBurger(int code) {
		

		BaseUI ui = null;
		BurgerDate b = dao.burgerOneselect(code);
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.println("이름" + b.getMenu());
		System.out.println("가격" + b.getPrice());
		System.out.println("칼로리" + b.getKcal());
		System.out.println("추천수" + b.getRecom());
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

		while (true) {

			System.out.println("1. 추천하기");
			System.out.println("2. 결제하기");
			System.out.println("3. 리뷰");
			System.out.println("0. 이전");
			System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			System.out.print("선택하세요 : ");
			
			switch (Integer.parseInt(UI.sc.nextLine())) {
//			case 1: new recomBoardUI(); break;
			case 2: ui = new PayBoardUI();	break;
			case 3: new menuReviewUI(code,LoginInfo).service(); break;
			case 0: return;
			}
			if (ui != null)
				ui.service();
		}
		
	}
	
	public void outBurger(int code) {
		

		BaseUI ui = null;
		BurgerDate b = dao.burgerOneselect(code);
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.println("이름" + b.getMenu());
		System.out.println("가격" + b.getPrice());
		System.out.println("칼로리" + b.getKcal());
		System.out.println("추천수" + b.getRecom());
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

		while (true) {

			System.out.println("1. 추천하기");
			System.out.println("0. 이전");
			System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			System.out.print("선택하세요 : ");
			
			switch (Integer.parseInt(UI.sc.nextLine())) {
			case 1: ui = new PayBoardUI();	break;
			case 0: return;
			}
			if (ui != null)
				ui.service();
		}
		
	}
	
}
