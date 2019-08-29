package kr.co.burger.menuUI;

import org.apache.ibatis.session.SqlSession;

import cmd.cmd;
import kr.co.burger.common.db.MyAppSqlConfig;
import kr.co.burger.domain.Userdate;
import kr.co.burger.domain.reviewDate;
import kr.co.burger.menuDao.MenuReview;
import kr.co.burger.start.UI;

public class menuInsertReviewUI {
	private MenuReview mapper;
	private Userdate LoginInfo;
	
	public menuInsertReviewUI(Userdate LoginInfo) {
		cmd.cmdSkip();
		SqlSession session = MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(MenuReview.class); 
		this.LoginInfo=LoginInfo;
		
	}
	
	public void service(int code) {
		reviewDate review = new reviewDate();
		
		System.out.println("제목을 입력하세요 : ");
		review.setTitle(UI.sc.nextLine());
		System.out.println("내용을 입력하세요 : ");
		review.setContent(UI.sc.nextLine());
		review.setCode(code);
		review.setId(LoginInfo.getId());
		mapper.insertReview(review);
		System.out.println("게시물이 등록되었습니다.");
	}
	
}
