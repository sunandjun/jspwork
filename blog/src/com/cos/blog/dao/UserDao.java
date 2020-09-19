package com.cos.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cos.blog.config.DBConn;
import com.cos.blog.model.User;
import com.mysql.cj.protocol.Resultset;

public class UserDao {
	public int 회원가입(User user) {
		String sql = "INSERT INTO user(username,password,email,address,createDate) "
					+ "VALUES	 (?,?,?,?,NOW()) ";
		Connection conn = DBConn.getInstance();
		try {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, user.getUsername());
		pstmt.setString(2, user.getPassword());
		pstmt.setString(3, user.getEmail());
		pstmt.setString(4, user.getAddress());
		
		return pstmt.executeUpdate();
		
		}catch (Exception e) {
		// TODO: handle exception
			System.out.println("회원가입 error : " + e.getMessage());
		} 			
		return -1;
	}
	
	public User 로그인(User user) {
		String sql = "SELECT id,username,email,address FROM user WHERE username = ? AND password=?";
		Connection conn = DBConn.getInstance();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());

			ResultSet rs =  pstmt.executeQuery();
			if(rs.next()) {
				User userEntity = new User(
									rs.getInt("id"),
									rs.getString("username"),
									rs.getString("email"),
									rs.getString("address")
									);
				return userEntity;
			}
		
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("로그인 error : " + e.getMessage());
		} 		
		
		return null;
	}
}
