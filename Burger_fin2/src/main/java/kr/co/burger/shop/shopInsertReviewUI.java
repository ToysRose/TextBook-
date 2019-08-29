package kr.co.burger.shop;

import org.apache.ibatis.session.SqlSession;

import kr.co.burger.common.db.MyAppSqlConfig;
import kr.co.burger.domain.Userdate;
import kr.co.burger.domain.reviewDate;
import kr.co.burger.shopDao.shopDao;
import kr.co.burger.start.UI;

public class shopInsertReviewUI {
	
	private Userdate LoginInfo;
	
	private shopDao dao;
	
	public shopInsertReviewUI(Userdate LoginInfo) {
		this.LoginInfo=LoginInfo;
		SqlSession session = MyAppSqlConfig.getSqlSessionInstance();
		dao = session.getMapper(shopDao.class);
	}
	
	public void service(int code) {
		reviewDate review = new reviewDate();
		System.out.println("제목을 입력하세요 : ");
		review.setTitle(UI.sc.nextLine());
		System.out.println("내용을 입력하세요 : ");
		review.setContent(UI.sc.nextLine());
		review.setCode(code);
		review.setId(LoginInfo.getId());
		dao.insertReview(review);
	}
	
}
