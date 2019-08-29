package kr.co.burger.menuUI;

import org.apache.ibatis.session.SqlSession;

import kr.co.burger.common.db.MyAppSqlConfig;
import kr.co.burger.domain.Userdate;
import kr.co.burger.domain.commentDate;
import kr.co.burger.menuDao.MenuReview;
import kr.co.burger.start.UI;

public class MenuReviewCommentInsertUI{
	private MenuReview mapper;
	
	public MenuReviewCommentInsertUI(int no,Userdate LoginInfo) {
		SqlSession session = MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(MenuReview.class); 
		commentDate c = new commentDate();
		System.out.println("내용을 입력하세요 : ");
		c.setContent(UI.sc.nextLine());
		// 로그인 정보에 있는 이름으로 작성자를 설정한다.
		c.setId(LoginInfo.getId());
		c.setNo(no);
		c.setRecom_cnt(0);
		mapper.insertComment(c);

		System.out.println();
		System.out.println("게시글이 등록되었습니다.");
	}
}