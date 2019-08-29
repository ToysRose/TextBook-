package kr.co.burger.menuUI;

import org.apache.ibatis.session.SqlSession;

import kr.co.burger.InterfaceA.BaseUI;
import kr.co.burger.common.db.MyAppSqlConfig;
import kr.co.burger.domain.Userdate;
import kr.co.burger.domain.reviewDate;
import kr.co.burger.menuDao.MenuReview;
//import kr.co.burger.menuDao.mReviewRecomMapper;
import kr.co.burger.start.UI;

public class menuSelectOneReviewUI implements BaseUI {
	private MenuReview mapper;
//	private mReviewRecomMapper mapper1;
	private Userdate LoginInfo;
	
	public menuSelectOneReviewUI(Userdate LoginInfo) {
		SqlSession session = MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(MenuReview.class); 
//		mapper1 = session.getMapper(mReviewRecomMapper.class); 
		
		this.LoginInfo=LoginInfo;
	}
	
	public void service() {
		
		System.out.println("조회할 글번호를 입력하세요 : ");
		int no = Integer.parseInt(UI.sc.nextLine());
		reviewDate b = mapper.selectOneReview(no);
		
		if(b==null) {System.out.println("입력된 번호의 글이 없습니다."); return;}
		System.out.println(LoginInfo.getId());
		System.out.println(b.getId());
		if(LoginInfo.getId().equals(b.getId())) con(b);
		else con2(b);
		}
	
	public void con(reviewDate b) {
		
		while(true) {
			System.out.println("-------------------------------");
				System.out.println("번호 : " + b.getNo());
				System.out.println("제목 : " + b.getTitle());
				System.out.println("글쓴이 : " + b.getId());
				System.out.println("내용 : " + b.getContent());
				System.out.println("작성일시 : " + b.getRegDate());
				System.out.println("추천수 : " + b.getRecom_cnt());
				System.out.println("조회수 : " + b.getRead());
				System.out.println("-------------------------------");		
			System.out.println("1.수정");
			System.out.println("2.삭제");
//			System.out.println("3.추천");
			System.out.println("3.댓글");
			System.out.println("0.이전");
			
			switch(Integer.parseInt(UI.sc.nextLine())) {
			case 1 : update(b); break;
			case 2 : delete(b); break;
//			case 3 : if(mapper1.recom1(LoginInfo) == 0) System.out.println("추천되었습니다.");
//			else System.out.println("이미 추천하셨습니다."); break;
			case 3 : new MenuReviewCommentUI(LoginInfo).service(b.getNo()); break;
			case 0 : return;
			default : {System.out.println("잘못선택하셧습니다.");
						System.out.println("다시선택해주세요.");
				break;}
			}
		}
	}
	public void con2(reviewDate b) {
		
		while(true) {
			
			System.out.println("-------------------------------");
				System.out.println("번호 : " + b.getNo());
				System.out.println("제목 : " + b.getTitle());
				System.out.println("글쓴이 : " + b.getId());
				System.out.println("내용 : " + b.getContent());
				System.out.println("작성일시 : " + b.getRegDate());
				System.out.println("추천수 : " + b.getRecom_cnt());
				System.out.println("조회수 : " + b.getRead());
				System.out.println("-------------------------------");		
//			System.out.println("1.추천");
			System.out.println("1.댓글");
			System.out.println("0.이전");
			
			switch(Integer.parseInt(UI.sc.nextLine())) {
//			case 1 : new ReviewRecomUI(b.getNo(),b.getId()); break;
			case 1 : new MenuReviewCommentUI(LoginInfo).service(b.getNo()); break;
			case 0 : return;
			default : {System.out.println("잘못선택하셧습니다.");
						System.out.println("다시선택해주세요.");
				break;}
			}
		}
	}
	public void update(reviewDate b) {
		System.out.println("수정할 제목을 입력하세요");
		b.setTitle(UI.sc.nextLine());
		System.out.println("수정할 내용을 입력하세요");
		b.setContent(UI.sc.nextLine());
	    mapper.reviewUpdate(b);
	}
	public void delete(reviewDate b) {
		if(mapper.reviewdelete(b)==1)System.out.println("삭제되었습니다.");
		else System.out.println("글이 없습니다.");
	}
}
