package notice;

import InterfaceA.BaseUI;
import Main.UI;
import Vo.noticeDate;
import noticeDao.noticeDAO;

public class noticeEEUp implements BaseUI {
	private noticeDAO dao;
	
	public noticeEEUp(noticeDAO dao) {
		this.dao = dao;
	}
	
	public void service() {
		
		System.out.println("수정할 글번호를 입력하세요 : ");
		noticeDate board = dao.selectOneBoard(Integer.parseInt(UI.sc.nextLine()));
		if (board == null) {
			System.out.println("해당 게시물이 존재하지 않습니다.");
			return;
		}
		System.out.println("제목을 입력하세요 : ");
		board.setTitle(UI.sc.nextLine());
		
		System.out.println("내용을 입력하세요 : ");
		board.setContent(UI.sc.nextLine());
		
		dao.updateBoard(board);
		
		System.out.println();
		System.out.println("게시글이 수정되었습니다.");	
	}
	}	
