package kr.co.burger.noticeDAO;

import java.util.List;

import kr.co.burger.domain.noticeDate;

public interface noticeMapper {
	
	 int deleteBoard(int no);
	
	 void updateBoard(noticeDate board);
	
	public void insertBoard(noticeDate board);
	
	 noticeDate selectOneBoard(int no);
	
	public List<noticeDate> selectBoard();
	
}
