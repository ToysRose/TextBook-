package shop;

import java.util.List;

import Main.UI;
import Vo.Userdata;
import Vo.commentDate;
import shopDao.ShopReviewCommentDAO;

public class ShopReviewCommentUI {
	private Userdata LoginInfo;
	
	public ShopReviewCommentUI(Userdata LoginInfo) {
		this.LoginInfo=LoginInfo;
	}
	public void service(int no) {
		ShopReviewCommentDAO dao = new ShopReviewCommentDAO();
		List<commentDate> list = dao.shopReviewComment(no);
		System.out.println("전체 " + list.size() + "개");
		System.out.println("-------------------------------");
		System.out.println("번호  내용 글쓴이 작성일  추천수");
		System.out.println("-------------------------------");
		if (list.isEmpty()) {
			System.out.println("게시물이 없습니다.");
		}
		for (commentDate c : list) {
			System.out.printf("%d %s %s %s %d \n",
					c.getComenNo(), c.getContent(), c.getId(), c.getRegDate(),
					c.getRecom());
		}
		
		while (true) {
			System.out.println("-------------------------------");
			System.out.println("1. 댓글 쓰기");
			System.out.println("2. 댓글 수정");
			System.out.println("3. 댓글 삭제");
			System.out.println("0. 이전");
			System.out.print("번호를 입력하세요.");
			switch (Integer.parseInt(UI.sc.nextLine())) {
			case 1:
				new ShopReviewCommentInsertUI(no,LoginInfo);
				break;
			case 2:
				new ShopReviewCommentUpdateUI();
				break;
			case 3:
				new ShopReviewCommentDeleteUI().service();
				break;
			case 0:
				return;
			}
		}
	}
}
