package notice;

import java.util.List;

import InterfaceA.BaseUI;
import Main.UI;
import Vo.Userdata;
import Vo.noticeDate;
import noticeDao.noticeDAO;

public class noticeUI implements BaseUI	{
private noticeDAO dao;
private Userdata LoginInfo;
public noticeUI(Userdata LoginStatus) {
	this.dao =new noticeDAO();
	this.LoginInfo = LoginStatus;
}

	public void service() {
		
		if(LoginInfo.getId().equals("admin")) {adminId();}
		else {adminIdNo();}
	}
	
	public void selOneNotice() {
		System.out.println("조회할 공지사항 번호를 선택하세요 : ");
		int no = Integer.parseInt(UI.sc.nextLine());
		noticeDate n = dao.selectOneBoard(no);
		
		if(n==null) {System.out.println("입력된 번호의 글이 없습니다."); return;}
		
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		if (n != null) {
			
			System.out.println("글번호 : "+ no);
			System.out.println("제목 : " + n.getTitle());
			System.out.println("글쓴이 : " + n.getId());
			System.out.println("내용 : " + n.getContent());
			System.out.println("작성일자 : " + n.getRegDate());
			System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			
		}
		
		if(LoginInfo.getId().equals("admin")) {onedaminId();}
		else {onedaminIdNo();}
	
	}
	
	public void adminId() {
		
		while(true) {	
			List<noticeDate> list = dao.selectBoard();
			System.out.println("전체 " + list.size() + "개");
			System.out.println("-------------------------------");
			System.out.println("번호  제목 글쓴이 작성일 조회수");
			System.out.println("-------------------------------");
			if (list.isEmpty()) {
				System.out.println("게시물이 없습니다.");
			}
			for (noticeDate r : list) {
				System.out.printf("%d %s %s %s %d \n",
						r.getNo(), r.getTitle(), r.getId(), r.getRegDate(), r.getRead()
						);
			}
			System.out.println("------------------------");
			System.out.println("1.글 선택");
			System.out.println("2.글 등록");
			System.out.println("0.이전");
		switch( Integer.parseInt(UI.sc.nextLine())) {
		case 1: selOneNotice(); break;
		case 2: new noticeWrite(dao,"admin"); break;
		case 0:return;
		default:{
			System.out.println("잘못선택하셧습니다.");
			System.out.println("다시선택해주세요.");
			break;
		}
		}
		}
		
	}
	
	public void adminIdNo() {
		
		   while(true) {	
				List<noticeDate> list = dao.selectBoard();
				System.out.println("전체 " + list.size() + "개");
				System.out.println("-------------------------------");
				System.out.println("번호  제목 글쓴이 작성일 조회수");
				System.out.println("-------------------------------");
				if (list.isEmpty()) {
					System.out.println("게시물이 없습니다.");
				}
				for (noticeDate r : list) {
					System.out.printf("%d %s %s %s %d \n",
							r.getNo(), r.getTitle(), r.getId(), r.getRegDate(), r.getRead()
							);
				}
				System.out.println("------------------------");
				System.out.println("1.글 선택");
				System.out.println("0.이전");
			switch( Integer.parseInt(UI.sc.nextLine())) {
			case 1: selOneNotice(); break;
			case 0:return;
			default:{
				System.out.println("잘못선택하셧습니다.");
				System.out.println("다시선택해주세요.");
				break;
			}
			}
			}
		
	}
	
	public void onedaminId() {
		
		while(true) {	
		System.out.println("1.수정");
		System.out.println("2.삭제");
		System.out.println("0.이전");
		
		switch(Integer.parseInt(UI.sc.nextLine())) {
		case 1 : new noticeEEUp(dao); break;
		case 2 : new noticeEEDel(dao); break;
		case 0 : return;
		default : {
			System.out.println("잘못선택하셧습니다.");
			System.out.println("다시선택해주세요.");
			break;
			}
			}
		}
		
	}
	
	public void onedaminIdNo() {
		
		while(true) {	
			System.out.println("0.이전");
			switch(Integer.parseInt(UI.sc.nextLine())) {
			case 0 : return;
			default : {
				System.out.println("잘못선택하셧습니다.");
				System.out.println("다시선택해주세요.");
				break;
				}
				}
			}
		
	}
}

