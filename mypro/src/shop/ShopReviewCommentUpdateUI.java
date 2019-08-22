package shop;

import Main.UI;
import Vo.commentDate;
import shopDao.ShopReviewCommentDAO;

public class ShopReviewCommentUpdateUI {
	
	public ShopReviewCommentUpdateUI() {
		ShopReviewCommentDAO dao = new ShopReviewCommentDAO();
		commentDate comment = new commentDate();
		System.out.println("수정할 글번호를 입력하세요 : ");
		comment.setComenNo(Integer.parseInt(UI.sc.nextLine()));	
		// 글번호가 존재할때 사용자에게 수정할 내용을 받는다.
		System.out.println("수정할 내용을 입력하세요 : ");
		comment.setContent(UI.sc.nextLine());		
		dao.updateComment(comment);
		
		System.out.println();
		System.out.println("게시글이 수정되었습니다.");	
	}
}
