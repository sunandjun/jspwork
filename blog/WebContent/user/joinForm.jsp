<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<br />
<br />
<div class="container">
	<form action="/user?cmd=joinProc" method="post">
 
		<div class="form-group">
			<label >유저 이름:</label> 
			<input type="text" class="form-control" placeholder="Enter User Name" name="username"/>
		</div>
		<div class="form-group">
			<label >패스워드:</label> 
			<input type="password" class="form-control" placeholder="Enter password" name="password"/>
		</div>

		<div class="form-group">
			<label >이메일:</label> 
			<input type="email" class="form-control" placeholder="Enter email" name="email"/>
		</div>

		<div class="form-group">
			<label >주소:</label> 
			<button type="button" class="btn btn-warning float-rigth">주소검색</button>
			<input type="text" class="form-control" placeholder="Enter 주소" name="address"/>
		</div>

		<button type="submit" class="btn btn-primary">회원가입</button>
	</form>
</div>
<%@ include file="../layout/footer.jsp"%>