package menuDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Vo.reviewDate;
import util.ConnectionFactory;
import util.ConnectionPool;
import util.SqlExcutor;

public class menuReviewDAO {
	
//	메뉴별 리뷰글들을 가져옴
	public List<reviewDate> menuReview(int code) {
	Connection con = null;
	PreparedStatement pstmt = null;
	try {
		con = ConnectionPool.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("select *");
		sql.append("  from tb_rev_stable");
		sql.append(" where g_code = 'm'");
		sql.append("   and code =" + code);
		sql.append(" order by no");
		pstmt = con.prepareStatement(sql.toString());
		pstmt.executeQuery();	
		List<reviewDate> list = new ArrayList<>();
		ResultSet rs = pstmt.executeQuery();                                       
		while (rs.next()) {
			reviewDate review = new reviewDate();
			review.setNo(rs.getInt("no"));
			review.setTitle(rs.getString("title"));
			review.setId(rs.getString("id"));
			review.setRegDate(rs.getDate("reg_date"));
			review.setRead(rs.getInt("read"));
			review.setRecom_cnt(rs.getInt("recom_cnt"));
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
	
//리뷰 글 하나를 가져옴
	public reviewDate selectOneReview(int no,int code) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("select * ");
			sql.append("  from tb_rev_stable");
			sql.append(" where no = ?"
					+ " and g_code = 'm' ");
			sql.append("   and code =" + code);
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				reviewDate review = new reviewDate();
				review.setNo(rs.getInt("no"));
				review.setTitle(rs.getString("title"));
				review.setId(rs.getString("id"));
				review.setContent(rs.getString("content"));
				review.setRegDate(rs.getDate("reg_date"));
				review.setRead(rs.getInt("read"));
				review.setRecom_cnt(rs.getInt("recom_cnt"));
				review.setCode(rs.getInt("code"));
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

//	메뉴 리뷰 글 수정 
	public void reviewUpdate(reviewDate b) {
		
		Connection con =null;
		PreparedStatement pstmt = null;
	try {
		
		 SqlExcutor.update(
				"update tb_rev_stable set title=?, content=?"
				+ " where g_code = 'm' and code = ? and no =?",
				b.getTitle(),b.getContent(),
				b.getCode(),b.getNo());
		
				System.out.println("글이 수정되었습니다.");
	} catch (Exception e) {
		e.printStackTrace();
	}
}
	
//	글 정보 받아서 메뉴 리뷰글 삭제
	public void reviewdelete(reviewDate b) {
		Connection con =null;
		PreparedStatement pstmt = null;
	try {
		 SqlExcutor.update(
				"delete from tb_rev_stable where g_code = 'm'"
				+ " and code = ? and no =?",
				b.getCode(),b.getNo());
		
				System.out.println("글이 수정되었습니다.");
	} catch (Exception e) {
		e.printStackTrace();
	}
	}

	//리뷰 등록
		public void insertReview(reviewDate r) {
			try {
				SqlExcutor.update(
					"insert into tb_rev_stable(code, no, content, id, recom_cnt, read, title, g_code) values (?, TB_REV_STABLE_SEQ.nextval, ?, ?, 0, 0, ?, 'm')", 
					r.getCode(), r.getContent(), r.getId(), r.getRecom_cnt());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
}
