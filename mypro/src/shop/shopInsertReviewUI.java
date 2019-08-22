package shop;

import Main.UI;
import Vo.Userdata;
import Vo.reviewDate;
import shopDao.ShopReviewDAO;

public class shopInsertReviewUI {
	
	private Userdata LoginInfo;
	
	public shopInsertReviewUI(Userdata LoginInfo) {
		this.LoginInfo=LoginInfo;
	}
	
	public void service(int code) {
		reviewDate review = new reviewDate();
		ShopReviewDAO dao = new ShopReviewDAO();
		
		System.out.println("제목을 입력하세요 : ");
		review.setTitle(UI.sc.nextLine());
		System.out.println("내용을 입력하세요 : ");
		review.setContent(UI.sc.nextLine());
		review.setCode(code);
		review.setId(LoginInfo.getId());
		dao.insertReview(review);
	}
	
}
