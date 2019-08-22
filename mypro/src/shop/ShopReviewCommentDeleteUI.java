package shop;

import Main.UI;
import shopDao.ShopReviewCommentDAO;

public class ShopReviewCommentDeleteUI {
	
	public void service() {
		ShopReviewCommentDAO dao = new ShopReviewCommentDAO();
		System.out.println("삭제할 글번호를 입력하세요 : ");
		int comenNo = Integer.parseInt(UI.sc.nextLine());
		int result = dao.deleteComment(comenNo);
		if (result == 1) {
			System.out.println();
			System.out.println("게시글이 삭제되었습니다.");
			return;
		}
		System.out.println("해당 게시물이 존재하지 않습니다.");
	}
}
