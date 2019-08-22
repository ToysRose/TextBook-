package shopDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.ConnectionFactory;
import util.ConnectionPool;
import util.SqlExcutor;

public class ReviewRecomDAO {
	public int recom0(int no, String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select count(*)");
			sql.append("  from tb_rev_stable");
			sql.append(" where id = ?");
			sql.append("   and g_code = ?");
			sql.append("   and no = ?");
			pstmt = con.prepareStatement(sql.toString());
			int index = 1;
			pstmt.setObject(index++, id);
			pstmt.setObject(index++, "s");
			pstmt.setObject(index++, no);
			ResultSet rs = pstmt.executeQuery();
			int cnt = 0;
			if (rs.next()) cnt = rs.getInt("count(*)");
			if (cnt != 0) return 2;
			return recom1(no, id);
		} catch (Exception e) {
			e.printStackTrace();		
		} finally {
			ConnectionFactory.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
		return recom1(no, id);
	}
	public int recom1(int no, String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select count(*)");
			sql.append("  from tb_read_recom");
			sql.append(" where id = ?");
			sql.append("   and g_code = ?");
			sql.append("   and no = ?");
			pstmt = con.prepareStatement(sql.toString());
			int index = 1;
			pstmt.setObject(index++, id);
			pstmt.setObject(index++, "sr");
			pstmt.setObject(index++, no);
			ResultSet rs = pstmt.executeQuery();
			int cnt = 0;
			if (rs.next()) cnt = rs.getInt("count(*)");
			if (cnt != 0) return 1;
			return recom2(no, id);
		} catch (Exception e) {
			e.printStackTrace();		
		} finally {
			ConnectionFactory.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
		return recom2(no, id);
	}

	public int recom2(int no, String id) {
		try {
			SqlExcutor.update("insert into tb_read_recom(id, no, g_code) values (?, ?, 'sr')", id,
					no);
			return recom3(no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return recom3(no);
	}
	public int recom3(int no) {
		try {			
			SqlExcutor.update("update tb_rev_stable set recom_cnt = recom_cnt + 1 where no =" + no);
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
