package notice;

import java.util.List;

import InterfaceA.BaseUI;
import Main.UI;
import Vo.noticeDate;
import noticeDao.noticeDAO;

public class notice implements BaseUI{

	public void service() {
				
			List<noticeDate> list = new noticeDAO().noticeSel();
			System.out.println("전체 " + list.size() + "개");
			System.out.println("-------------------------------");
			System.out.println("번호  제목 글쓴이 작성일 조회수 추천수");
			System.out.println("-------------------------------");
			if (list.isEmpty()) {
				System.out.println("게시물이 없습니다.");
			}
			for (noticeDate r : list) {
				System.out.printf("%d %s %s %s %d %d\n",
						r.getNo(), r.getTitle(), r.getId(),
						r.getRegDate(), r.getRead()
						);
			}
			while (true) {
			
			System.out.println("1.글 선택");
			System.out.println("2.글 등록");
			System.out.println("0.이전");

			switch (Integer.parseInt(UI.sc.nextLine())) {
			case 1: new noticeSel(); 
				break;
			case 2: new noticeIn();
				break;
			case 0:
				return;
			default: {
				System.out.println("잘못선택하셧습니다.");
				System.out.println("다시선택해주세요.");
				break;
			}
			}
		}
	}

	
	
	
	
	
	
	
	
	
	
}
