package shop;

import java.util.List;

import InterfaceA.BaseUI;
import Main.UI;
import Vo.Userdata;
import Vo.reviewDate;
import shopDao.ShopReviewDAO;

public class shopReviewUI implements BaseUI {
	private ShopReviewDAO dao;
	private int code;
	private Userdata LoginInfo;
	
	public shopReviewUI(int code, Userdata LoginInfo) {
		this.dao = new ShopReviewDAO();
		this.code=code;
		this.LoginInfo=LoginInfo;
	}
//지점,메뉴 코드를 받아서 뿌려줌
	public void service() {
		while (true) {
		List<reviewDate> list = dao.shopReview(code);
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
			case 1: new shopSelectOneReviewUI(LoginInfo).service(code);
				break;
			case 2: new shopInsertReviewUI(LoginInfo).service(code);
				break;
			case 0:
				return;
				default:{
					System.out.println("잘못 선택하셧 습니다.");
					System.out.println("다시선택하세요.");
				}
			}
		}
	}
}
