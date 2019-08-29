package kr.co.burger.shop;

import org.apache.ibatis.session.SqlSession;

import kr.co.burger.common.db.MyAppSqlConfig;
import kr.co.burger.domain.reviewDate;
import kr.co.burger.shopDao.shopReviewRecomDAO;

public class ReviewRecomUI {
	private shopReviewRecomDAO dao;
	
	public ReviewRecomUI(int no, String id) {
		SqlSession session = MyAppSqlConfig.getSqlSessionInstance();
		dao = session.getMapper(shopReviewRecomDAO.class);
		
		reviewDate param = new reviewDate();
		param.setId(id);
		param.setNo(no);
		
		int cnt = dao.recom0(param);
		if (cnt != 0) {
			System.out.println("본인 글은 추천할 수 없습니다.");
			return;
		}
		
		
		cnt = dao.recom1(param);
		
		if (cnt != 0) {
			System.out.println("이미 추천하셨습니다.");
			return;
		}
		
		dao.recom2(param);
		dao.recom3(param);
		
		System.out.println("추천되었습니다.");
	}
}
