package shop;

import InterfaceA.BaseUI;
import Main.UI;
import Vo.shopDate;
import shopDao.recom;
import shopDao.shopDao;

public class shop implements BaseUI{

	public void service() {
		shopDate sd=new shopDao().shopSelect(menu());
	
		while(true) {
		System.out.println(sd.getCode());
		//뿌려주고
		System.out.println("1추천");
		System.out.println("2리뷰추천");
		System.out.println("0이전");
		
		switch(Integer.parseInt(UI.sc.nextLine())) {
		
		case 1 : new recom(sd.getCode()).recomIn();; break;
		case 2 : new review(); break;
		case 0 : return;

		}
		}
		}
	
	public int menu() {
		System.out.println("지점명을 입력하세요.");
		return Integer.parseInt(UI.sc.nextLine());
	}
}
