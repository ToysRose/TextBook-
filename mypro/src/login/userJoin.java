package login;

import InterfaceA.BaseUI;
import Vo.Userdata;
import userDao.JoinDao;
import userDao.userDao;

public class userJoin  implements BaseUI{
private userDao dao;

	public userJoin() {
		dao=new userDao();
	}
	
	public void service() {
		JoinDao jdao = new JoinDao();
		Userdata u = new Userdata();
		
		u.setId(jdao.noBlank("아이디"));
		jdao.s="";
		u.setPassword(jdao.noBlank("비밀번호"));
		jdao.s="";
		u.setAddress(jdao.noempty("주소"));		
		jdao.s="";
		u.setPhone_no(jdao.onlyNumber("핸드폰번호('-'뺴고입력)"));		
		jdao.s="";
		u.setName(jdao.noBlank("이름"));
		dao.insertUser(u);
		
	}

}
