package kr.co.burger.loginUi;

import org.apache.ibatis.session.SqlSession;

import cmd.cmd;
import kr.co.burger.common.db.MyAppSqlConfig;
import kr.co.burger.domain.Userdate;
import kr.co.burger.start.UI;
import kr.co.burger.userDao.userMapper;

public class userUpdate  {

	private userMapper mapper;
	
	public userUpdate(Userdate LoginInfo) {
		cmd.cmdSkip();
		SqlSession session = MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(userMapper.class);
		
		JoinDao j = new JoinDao();
		Userdate u=LoginInfo;
		
		u.setPassword(j.noBlank("수정할 비밀번호를 입력해주세요"));
		
		u.setAddress(j.noempty("수정할 주소를 입력해주세요"));
		
		u.setPhone_no(j.onlyNumber("수정할 핸드폰번호를 입력해주세요"));
		
		u.setName(j.noBlank("수정할 이름을 입력해주세요"));
		
		mapper.updateUser(u);
		UI.LoginStatus=null;
		System.out.println("다시 로그인해주세요.");
		
	}

}
