<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="layout/header.jsp" %>

<h1>로그인 페이지</h1>

<!-- 로그인은 Read 하는 것인데 보안을 위해 POST로 전송한다 -->
<form action="loginProc.jsp" method="post">
	<input type="text" name="username" placeholder="UserName"/><br/>
	<input type="password" name="password" placeholder="Password"/><br/>
	<button>로그인</button><br/>
</form>

<%@ include file="layout/footer.jsp" %>