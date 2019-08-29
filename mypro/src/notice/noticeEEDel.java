package notice;

import InterfaceA.BaseUI;
import Main.UI;
import noticeDao.noticeDAO;

public class noticeEEDel  implements BaseUI{
	private noticeDAO dao;
	
	public noticeEEDel(noticeDAO dao) {
		this.dao = dao;
	}

	public void service() {
		System.out.println("삭제할 글번호를 입력하세요 : ");
		int result = dao.deleteBoard(Integer.parseInt(UI.sc.nextLine()));
		if (result == 1) {
			System.out.println();
			System.out.println("게시글이 삭제되었습니다.");
			return;
			
		}
		System.out.println("없다");
	}

	
	
}
