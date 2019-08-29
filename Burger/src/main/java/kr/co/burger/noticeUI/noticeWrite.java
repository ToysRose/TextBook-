package kr.co.burger.noticeUI;

import cmd.cmd;
import kr.co.burger.InterfaceA.BaseUI;
import kr.co.burger.domain.noticeDate;
import kr.co.burger.start.UI;

public class noticeWrite extends MapperNotice implements BaseUI {
	
	private String id;
	
	public noticeWrite(String id) {
		cmd.cmdSkip();
		this.id = id;
	}

	public void service() {
		
		noticeDate b = new noticeDate();
		System.out.println("제목을 입력하세요 : ");
		b.setTitle(UI.sc.nextLine());
		System.out.println("내용을 입력하세요 : ");
		b.setContent(UI.sc.nextLine());
		b.setId(id);
		
		mapper.insertBoard(b);
		
		System.out.println();
		System.out.println("공지사항이 등록되었습니다.");
	}
}
