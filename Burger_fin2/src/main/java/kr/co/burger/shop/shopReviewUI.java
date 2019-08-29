package kr.co.burger.shop;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.burger.InterfaceA.BaseUI;
import kr.co.burger.common.db.MyAppSqlConfig;
import kr.co.burger.domain.Userdate;
import kr.co.burger.domain.reviewDate;
import kr.co.burger.shopDao.shopDao;
import kr.co.burger.start.UI;

public class shopReviewUI implements BaseUI {
//	private ShopReviewDAO dao;
	private int code;
	private Userdate LoginInfo;
	
	private shopDao dao;
	
	public shopReviewUI(int code, Userdate LoginInfo) {
		this.code=code;
		this.LoginInfo=LoginInfo;
		SqlSession session = MyAppSqlConfig.getSqlSessionInstance();
		dao = session.getMapper(shopDao.class);
	}
//지점,메뉴 코드를 받아서 뿌려줌
	public void service() {
		List<reviewDate> list = dao.selectShopReview(code);
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
		while (true) {
			System.out.println("-------------------------------");
			System.out.println("1. 글 선택");
			System.out.println("2. 리뷰 등록");
			System.out.println("0. 이전");
			System.out.print("번호를 입력하세요.");
			switch (Integer.parseInt(UI.sc.nextLine())) {
			case 1: new shopSelectOneReviewUI(LoginInfo).service();
				break;
			case 2: new shopInsertReviewUI(LoginInfo).service(code);
				break;
			case 0:
				return;
			}
		}
	}
}
