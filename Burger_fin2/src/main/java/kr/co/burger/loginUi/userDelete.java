package kr.co.burger.loginUi;

import org.apache.ibatis.session.SqlSession;

import cmd.cmd;
import kr.co.burger.common.db.MyAppSqlConfig;
import kr.co.burger.start.UI;
import kr.co.burger.userDao.userMapper;

public class userDelete  {
	private userMapper mapper;
	
	public userDelete(String id) {
		cmd.cmdSkip();
		SqlSession session = MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(userMapper.class);
		mapper.deleteUser(id);
		UI.LoginStatus=null;
	}
	
	
	


}
