package userDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Vo.Userdata;
import util.ConnectionFactory;
import util.ConnectionPool;
import util.SqlExcutor;

public class userDao {
 
	public void insertUser(Userdata u) {
		Connection con =null;
		PreparedStatement pstmt = null;
		
		try {
			int cnt = SqlExcutor.update(
					"insert into tb_user(id,password,Address,Phone_no,"
					+ "Name) values(?,?,?,?,?)",
					u.getId(),u.getPassword(),u.getAddress(),u.getPhone_no(),u.getName());
			
			if(cnt!=0)System.out.println("가입되었습니다.");
			if(cnt==0)System.out.println("오류가 발생하였습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("오류가 발생하였습니다.");
		} 
		//DB에 데이터입력
	}
	
	public void deleteUser(String id) {
		Connection con =null;
		PreparedStatement pstmt = null;
		
		try {
			int cnt =SqlExcutor.update(
					"delete from tb_user where id=?  ",
					id);
			
			if(cnt!=0)System.out.println("탈퇴 되었습니다.");
			if(cnt==0)System.out.println("오류가 발생하였습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public void updateUser(String id,Userdata u) {
		Connection con =null;
		PreparedStatement pstmt = null;
		
		try {
			int cnt =SqlExcutor.update(
					"update tb_user "
					+ "set password=?, ADDRESS=?, PHONE_NO=?, NAME=? "
					+ " where id=?  "
					,u.getPassword(),u.getAddress(),u.getPhone_no(),u.getName(),id);
			
			if(cnt!=0)System.out.println("수정 되었습니다.");
			if(cnt==0)System.out.println("오류가 발생하였습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	
	public Userdata logIn(String id,String pass) {
		Connection con =null;
		PreparedStatement pstmt = null;
		
		try {
			con= ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select* from tb_user where id=? and password=?");
			
			pstmt = con.prepareStatement(sql.toString());
			
			int index =1;
			
			pstmt.setString(index++, id);
			pstmt.setString(index++, pass);
			ResultSet rs= pstmt.executeQuery();
			if(rs.next()) {
				Userdata login = new Userdata();
				login.setId(rs.getString("id"));
				login.setPassword(rs.getString("password"));
				login.setAddress(rs.getString("address"));
				login.setPhone_no(rs.getString("phone_no"));
				login.setName(rs.getString("name"));
//				login.setUsertype(rs.getString("usertype"));
				return login;
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
