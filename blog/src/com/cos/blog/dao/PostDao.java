package com.cos.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.blog.config.DBConn;
import com.cos.blog.model.Post;

public class PostDao {
	public int 글쓰기(Post post) {
		String sql = "INSERT INTO post(title,content,readCount,createDate,userId) "
				+ "VALUES	 (?,?,?,NOW(),?) ";
		Connection conn = DBConn.getInstance();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, post.getTitle());
			pstmt.setString(2, post.getContent());
			pstmt.setInt(3,post.getReadCount());
			pstmt.setInt(4, post.getUserId());
			
			return pstmt.executeUpdate();
		
		}catch (Exception e) {
		// TODO: handle exception
			System.out.println("글쓰기 error : " + e.getMessage());
		} 			
		return -1;
	}
	

	public int 글쓰기2(Post post) {
		String sql = "INSERT INTO post2(title,content,readCount,createDate,userId) "
				+ "VALUES	 (?,?,?,NOW(),?) ";
		Connection conn = DBConn.getInstance();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, post.getTitle());
			pstmt.setString(2, post.getContent());
			pstmt.setInt(3,post.getReadCount());
			pstmt.setInt(4, post.getUserId());
			
			return pstmt.executeUpdate();
		
		}catch (Exception e) {
		// TODO: handle exception
			System.out.println("글쓰기 error : " + e.getMessage());
		} 			
		return -1;
	}
	
	public List<Post> 글목록() {
		String sql = "SELECT * FROM post ORDER BY id DESC";  //DESC 내림차순 정리 ASC 오름차순
		List<Post> posts = new ArrayList<>();
		Connection conn = DBConn.getInstance();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
					
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Post post = new Post(
										rs.getInt("id"),
										rs.getString("title"),
										rs.getString("content"),
										rs.getInt("readCount"),
										rs.getTimestamp("createDate"),
										rs.getInt("userId")
										);
				posts.add(post);
			}
			
			return posts;
		
		}catch (Exception e) {
		// TODO: handle exception
			System.out.println("글목록 error : " + e.getMessage());
		} 			
		
		
		return null;
	}
}
