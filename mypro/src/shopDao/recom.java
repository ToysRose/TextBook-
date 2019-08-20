package shopDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.ConnectionFactory;
import util.ConnectionPool;
import util.SqlExcutor;

public class recom {

	private int code;
	private int cnt=0;

	//DB 에 글 있나 확인하기
	public recom(int code) {
		this.code=code;
		Connection con =null;
		PreparedStatement pstmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select count(*) from tb_read_recom"
					+ " where id=? and no=? and g_code='s'");
			
			pstmt = con.prepareStatement(sql.toString());
			
			int index =1;
			
			pstmt.setString(index++, "id");
			pstmt.setInt(index++, code);
			ResultSet rs= pstmt.executeQuery();
			
			if(rs.next()) {
				 cnt = rs.getInt("count(*)");		
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
	}

	public void recomIn() {
		if(cnt==0) {
			Connection con =null;
			PreparedStatement pstmt = null;
		try {
			
			int cnt = SqlExcutor.update(
					"insert into tb_rea_recom(id,no,g_code)"
					+ " values('id',?,'s')"
					, code);
					
		} catch (Exception e) {
			e.printStackTrace();
		}
			
			
			
			
		}
		
	}
}
