package notice;

import InterfaceA.BaseUI;
import Main.UI;
import Vo.Userdata;
import Vo.noticeDate;
import noticeDao.noticeDAO;

public class noticeWrite implements BaseUI {
	
	private noticeDAO dao;
	private String id;
	
	public noticeWrite(noticeDAO dao,String id) {
		this.dao = dao;
		this.id = id;
	}

	public void service() {
		
		noticeDate b = new noticeDate();
		System.out.println("제목을 입력하세요 : ");
		b.setTitle(UI.sc.nextLine());
		System.out.println("내용을 입력하세요 : ");
		b.setContent(UI.sc.nextLine());
		b.setId(id);
		
		dao.insertBoard(b);
		
		System.out.println();
		System.out.println("공지사항이 등록되었습니다.");
	}
}
