package kr.co.burger.loginUi;

import kr.co.burger.domain.User;
import kr.co.burger.userDao.BaseUI;
import kr.co.burger.userDao.JoinDao;
import kr.co.burger.userDao.userDao;

public class userJoin  implements BaseUI{
private userDao dao;

	public userJoin() {
		dao=new userDao();
	}
	
	public void service() {
		JoinDao jdao = new JoinDao();
		User u = new User();
		
		u.setId(jdao.noBlank("아이디"));
		jdao.s="";
		u.setPassword(jdao.noBlank("비밀번호"));
		jdao.s="";
		u.setAddress(jdao.noBlank("주소"));		
		jdao.s="";
		u.setPhone_no(jdao.onlyNumber("핸드폰번호('-'뺴고입력)"));		
		jdao.s="";
		u.setName(jdao.noBlank("이름"));
		dao.insertUser(u);
		
	}

}
