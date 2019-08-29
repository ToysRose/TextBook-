package kr.co.burger.menuDao;

import java.util.List;
import kr.co.burger.domain.commentDate;
import kr.co.burger.domain.reviewDate;

public interface MenuReview {
	
	public List<commentDate> menuReviewComment(int no);
	public List<reviewDate> menuReview(int code);
	void insertReview(reviewDate r);
	public reviewDate selectOneReview(int no);
	public void reviewUpdate(reviewDate b);
	public int reviewdelete(reviewDate b);
	public void insertComment(commentDate c);
	public void updateComment(commentDate c);
	public int deleteComment(int comenNo);
}
