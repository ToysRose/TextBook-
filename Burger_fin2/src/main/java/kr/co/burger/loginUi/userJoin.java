package kr.co.burger.loginUi;

import org.apache.ibatis.session.SqlSession;

import cmd.cmd;
import kr.co.burger.InterfaceA.BaseUI;
import kr.co.burger.common.db.MyAppSqlConfig;
import kr.co.burger.domain.Userdate;
import kr.co.burger.userDao.userMapper;

public class userJoin  implements BaseUI{
	
	private userMapper mapper;
	public userJoin() {
		// 마이바티스가 실행시 만드는 구현 객체를 얻어오기
		SqlSession session = MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(userMapper.class);
		cmd.cmdSkip();
	}
	public void service() {
		JoinDao jdao = new JoinDao();
		Userdate u = new Userdate();
		
		u.setId(jdao.noBlank("아이디"));
		jdao.s="";
		u.setPassword(jdao.noBlank("비밀번호"));
		jdao.s="";
		u.setAddress(jdao.noempty("주소"));		
		jdao.s="";
		u.setPhone_no(jdao.onlyNumber("핸드폰번호('-'뺴고입력)"));		
		jdao.s="";
		u.setName(jdao.noBlank("이름"));
		mapper.insertUser(u);
		
	}

}
