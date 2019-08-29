package kr.co.burger.loginUi;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import cmd.cmd;
import kr.co.burger.InterfaceA.BaseUI;
import kr.co.burger.common.db.MyAppSqlConfig;
import kr.co.burger.domain.Userdate;
import kr.co.burger.start.UI;
import kr.co.burger.userDao.userMapper;


public class logIn  implements BaseUI {

	Scanner scan =UI.sc;

	private userMapper mapper;
	
	public logIn() {
		// 마이바티스가 실행시 만드는 구현 객체를 얻어오기
		SqlSession session = MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(userMapper.class);
		cmd.cmdSkip();
	}
	
	public void service() {
		Userdate u =new Userdate();
		System.out.println("아이디");
		u.setId(scan.nextLine());
		System.out.println("비밀번호");
		u.setPassword(scan.nextLine());

		Userdate login =mapper.logIn(u);
		if (login == null) {
			System.out.println("아이디 또는 패스워드가 올바르지 않습니다.");
			return;
		}
		UI.LoginStatus = login;
		System.out.println("로그인 되었습니다.");
		}
	}
