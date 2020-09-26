package com.cos.blog.config.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.config.action.Action;
import com.cos.blog.dao.UserDao;
import com.cos.blog.model.User;

public class UserLoginProcAction implements Action{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new  User(
					request.getParameter("username"),
					request.getParameter("password"));
			System.out.println(user);
			//1. 로그인 진행 (select) Model로 이동
			UserDao userDao = new UserDao();
			User userEntity = userDao.로그인(user);
			//2. 세션에 저장
			if(userEntity != null) {
				HttpSession session = request.getSession();
				session.setAttribute("principal", userEntity);
				System.out.println(userEntity);
				System.out.println("로그인 정상적으로 진행됨");
				//3. 메인 페이지 이동 Redirect
				response.sendRedirect("/index.jsp");
			}else {
				//로그인 실패!!
				
			} 			
			
	}
}
