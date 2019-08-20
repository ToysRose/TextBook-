package kr.co.burger.loginUi;


import kr.co.burger.domain.User;
import kr.co.burger.start.UI;
import kr.co.burger.userDao.BaseUI;

public class userInfo implements BaseUI{

	private User LoginInfo;
	
	public userInfo(User LoginStatus) {
		this.LoginInfo=LoginStatus;
	}
	
	public void service() {
		
		
		
		while(true) {
			switch(Info()) {
			
			case 1 : new userUpdate(LoginInfo); break;
			case 2 : new userDelete(LoginInfo); break;
			case 0 : return;
			default : System.out.println("번호 1,2,0 중 선택해주세요.");break;
				
			}
			
			
		}
		
		
	}
	
	private int Info() {
		
		System.out.println("---------------------");
		System.out.println("아이디:"+LoginInfo.getId());
		System.out.println("주소:"+LoginInfo.getAddress());
		System.out.println("휴대폰 번호:"+LoginInfo.getPhone_no());
		System.out.println("이름:"+LoginInfo.getName());
		System.out.println("유저타입:"+LoginInfo.getUsertype());
		System.out.println("시그니쳐메뉴");
		System.out.println("---------------------");
		System.out.println("1.수정");
		System.out.println("2.삭제");
		System.out.println("0.이전");
		
		return Integer.parseInt(UI.sc.nextLine());
	}

}
