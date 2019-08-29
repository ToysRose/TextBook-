package shopDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Vo.Userdata;
import util.ConnectionFactory;
import util.ConnectionPool;
import util.SqlExcutor;

public class shopRecomDAO {
	// 본인이 이미 추천한 지점인지 확인하는 메서드
	
	private Userdata LoginInfo;
	
	public int recom1(int code,Userdata LoginInfo) {
		this.LoginInfo=LoginInfo;
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
			pstmt.setObject(index++, LoginInfo.getId());
			pstmt.setObject(index++, "s");
			pstmt.setObject(index++, code);
			ResultSet rs = pstmt.executeQuery();
			int cnt = 0;
			if (rs.next()) cnt = rs.getInt("count(*)");
			if (cnt != 0) return 1;
			return recom2(code);
		} catch (Exception e) {
			e.printStackTrace();		
		} finally {
			ConnectionFactory.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
		return recom2(code);
	}

	public int recom2(int code) {
		try {
			SqlExcutor.update("insert into tb_read_recom(id, no, g_code) values (?, ?, 's')",
					LoginInfo.getId(),code);
			return recom3(code);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return recom3(code);
	}
	public int recom3(int code) {
		try {			
			SqlExcutor.update("update tb_shop set recom_cnt = recom_cnt + 1 where code =" + code);
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
