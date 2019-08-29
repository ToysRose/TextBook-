package kr.co.burger.noticeUI;

import cmd.cmd;
import kr.co.burger.InterfaceA.BaseUI;
import kr.co.burger.start.UI;

public class noticeEEDel extends MapperNotice implements BaseUI{

	public void service() {
		cmd.cmdSkip();
		System.out.println("삭제할 글번호를 입력하세요 : ");
		int result = mapper.deleteBoard(Integer.parseInt(UI.sc.nextLine()));
		if (result == 1) {
			System.out.println();
			System.out.println("게시글이 삭제되었습니다.");
			return;
			
		}
		System.out.println("없다");
	}

	
	
}
