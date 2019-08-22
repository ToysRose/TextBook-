package shop;

import InterfaceA.BaseUI;
import Main.UI;
import Vo.Userdata;
import Vo.shopDate;
import shopDao.recomDAO;
import shopDao.shopDao;

public class shop implements BaseUI{

	private Userdata LoginInfo;
	
	public shop(Userdata LoginStatus) {
		this.LoginInfo=LoginStatus;
	}
	
	public void service() {
		if(LoginInfo!=null) inShop();
		else outShop();
		}
	
	public void inShop() {
		int code = 0;
		shopDate sd=new shopDao().shopSelect(code=menu());
		
		while(true) {
		System.out.println("번호 : " + sd.getCode());
		System.out.println("지점명 : " + sd.getName());
		System.out.println("지점 주소 : " + sd.getShop_address());
		System.out.println("전화번호 : " + sd.getPhone_no());
		System.out.println("추천 수 : " + sd.getRecom_cnt());
		//뿌려주고
		System.out.println("-------------------------------");
		System.out.println("1.추천");
		System.out.println("2.리뷰");
		System.out.println("0.이전");
		
		switch(Integer.parseInt(UI.sc.nextLine())) {
		case 1 :  
			if(new recomDAO().recom1(code,LoginInfo) == 0) System.out.println("추천되었습니다.");
			else System.out.println("이미 추천하셨습니다."); break;
		case 2 : new shopReviewUI(code,LoginInfo).service(); break;
		case 0 : return;
		default : {System.out.println("잘못선택하셧습니다.");
			System.out.println("다시선택해주세요.");
		}
		}
		}
	}
	
	public void outShop() {
		shopDate sd=new shopDao().shopSelect(menu());
		
		while(true) {
		System.out.println("번호 : " + sd.getCode());
		System.out.println("지점명 : " + sd.getName());
		System.out.println("지점 주소 : " + sd.getShop_address());
		System.out.println("전화번호 : " + sd.getPhone_no());
		System.out.println("추천 수 : " + sd.getRecom_cnt());
		//뿌려주고
		System.out.println("-------------------------------");
		System.out.println("0.이전");
		
		switch(Integer.parseInt(UI.sc.nextLine())) {
		case 0 : return;
		}
		}
	}
	
	public int menu() {
		System.out.println("1.신촌점");
		System.out.println("2.강남점");
		System.out.println("3.종로점");
		System.out.println("지점을 선택하세요.");
		return Integer.parseInt(UI.sc.nextLine());
	}
}
