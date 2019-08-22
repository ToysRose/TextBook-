package shopDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Vo.commentDate;
import util.ConnectionFactory;
import util.ConnectionPool;
import util.SqlExcutor;

public class ShopReviewCommentDAO {
	public List<commentDate> shopReviewComment(int no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select *");
			sql.append("  from tb_comen_stable");
			sql.append(" where g_code = 'sr'");
			sql.append("   and no =" + no);
			sql.append(" order by co_no");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.executeQuery();	
			List<commentDate> list = new ArrayList<>();
			ResultSet rs = pstmt.executeQuery();                                       
			while (rs.next()) {
				commentDate comment = new commentDate();
				comment.setComenNo(rs.getInt("co_no"));
				comment.setContent(rs.getString("content"));
				comment.setId(rs.getString("id"));
				comment.setRegDate(rs.getDate("reg_date"));
				comment.setRecom(rs.getInt("recom_cnt"));
				list.add(comment);
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
	
	public void insertComment(commentDate c) {
		try {
			SqlExcutor.update(
				"insert into tb_comen_stable(no, content, id, recom, co_no, g_code) values (?, ?, ?, ?, ?, tb_comen_stable_seq.nextval, 'sr')", 
				c.getNo(), c.getContent(), c.getId(), c.getRecom());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateComment(commentDate c) {
			try {
				SqlExcutor.update(
					"update tb_comen_stable set content = ? where co_no = ?", 
					c.getContent(), c.getComenNo()
				);
			} catch (Exception e) {System.out.println("없는 번호입니다.");
				e.printStackTrace();
			}		
		}

	public int deleteComment(int comenNo) { 
		try {
			return SqlExcutor.update(
				"delete from tb_comen_stable where co_no = ?", comenNo
			);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
}
