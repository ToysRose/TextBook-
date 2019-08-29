package login;

import Main.UI;
import Vo.Userdata;
import userDao.JoinDao;
import userDao.userDao;

public class userUpdate {

	public userUpdate(Userdata LoginInfo) {
		
		JoinDao j = new JoinDao();
		Userdata u=LoginInfo;
		
		u.setPassword(j.noBlank("수정할 비밀번호를 입력해주세요"));
		
		u.setAddress(j.noempty("수정할 주소를 입력해주세요"));
		
		u.setPhone_no(j.onlyNumber("수정할 핸드폰번호를 입력해주세요"));
		
		u.setName(j.noBlank("수정할 이름을 입력해주세요"));
		
		new userDao().updateUser(u.getId(),u);
		UI.LoginStatus=null;
		System.out.println("다시 로그인해주세요.");
		
	}

}
