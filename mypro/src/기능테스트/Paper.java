package 기능테스트;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Vo.Userdata;
import util.ConnectionFactory;
import util.ConnectionPool;

public class Paper {
	
public static void main(String[] args) {

	Connection con =null;
	PreparedStatement pstmt = null;
	try {
	
		con = ConnectionPool.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append(" select * ");
		sql.append("   from tb_user ");
		pstmt = con.prepareStatement(sql.toString());

		ResultSet rs= pstmt.executeQuery();
		
		if(rs.next()) 
			System.out.println(rs.getString("id"));
		
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		ConnectionFactory.close(pstmt);
		ConnectionPool.releaseConnection(con);
	}
}
}
