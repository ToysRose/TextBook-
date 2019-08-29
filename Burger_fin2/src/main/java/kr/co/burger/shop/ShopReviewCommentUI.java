package kr.co.burger.shop;

import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import kr.co.burger.common.db.MyAppSqlConfig;
import kr.co.burger.domain.Userdate;
import kr.co.burger.domain.commentDate;
import kr.co.burger.shopDao.ShopReviewCommentDAO;
import kr.co.burger.shopDao.shopDao;
import kr.co.burger.start.UI;

public class ShopReviewCommentUI {
	private Userdate LoginInfo;
	Scanner sc = new Scanner(System.in);
	ShopReviewCommentDAO dao;
	public ShopReviewCommentUI(Userdate LoginInfo) {
		this.LoginInfo=LoginInfo;
		SqlSession session = MyAppSqlConfig.getSqlSessionInstance();
		dao = session.getMapper(ShopReviewCommentDAO.class);
	}
	
	public void service(int no) {
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
					c.getRecom_cnt());
		}
		
		while (true) {
			System.out.println("-------------------------------");
			System.out.println("1. 댓글 쓰기");
			System.out.println("2. 댓글 수정");
			System.out.println("3. 댓글 삭제");
			System.out.println("4. 댓글 추천");
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
			case 4:
				System.out.print("추천할 댓글 번호를 입력하세요.");
				int co_no = Integer.parseInt(sc.nextLine());
				new ShopReviewCommentRecomUI(LoginInfo.getId(), co_no); 
				break;
			case 0:
				return;
			}
		}
	}
}
