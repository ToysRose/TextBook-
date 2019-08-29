package kr.co.burger.menuUI;

import org.apache.ibatis.session.SqlSession;

import kr.co.burger.common.db.MyAppSqlConfig;
import kr.co.burger.menuDao.MenuReview;
import kr.co.burger.start.UI;

public class MenuReviewCommentDeleteUI {
	private MenuReview mapper;
	
	public MenuReviewCommentDeleteUI() {
		SqlSession session = MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(MenuReview.class); 
		
		System.out.println("삭제할 글번호를 입력하세요 : ");
		int comenNo = Integer.parseInt(UI.sc.nextLine());
		int result = mapper.deleteComment(comenNo);
		if (result == 1) {
			System.out.println();
			System.out.println("게시글이 삭제되었습니다.");
			return;
		}
		System.out.println("해당 게시물이 존재하지 않습니다.");
	}
}
