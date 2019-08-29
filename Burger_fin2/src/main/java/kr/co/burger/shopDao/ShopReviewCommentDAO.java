package kr.co.burger.shopDao;

import java.util.List;

import kr.co.burger.domain.commentDate;

public interface ShopReviewCommentDAO {
	
	public List<commentDate> shopReviewComment(int no);
	public void insertComment(commentDate c);
	public void updateComment(commentDate c);
	public int deleteComment(int comenNo);
}
