package kr.co.burger.noticeUI;

import cmd.cmd;
import kr.co.burger.InterfaceA.BaseUI;
import kr.co.burger.domain.noticeDate;
import kr.co.burger.start.UI;

public class noticeEEUp extends MapperNotice implements BaseUI {
	
	public void service() {
		cmd.cmdSkip();
		System.out.println("수정할 글번호를 입력하세요 : ");
		noticeDate board = mapper.selectOneBoard(Integer.parseInt(UI.sc.nextLine()));
		if (board == null) {
			System.out.println("해당 게시물이 존재하지 않습니다.");
			return;
		}
		System.out.println("제목을 입력하세요 : ");
		board.setTitle(UI.sc.nextLine());
		
		System.out.println("내용을 입력하세요 : ");
		board.setContent(UI.sc.nextLine());
		
		mapper.updateBoard(board);
		
		System.out.println();
		System.out.println("게시글이 수정되었습니다.");	
	}
	}	
