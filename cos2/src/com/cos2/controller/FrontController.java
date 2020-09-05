package com.cos2.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FrontController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = req.getRequestURI();
		HttpSession session = req.getSession();
		PrintWriter pw = resp.getWriter();
		System.out.println("uri = " + uri);
		
		if(uri.equals("/")) {
			resp.sendRedirect("main.jsp");
		}else if(uri.equals("/login.do")) {
			resp.sendRedirect("login.jsp");
		}else if(uri.equals("/join.do")) {
			resp.sendRedirect("join.jsp");
		}else if(uri.equals("/logout.do")) {//로그아웃
			req.getSession().invalidate();
			resp.sendRedirect("main.jsp");
		}else if(uri.equals("/main.do")) {
			resp.sendRedirect("main.jsp");
		}else if(uri.equals("/info.do")) {
			
			if(session.getAttribute("auth")==null){
				//pw.print("<script>alert('auth no'); </script>");
				//pw.flush();
				myAlert(pw,"auth no","main.do");
				//resp.sendRedirect("main.jsp");
				return;
			}
			boolean isLogin = (boolean)session.getAttribute("auth");
			if(isLogin){
				resp.sendRedirect("info.jsp");
			}
			
		}
	}//doGet()
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = req.getRequestURI();
		HttpSession session = req.getSession();
		PrintWriter pw = resp.getWriter();
		System.out.println("uri = " + uri);
		
		
		if(uri.equals("/loginProc.do")) {
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			System.out.println("loginProc = " + username+password);
			if(username.equals("ssar")&&password.equals("1234")){
				session.setAttribute("auth", true);
			}else {
				myAlert(pw,"Login is not!!",null);
				//pw.print("<script> alert('Login is not!!');</script>");
				//pw.flush();
				return;
			}
			resp.sendRedirect("main.jsp");
		}else if(uri.equals("/joinProc.do")) {
			String username = req.getParameter("username");
			String password= req.getParameter("password");
			String email = req.getParameter("email");
			
			//DB에 값을 넣기
			
			session.setAttribute("auth", true);//세션에 값을 저장 
			resp.sendRedirect("main.jsp");
		}
	}//doPost()
	
	
	//나의 경고창 함수
	private void myAlert(PrintWriter pw,String str, String page) {
		System.out.println("myAlert : pw = "+pw +" str = "+str+" page : " +page);
		pw.println("<script>");
		pw.println("alert('"+str+"');");
		if(page == null) {
			pw.println("history.back();");
		}else {
			pw.println("location.href='"+page+"';");
		}
		pw.println("</script>");		
	}//myAlert()

}
