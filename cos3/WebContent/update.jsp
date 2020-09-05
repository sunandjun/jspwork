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
<title>데이터 수정</title>
</head>
<body>
<h1>데이터 수정 페이지</h1>
<hr/>

<%

	if(request.getParameter("id") == null || request.getParameter("pw") == null || request.getParameter("name") == null){
		return;
	}
	int id  = Integer.parseInt(request.getParameter("id"));
	String pw  = request.getParameter("pw");
	String name  = request.getParameter("name");
		
	Connection conn =  DBConn.getInstance(); //스트림

	String query = "UPDATE person SET name =?, pw=? WHERE id=?"; 
	PreparedStatement pstmt = conn.prepareStatement(query);  //버퍼

	pstmt.setString(1, name);
	pstmt.setString(2, pw);
	pstmt.setInt(3, id);

		
	int result = pstmt.executeUpdate(); //수정된 행의 갯수가 리턴됨
	
%>
수정된 행의 갯수 : <%=result %>

</body>
</html>