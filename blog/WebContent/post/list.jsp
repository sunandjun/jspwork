<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">

	<div class="m-2">
		<form class="form-inline d-flex justify-content-end" action="/post?cmd=list">
			<input type="text" name="keyword" class="form-control mr-sm-2" placeholder="Search">
			<button class="btn btn-primary m-1">검색</button>
		</form>
	</div>

<c:forEach var="post" items="${posts }">
	<div class="card col-md-12 m-2">
		<div class="card-body">
			<h4 class="card-title">${post.title}</h4>
			<a href="/post?cmd=detail&id=${post.id }" class="btn btn-primary">상세보기</a>
		</div>
	</div>
</c:forEach>

	<br />
	<ul class="pagination justify-content-center">
		<!-- page-item disabled 사용 안되게함 -->
		<c:choose>
			<c:when test="${param.page  >= 3}">
				<li class="page-item" >
					<a class="page-link" href="/post?cmd=list&page=${param.page-3 }">Prev</a>
				</li>
			</c:when>
			<c:otherwise>
				<li class="page-item disabled" >
					<a class="page-link" href="#">Prev</a>
				</li>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${param.page+3  <= totalCount}">
				<li class="page-item">
					<a class="page-link" href="/post?cmd=list&page=${param.page+3 }">Next</a>
				</li>
			</c:when>
			<c:otherwise>
				<li class="page-item disabled">
						<a class="page-link" href="#">Next</a>
					</li>
				</c:otherwise>
		</c:choose>
	</ul>

	<br />
</div>

<%@ include file="../layout/footer.jsp"%>
