<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp" %>

<h1>회원가입페이지</h1>
<!-- form 테그는 데이터를 전송하기 위한 박스 -->
<form action="joinProc.do" method="post">
	<!-- input에 name 이 있어야 전송될 곳에서 값을 확인 할 수 있다. -->
	<input type="text" name="username" placeholder="UserName"/><br/>
	<input type="password" name="password" placeholder="Password"/><br/>
	<input type="email" name="email" placeholder="e-mail"/><br/>
	<button>전송</button> <!-- 버튼은 form 안에 있어야 전송을 한다. -->
</form>


<%@ include file="layout/footer.jsp" %>