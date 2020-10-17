package com.cos.blog.config.action.user;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.config.DBConn;
import com.cos.blog.config.action.Action;
import com.cos.blog.dao.UserDao;
import com.cos.blog.model.User;

public class UserUpdateProcAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 1. 회원수정 진행 (update) Model로 이동
		// 2. 메인 페이지 이동 Redirect

//		BufferedReader br = request.getReader();
//		System.out.println(br.toString());
//		
//		StringBuilder sb = new StringBuilder();
//		
//		String input ="";
//		while((input = br.readLine()) != null) {
//			sb.append(input);
//		}
//		System.out.println("sb = "+sb.toString());
		
		//1.세션확인
		HttpSession session = request.getSession();
		if(session.getAttribute("principal") == null) {
			return;
		}
		//2.데이터 null ,"" 확인
//		if(request.getParameter("id") == null || request.getParameter("id").equals("")) {
//			return;
//		}
		//3.데이터 검증

		int id = Integer.parseInt(request.getParameter("id"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email"); 
		String address = request.getParameter("address"); 


		System.out.println("id = " + id);
		System.out.println("username = " + username);
		System.out.println("password = " + password);
		System.out.println("email = " + email);
		System.out.println("address = " + address);
		
		/*
		 * User user = new User( id, username, password, email, address,null );
		 */
		User user = User.builder()
				.id(id)
				.username(username)
				.password(password)
				.email(email)
				.address(address)
				.build();
		
		UserDao dao = UserDao.getInstance();
		int result = dao.회원수정(user);
		
		if(result == 1) {
			session.setAttribute("principal", user);
		}

		response.sendRedirect("index.jsp");
	}

}
