<%@page import="com.cos3.model.Person"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.mysql.cj.protocol.Resultset"%>
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
<title>데이터 전체 조회</title>
</head>
<body>
<h1>데이터 전체 조회 페이지</h1>
<hr/>

<%

	Connection conn =  DBConn.getInstance(); //스트림

	String query = "SELECT id,pw,name FROM person"; 
	PreparedStatement pstmt = conn.prepareStatement(query);  //버퍼
	ResultSet rs = pstmt.executeQuery(); //쿼리의 결과를 리턴
	
	 
	ArrayList<Person> persons = new ArrayList<>();
	while(rs.next()){
		Person person = new Person(
				rs.getInt("id"),
				rs.getString("pw"),
				rs.getString("name"));
		
		persons.add(person);
	}
	
	for(Person person : persons){
		System.out.println("아이디 : " + person.getId());
		System.out.println("비번 : " + person.getPw());
		System.out.println("이름 : " + person.getName());
		System.out.println("====================");
	}
		
%>
받은 결과 값
<table border="1">
	<tr>
		<th>아이디</th>
		<th>패스워드</th>
		<th>이름</th>
	</tr>
	<% for(Person person : persons){ %>
	<tr>
		<td><%=person.getId() %></td>
		<td><%=person.getPw() %></td>
		<td><%=person.getName() %></td>.
	</tr>
	<% } %>
</table>


</body>
</html>