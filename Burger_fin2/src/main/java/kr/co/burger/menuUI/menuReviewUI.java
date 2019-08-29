package kr.co.burger.menuUI;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cmd.cmd;
import kr.co.burger.common.db.MyAppSqlConfig;
import kr.co.burger.domain.Userdate;
import kr.co.burger.domain.reviewDate;
import kr.co.burger.menuDao.MenuReview;
import kr.co.burger.start.UI;


public class menuReviewUI {
	private MenuReview mapper;
	private int code;
	private Userdate LoginInfo;
	
	public menuReviewUI(int code, Userdate LoginInfo) {
		cmd.cmdSkip();
		SqlSession session = MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(MenuReview.class); 
		this.code=code;
		this.LoginInfo=LoginInfo;
	}

	public void service() {
		while (true) {
		List<reviewDate> list = mapper.menuReview(code);
		System.out.println("전체 " + list.size() + "개");
		System.out.println("-------------------------------");
		System.out.println("번호  제목 글쓴이 작성일 조회수 추천수");
		System.out.println("-------------------------------");
		if (list.isEmpty()) {
			System.out.println("게시물이 없습니다.");
		}
		for (reviewDate r : list) {
			System.out.printf("%d %s %s %s %d %d\n", r.getNo(), r.getTitle(), r.getId(), r.getRegDate(), r.getRead(),
					r.getRecom_cnt());
		}
			System.out.println("-------------------------------");
			System.out.println("1. 글 선택");
			System.out.println("2. 리뷰 등록");
			System.out.println("0. 이전");
			System.out.print("번호를 입력하세요.");
			switch (Integer.parseInt(UI.sc.nextLine())) {
			case 1:
				new menuSelectOneReviewUI(LoginInfo).service();
				break;
			case 2: new menuInsertReviewUI(LoginInfo).service(code);
				break;
			case 0:
				return;
			default:{
				System.out.println("잘못선택하였습니다.");
				System.out.println("다시 선택하여주세요.");
			}
			}
		}
	}
}
