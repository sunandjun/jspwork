package com.cos.controller;
import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FrontController extends HttpServlet {
	
	//데이터 줘!!(SELECT) ->> 어떤 데이터줘 (쿼리스트링 : ?키=값&키=값)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet()요청");
		System.out.println(req.getRequestURI());
		
		String uri = req.getRequestURI();
		if(uri.equals("/user.do")) {
			System.out.println("/user 접근");
			resp.sendRedirect("user.jsp");
		}else if(uri.equals("/profile.do")) {
			System.out.println("/profile 접근");
			resp.sendRedirect("profile.jsp");
		}else if(uri.equals("/")) {
			System.out.println("/ 접근");
			resp.sendRedirect("index.jsp");
		}else if(uri.equals("logout")) {
			HttpSession session = req.getSession();
			session.invalidate();
			resp.sendRedirect("index.jsp");
		}
		
		
		//super.doGet(req, resp);
	}
	//데이터 줄께(INSERT, DELETE, UPDATE) ->>어떤 데이터 (http body - MIME 타입)
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost()");
		//super.doPost(req, resp);
	}
}
