package menu;

import java.util.List;

import Main.UI;
import Vo.Userdata;
import Vo.commentDate;
import menuDao.MenuReviewCommentDAO;

public class MenuReviewCommentUI {
	private Userdata LoginInfo;
	
	public MenuReviewCommentUI(Userdata LoginInfo) {
		this.LoginInfo=LoginInfo;
	}
	public void service(int no) {
		MenuReviewCommentDAO dao = new MenuReviewCommentDAO();
		List<commentDate> list = dao.menuReviewComment(no);
		while (true) {
			
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
					c.getRecom_cnt());
		}
		
			System.out.println("-------------------------------");
			System.out.println("1. 댓글 쓰기");
			System.out.println("2. 댓글 수정");
			System.out.println("3. 댓글 삭제");
			System.out.println("0. 이전");
			System.out.print("번호를 입력하세요.");
			switch (Integer.parseInt(UI.sc.nextLine())) {
			case 1:
				new MenuReviewCommentInsertUI(no,LoginInfo);
				break;
			case 2:
				new MenuReviewCommentUpdateUI();
				break;
			case 3:
				new MenuReviewCommentDeleteUI();
				break;
			case 0:
				return;
			default:{
				System.out.println("잘못선택하였습니다.");
				System.out.println("다시 선택하여주세요.");
			}
			}
		}
	}
}
