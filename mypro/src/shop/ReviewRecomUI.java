package shop;

import shopDao.shopReviewRecomDAO;

public class ReviewRecomUI {
	public ReviewRecomUI(int no, String id) {
		switch (new shopReviewRecomDAO().recom0(no, id)) {
		case 0:
			System.out.println("추천되었습니다.");
			break;
		case 1:
			System.out.println("이미 추천하셨습니다.");
			break;
		case 2:
			System.out.println("본인 글은 추천할 수 없습니다.");
			break;
		}
	}
}
