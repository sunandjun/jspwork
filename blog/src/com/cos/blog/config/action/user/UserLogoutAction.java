package com.cos.blog.config.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.config.action.Action;

public class UserLogoutAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1. 세션 무효화
		HttpSession session = request.getSession();
		session.invalidate();
		//2. 메인 페이지 이동 Redirect
		response.sendRedirect("/index.jsp");
	}

}
