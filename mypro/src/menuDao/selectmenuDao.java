package menuDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Vo.BurgerDate;
import util.ConnectionFactory;
import util.ConnectionPool;

public class selectmenuDao {
//버거 코드받아서 정보 뿌려주는메소드
	public BurgerDate burgerOneselect(int no) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select * from tb_menu where code=? ");

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {

				BurgerDate b = new BurgerDate();

				b.setCode(rs.getInt("code"));
				b.setMenu(rs.getString("menu"));
				b.setPrice(rs.getInt("price"));
				b.setKcal(rs.getInt("kcal"));
				b.setRecom(rs.getInt("recom"));
				return b;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
		System.out.println("실패");
		return null;
	}

}
