package noticeDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Vo.noticeDate;
import util.ConnectionFactory;
import util.ConnectionPool;
import util.SqlExcutor;

public class noticeDAO {
	
	public int deleteBoard(int no) {
		try {
			return SqlExcutor.update(
					"delete from tb_notice where no = ?", no
					);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public void updateBoard(noticeDate board) {
		try {
			SqlExcutor.update(
				"update tb_notice set title = ?, content = ? where no = ?", 
				board.getTitle(), board.getContent(), board.getNo()
			);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public void insertBoard(noticeDate board) {
		try {
			SqlExcutor.update(
				"insert into tb_notice(no, title, id, content, READ) values (seq_board_no.nextval, ?, ?, ?, 0)", 
				board.getTitle(), board.getId(), board.getContent()
			);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public noticeDate selectOneBoard(int no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("select * ");
			sql.append("  from tb_notice ");
			sql.append(" where no = ? ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				noticeDate board = new noticeDate();
				board.setNo(no);
				board.setTitle(rs.getString("title"));
				board.setId(rs.getString("Id"));
				board.setContent(rs.getString("content"));
				board.setRegDate(rs.getDate("reg_date"));
				board.setRead(rs.getInt("read"));
				return board;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
		return null;
	}
	
	public List<noticeDate> selectBoard() {
		Connection con =null;
		PreparedStatement pstmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select * from tb_notice");
			
			pstmt = con.prepareStatement(sql.toString());
			List<noticeDate> list = new ArrayList<>();
			ResultSet rs= pstmt.executeQuery();
			while(rs.next()) {
				noticeDate sd = new noticeDate();
				sd.setNo(rs.getInt("no"));
				sd.setTitle(rs.getString("title"));
				sd.setContent(rs.getString("content"));
				sd.setId(rs.getString("id"));
				sd.setRegDate(rs.getDate("reg_date"));
				sd.setRead(rs.getInt("read"));
				list.add(sd);
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
	
}
