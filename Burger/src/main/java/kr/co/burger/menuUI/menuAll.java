package kr.co.burger.menuUI;

import org.apache.ibatis.session.SqlSession;

import cmd.cmd;
import kr.co.burger.common.db.MyAppSqlConfig;
import kr.co.burger.domain.BurgerDate;
import kr.co.burger.domain.Userdate;
import kr.co.burger.menuDao.SelectMenuMapper;
//import kr.co.burger.menuDao.menuRecomMapper;
import kr.co.burger.start.UI;

public class menuAll {
//하나의 번호받아서 그 버거 정보 뿌려주는 메소드
	private Userdate LoginInfo;
	private SelectMenuMapper mapper;
//	private menuRecomMapper mapper1;

	public menuAll(Userdate LoginStatus) {
		cmd.cmdSkip();
		SqlSession session = MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(SelectMenuMapper.class); 
//		mapper1 = session.getMapper(menuRecomMapper.class); 
		this.LoginInfo = LoginStatus;
	}

	public void burger(int code) {
		if(LoginInfo!=null) inBurger(code);
		else outBurger(code);
		LoginInfo.setCode(code);
	}

	public void inBurger(int code) {

		while (true) {
		BurgerDate b = mapper.burgerOneselect(code);
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.println("이름" + b.getMenu());
		System.out.println("가격" + b.getPrice());
		System.out.println("칼로리" + b.getKcal());
		System.out.println("추천수" + b.getRecom());
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

//			System.out.println("1. 추천하기");
			System.out.println("1. 결제하기");
			System.out.println("2. 리뷰");
			System.out.println("0. 이전");
			System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			System.out.print("선택하세요 : ");
		
			switch (Integer.parseInt(UI.sc.nextLine())) {
//			case 1: if(mapper1.recom1(LoginInfo) == 0) System.out.println("추천되었습니다.");
//			else System.out.println("이미 추천하셨습니다."); break;
			case 1:  new PayBoardUI();	break;
			case 2: new menuReviewUI(code,LoginInfo).service(); break;
			case 0: return;
			default:{
				System.out.println("잘못선택하였습니다.");
				System.out.println("다시 선택하여주세요.");
			}
			}
			
		}
		
	}
	
	public void outBurger(int code) {
		
		BurgerDate b = mapper.burgerOneselect(code);
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.println("이름" + b.getMenu());
		System.out.println("가격" + b.getPrice());
		System.out.println("칼로리" + b.getKcal());
		System.out.println("추천수" + b.getRecom());
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

		while (true) {

			System.out.println("1. 결제하기");
			System.out.println("0. 이전");
			System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			System.out.print("선택하세요 : ");
			
			switch (Integer.parseInt(UI.sc.nextLine())) {
			case 1: new PayBoardUI();	break;
			case 0: return;
			default:{
				System.out.println("잘못선택하였습니다.");
				System.out.println("다시 선택하여주세요.");
			}
			}
		}
		
	}
	
}
