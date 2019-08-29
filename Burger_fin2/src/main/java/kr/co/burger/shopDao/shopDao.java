package kr.co.burger.shopDao;

import java.util.List;

import kr.co.burger.domain.Userdate;
import kr.co.burger.domain.reviewDate;
import kr.co.burger.domain.shopDate;

public interface shopDao {

//	DB에서 샵정보를 가져오는 메소드 샵 코드를 받아서
	public shopDate shopSelect(int no);
	public int recom1(Userdate LoginInfo);
	public void insertRecom(Userdate LoginInfo);
	public void updateRecom(int code);
	
	// 리뷰
	public List<reviewDate> selectShopReview(int code);
	public reviewDate selectOneReview(int no);
	public void reviewUpdate(reviewDate b);
	public void reviewdelete(reviewDate b);
	public void insertReview(reviewDate b);
}
