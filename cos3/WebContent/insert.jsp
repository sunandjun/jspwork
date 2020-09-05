<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.mysql.cj.xdevapi.PreparableStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.cos3.config.DBConn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터 입력</title>
</head>
<body>
<h1>데이터 입력 페이지</h1>
<hr/>

<%

	if(request.getParameter("pw") == null || request.getParameter("name") == null){
		return;
	}
	String password  = request.getParameter("pw");
	String name = request.getParameter("name");
	
	Connection conn =  DBConn.getInstance(); //스트림

	String query = "INSERT INTO person(pw, name) VALUES(?,?)"; 
	PreparedStatement pstmt = conn.prepareStatement(query);  //버퍼
	pstmt.setString(1, password);
	pstmt.setString(2, name);
	
	int result = pstmt.executeUpdate(); //수정된 행의 갯수가 리턴됨
	
%>
수정된 행의 갯수 : <%=result %>

</body>
</html>