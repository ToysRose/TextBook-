package shopDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Vo.shopDate;
import util.ConnectionFactory;
import util.ConnectionPool;

public class shopDao {

//	DB에서 샵정보를 가져오는 메소드 샵 코드를 받아서
	public shopDate shopSelect(int no) {
		Connection con =null;
		PreparedStatement pstmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select * from tb_shop where code=?");
			
			pstmt = con.prepareStatement(sql.toString());
			
			int index =1;
			
			pstmt.setInt(index++, no);
			ResultSet rs= pstmt.executeQuery();
			if(rs.next()) {
				shopDate sd = new shopDate();
				sd.setCode(rs.getInt("code"));
				sd.setName(rs.getString("name"));
				sd.setPhone_no(rs.getString("phone_no"));
				sd.setRecom_cnt(rs.getInt("recom_cnt"));
				sd.setShop_address(rs.getString("shop_address"));
				return sd;
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
