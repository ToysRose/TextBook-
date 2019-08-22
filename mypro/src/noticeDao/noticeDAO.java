package noticeDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Vo.noticeDate;
import Vo.reviewDate;
import util.ConnectionFactory;
import util.ConnectionPool;

public class noticeDAO {
	
//	public ShopReviewDAO() {}
	
//	공지사항 게시물 전체 가져옴
	public List<noticeDate> noticeSel() {
	Connection con = null;
	PreparedStatement pstmt = null;
	try {
		con = ConnectionPool.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("select *");
		sql.append("  from tb_notice");
		sql.append(" order by no desc");
		pstmt = con.prepareStatement(sql.toString());
		pstmt.executeQuery();	
		List<noticeDate> list = new ArrayList<>();
		ResultSet rs = pstmt.executeQuery();                                       
		while (rs.next()) {
			noticeDate review = new noticeDate();
			review.setNo(rs.getInt("no"));
			review.setTitle(rs.getString("title"));
			review.setId(rs.getString("id"));
			review.setContent(rs.getString("content"));
			review.setRegDate(rs.getDate("reg_date"));
			review.setRead(rs.getInt("read"));
			list.add(review);
		}
		return list;
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		ConnectionFactory.close(pstmt);
		ConnectionPool.releaseConnection(con);
	}
	return null;
	}
	
//글 하나를 가져옴
	public reviewDate selectOneReview(int no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("select * ");
			sql.append("  from tb_rev_stable");
			sql.append(" where no = ?"
					+ " and g_code = 's' ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				reviewDate review = new reviewDate();
				review.setNo(rs.getInt("no"));
				review.setTitle(rs.getString("title"));
				review.setId(rs.getString("id"));
				review.setRegDate(rs.getDate("reg_date"));
				review.setRead(rs.getInt("read"));
				review.setRecom(rs.getInt("recom"));
				return review;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
		return null;
	}
	
}
