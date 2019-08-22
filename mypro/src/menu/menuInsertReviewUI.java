package menu;

import Main.UI;
import Vo.Userdata;
import Vo.reviewDate;
import menuDao.menuReviewDAO;

public class menuInsertReviewUI {
	
	private Userdata LoginInfo;
	
	public menuInsertReviewUI(Userdata LoginInfo) {
		this.LoginInfo=LoginInfo;
	}
	
	public void service(int code) {
		reviewDate review = new reviewDate();
		menuReviewDAO dao = new menuReviewDAO();
		
		System.out.println("제목을 입력하세요 : ");
		review.setTitle(UI.sc.nextLine());
		System.out.println("내용을 입력하세요 : ");
		review.setContent(UI.sc.nextLine());
		review.setCode(code);
		review.setId(LoginInfo.getId());
		dao.insertReview(review);
	}
	
}
