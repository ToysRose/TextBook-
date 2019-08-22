package shop;

import Main.UI;
import Vo.Userdata;
import Vo.commentDate;
import shopDao.ShopReviewCommentDAO;

public class ShopReviewCommentInsertUI{
	
	
	public ShopReviewCommentInsertUI(int no,Userdata LoginInfo) {
		commentDate c = new commentDate();
		System.out.println("내용을 입력하세요 : ");
		c.setContent(UI.sc.nextLine());
		// 로그인 정보에 있는 이름으로 작성자를 설정한다.
		c.setId(LoginInfo.getId());
		c.setNo(no);
		c.setRecom(0);
		ShopReviewCommentDAO dao = new ShopReviewCommentDAO();
		dao.insertComment(c);

		System.out.println();
		System.out.println("게시글이 등록되었습니다.");
	}
}