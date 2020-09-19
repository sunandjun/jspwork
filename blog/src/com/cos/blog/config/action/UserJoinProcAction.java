package com.cos.blog.config.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.dao.UserDao;
import com.cos.blog.model.User;

public class UserJoinProcAction implements Action{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 회원가입 진행 (insert) Model로 이동
			System.out.println("Usercontroller : joinProc : ");
			User user = new User(
					request.getParameter("username"),
					request.getParameter("password"),
					request.getParameter("email"),
					request.getParameter("address")
					);
			UserDao userDao = new UserDao();
			userDao.회원가입(user);
			//2. 로그인 페이지 이동 Redirect
			response.sendRedirect("/user/loginForm.jsp");
	}
}
