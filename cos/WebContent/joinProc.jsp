<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/* 전송 하는 곳에서 설정한 이름을 가지고 파라미터를 파싱한다. */
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	String email = request.getParameter("email");
	
	System.out.println("컨텍스트 패스: "+request.getContextPath());
	System.out.println("컨텐트 타입: "+request.getHeader("Content-Type"));
	System.out.println("캐릭터 인코딩: "+request.getCharacterEncoding());
	System.out.println("로컬포트: "+request.getLocalPort());
	System.out.println("메서드: "+request.getMethod());
	System.out.println("리모트 addr: "+request.getRemoteAddr());
	System.out.println("프로토콜: "+request.getProtocol());
	System.out.println("쿼리스트링: "+request.getQueryString());
	System.out.println("로컬 addr: "+request.getLocalAddr());
	
	//잘 받아 졌으면 DB에 insert하면 회원가입 되는것
	
	session.setAttribute("auth", true);//세션에 값을 저장 
	
	response.sendRedirect("main.jsp");
%>
