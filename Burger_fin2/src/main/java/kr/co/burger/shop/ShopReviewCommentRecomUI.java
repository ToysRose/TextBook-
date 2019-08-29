package kr.co.burger.shop;


import org.apache.ibatis.session.SqlSession;

import kr.co.burger.common.db.MyAppSqlConfig;
import kr.co.burger.domain.commentDate;
import kr.co.burger.shopDao.ShopReviewCommentRecomDAO;

public class ShopReviewCommentRecomUI {
	
	ShopReviewCommentRecomDAO dao;
	
	public ShopReviewCommentRecomUI(String id, int co_no) {
		
		SqlSession session = MyAppSqlConfig.getSqlSessionInstance();
		dao = session.getMapper(ShopReviewCommentRecomDAO.class);
		
		
		commentDate param = new commentDate();
		param.setComenNo(co_no);
		param.setId(id);
		
		int cnt = dao.recom0(param);
		if (cnt != 0) {
			System.out.println("본인 댓글은 추천할 수 없습니다.");
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
