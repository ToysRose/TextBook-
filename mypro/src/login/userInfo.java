package login;


import InterfaceA.BaseUI;
import Main.UI;
import Vo.Userdata;

public class userInfo implements BaseUI{

	private Userdata LoginInfo;
	public userInfo(Userdata LoginStatus) {
		this.LoginInfo=LoginStatus;
	}
	
	public void service() {
		

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
		
		while(true) {
			switch(Integer.parseInt(UI.sc.nextLine())) {
			
			case 1 : new userUpdate(LoginInfo); return;
			case 2 : new userDelete(LoginInfo.getId()); return;
			case 0 : return;
			default : System.out.println("번호 1,2,0 중 선택해주세요.");break;
				
			}
		}
	}
}
